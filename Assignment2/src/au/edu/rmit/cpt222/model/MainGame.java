package au.edu.rmit.cpt222.model;

import au.edu.rmit.cpt222.model.exceptions.InsufficientFundsException;
import au.edu.rmit.cpt222.model.interfaces.Coin;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;
import au.edu.rmit.cpt222.model.interfaces.Player;

public class MainGame 
{
	
	// Storage for game object data for each player
	private GameStatus gameResult;
	private Coin coinFace;
	private int playerBet;
	private SimplePlayer player;
	
	// Game object referring to many player objects in current game
	public MainGame(GameStatus gameResult, Coin betFace, int playerBet, SimplePlayer player)
	{
		
		this.gameResult = gameResult;
		this.coinFace = betFace;
		this.playerBet = playerBet;
		this.player = player;
		
	}
	
	public GameStatus getGameResult()
	{
		
		return this.gameResult;
		
	}
	
	public Coin getCoinFace()
	{
		
		return this.coinFace;
		
	}
	
	public int getPlayerBet()
	{
		
		return this.playerBet;
		
	}
	
	public Player getPlayer()
	{
		
		return this.player;
		
	}
	
	@Override
	public String toString()
	{
		// Logs updated player information to console
		return  "Player: name = " + this.getPlayer() +  ", bet amount = " + this.getPlayerBet() + 
				", selected coin face = " + this.getCoinFace() + 
				", game result = " + this.getGameResult(); 
		
	}

	// Setters for editing player details or adjusting bet
	public void setPlayerName(String name) 
	{
		
		player.setPlayerName(name);
		
	}

	public void setPlayerBet(Face coinFace, int bet) throws InsufficientFundsException 
	{
		
		player.placeBet(coinFace, bet);
		
	}
	
	
}
