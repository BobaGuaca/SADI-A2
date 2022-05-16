package au.edu.rmit.cpt222.test.ass2;

import au.edu.rmit.cpt222.comms.Config;
import au.edu.rmit.cpt222.comms.GameEngineServerStub;

public class Server 
{
	
	// Creates a new server instance with associated port
	public static void main(String[] args) 
	{
		
		new GameEngineServerStub(Config.SERVER_PORT);
			
	}

	

}
