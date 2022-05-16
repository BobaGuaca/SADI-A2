package au.edu.rmit.cpt222.model.comms.operations;

import java.io.ObjectOutputStream;

import au.edu.rmit.cpt222.comms.GameEngineServerStub;
import au.edu.rmit.cpt222.comms.HostDetails;

@SuppressWarnings("serial")
public class AddCallbackCommand extends AbstractGameCommand 
{

	private HostDetails details;
	
	
	public AddCallbackCommand(HostDetails details) 
	{
		
		// References host object to current details
		this.details = details;
		
	}



	@Override
	public void execute(GameEngineServerStub serverStub, ObjectOutputStream responseStream)
	{
		
		// Adds a new engine callback using host details
		serverStub.addGameEngineCallback(this.details);

	}

}
