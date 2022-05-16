package au.edu.rmit.cpt222.comms;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

import au.edu.rmit.cpt222.model.GameEngineImpl;

public class GameEngineServerStub 
{
	
	// New model for interacting with game internals
	private GameEngineImpl model = new GameEngineImpl();

	public GameEngineServerStub(int serverPort) 
	{
	
		// Open up server socket to listen for incoming client requests
		// Responsible for calling methods for server side Game Engine Clients
		try 
		{
			
			// Creates server socket for new incoming client requests
			ServerSocket serverSocket = new ServerSocket(serverPort);
			System.out.println("Server on port " + serverPort + 
					" waiting for connection");
			
			// Loop and accept multiple clients until connection is terminated
			while(!serverSocket.isClosed())
			{
				
				//Custom threads created for all incoming client comms
				try 
				{
					
					// Delegate incoming client connections to different server sockets/threads
					new RequestTask(this, serverSocket.accept()).start();
					
				}
				
				catch (SocketException e)
				{
					
					// Check client connection to thread and close socket if client disconnects
					serverSocket.close();
				}
				
			}
			
		} 
		
		catch (IOException e) 
		{
			
			// Checks for incorrect server input
			e.printStackTrace();
			
		}
		
	}

	public void addGameEngineCallback(HostDetails details)
	{
		
		// Updates console log with incoming client connection
		System.out.println("Client connected " + details.toString());
		
		// Stores host details to broadcast relevant info and record set of callbacks
		this.model.addGameEngineCallback(new ServerStubGameEngineCallback(details));
		
	}
	
	// Fetches game model to utilise engine functions
	public GameEngineImpl getModel()
	{
		
		return this.model;
		
	}

}
