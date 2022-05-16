package au.edu.rmit.cpt222.comms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import au.edu.rmit.cpt222.model.comms.operations.GameCommand;

// All handling of individual client requests managed on a per thread basis
public class RequestTask extends Thread 
{

	// Storage for client/server connection details
	private Socket clientSocket;
	private GameEngineServerStub serverStub;
	
	
	public RequestTask(GameEngineServerStub gameEngineServerStub, Socket socket) 
	{
		
		// References current client/server connection
		this.clientSocket = socket;
		this.serverStub = gameEngineServerStub;
		
		
	}
	
	@Override
	public void run()
	{
		
		// Open streams to send and receive data to/from client of server
		try 
		{
			
			ObjectOutputStream responseStream = new ObjectOutputStream(
					clientSocket.getOutputStream());
			
			ObjectInputStream requestStream = new ObjectInputStream(
					clientSocket.getInputStream());
			
			//Main loop to receive commands
			while(!clientSocket.isClosed())
			{
				
				try 
				{
					
				// 1) Read in command(s) from client
				GameCommand command = (GameCommand) requestStream.readObject();
				
				// 2) Perform operations using cmd.exe() method
				command.execute(this.serverStub, responseStream);
				
				}
				
				catch (SocketException e)
				{
					
					// Checks to see if client disconnects and terminates socket
					System.out.println("Client connection terminated");
					clientSocket.close();
					
				}
				
				
				catch (ClassNotFoundException e) 
				{
					
					// Catches incorrect class calls for commands etc.
					e.printStackTrace();
					
				}
				
			}
			
		}
		
		catch (IOException e) 
		{
			
			// Catches incorrect client inputs
			e.printStackTrace();
			
		}
		
	}
	
}
