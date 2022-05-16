package au.edu.rmit.cpt222.comms;

import au.edu.rmit.cpt222.model.interfaces.Coin.Face;

import java.util.logging.Level;
import java.util.logging.Logger;

import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;
import au.edu.rmit.cpt222.model.interfaces.GameEngineCallback;
import au.edu.rmit.cpt222.model.interfaces.Player;

public class ServerStubGameEngineCallback implements GameEngineCallback 
{
	
	private Logger logger = Logger.getLogger("Ass 2 ");

	// Connect to all players to broadcast all relevant game info
	public ServerStubGameEngineCallback(HostDetails details) 
	{
		
		this.logger.log(Level.INFO,  String.valueOf(details));
		
	}

	
	@Override
	public void coinFlip(Face coinFace, GameEngine engine) 
	{
		
		this.logger.log(Level.INFO,  String.valueOf(coinFace));
		
	}

	@Override
	public void coinFlipOutcome(Face coinFace, GameEngine engine) 
	{
		
		this.logger.log(Level.INFO,  String.valueOf(coinFace));

	}

	@Override
	public void gameResult(Player player, GameStatus result, GameEngine engine)
	{
		
		this.logger.log(Level.INFO,  String.valueOf(result));

	}

}
