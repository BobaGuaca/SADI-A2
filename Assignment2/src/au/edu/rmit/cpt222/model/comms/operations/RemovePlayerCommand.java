package au.edu.rmit.cpt222.model.comms.operations;

import java.io.ObjectOutputStream;

import au.edu.rmit.cpt222.comms.GameEngineServerStub;
import au.edu.rmit.cpt222.model.interfaces.Player;

@SuppressWarnings("serial")
public class RemovePlayerCommand extends AbstractGameCommand 
{

	private Player player;
	
	public RemovePlayerCommand(Player player) 
	{
		
		// References current player with player details for removal
		this.player = player;
		
	}
	@Override
	public void execute(GameEngineServerStub serverStub, ObjectOutputStream responseStream) 
	{
		
		// Checks to see if player exists, then calls game internals to remove player
		if(this.player != null)
		{
			
			serverStub.getModel().removePlayer(player);
			
		}

	}

}
