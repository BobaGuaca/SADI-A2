package au.edu.rmit.cpt222.model.comms;

import java.io.IOException;
import java.net.ServerSocket;

public class ClientGameEngineCallbackServer 
{

	// Storage for server socket for each individual client
	private ServerSocket serverSocket;
	
	public ClientGameEngineCallbackServer() 
	{
		
			try 
			{
				// Creates socket to avoid blocking for incoming connections
				this.serverSocket = new ServerSocket(0);
				
			} 
			
			catch (IOException e) 
			{
				
				// Catches incorrect server input
				e.printStackTrace();
				
			}
			
			// Outputs status of currently waiting server with open port info
			System.out.println("Callback server on port " + getSocketPort()  + 
					" waiting for connection");
			
	}

	// Assigns a local port to each socket automatically
	public int getSocketPort() 
	{
		
		return serverSocket.getLocalPort();
		
	}

}
