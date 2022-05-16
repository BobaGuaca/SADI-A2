package au.edu.rmit.cpt222.model.comms.operations;

import java.io.ObjectOutputStream;

import au.edu.rmit.cpt222.comms.GameEngineServerStub;
import au.edu.rmit.cpt222.model.interfaces.Player;

@SuppressWarnings("serial")
public class AddPlayerCommand extends AbstractGameCommand {

	private Player player;
	
	public AddPlayerCommand(Player player) 
	{
		
		// References current player object with player details
		this.player = player;
		
	}

	@Override
	public void execute(GameEngineServerStub serverStub, ObjectOutputStream responseStream) 
	{
		
		// Associates server with current player and their model for I/O
		serverStub.getModel().addPlayer(player);

	}

}
