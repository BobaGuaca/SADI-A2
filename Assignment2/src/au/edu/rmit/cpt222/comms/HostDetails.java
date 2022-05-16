package au.edu.rmit.cpt222.comms;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HostDetails implements Serializable
{
	
	// Storage for host information
	private String hostName;
	private int hostPort;
	
	// Tidies up host details for higher cohesion
	// Sent from client stub to server stub for callback server location
	public HostDetails(String hostName, int hostPort) 
	{
		
		this.hostName = hostName;
		this.hostPort = hostPort;
		
	}

	public String getHostName() 
	{
		
		return this.hostName;
		
	}

	public int getHostPort() 
	{
		
		return this.hostPort;
		
	}
	
	
	@Override
	public String toString()
	{
		
		return this.hostName + " : " + this.hostPort;
		
	}
	
}
