package au.edu.rmit.cpt222.model;

import java.io.Serializable;

import au.edu.rmit.cpt222.model.exceptions.InsufficientFundsException;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;
import au.edu.rmit.cpt222.model.interfaces.Player;

@SuppressWarnings("serial")
public class SimplePlayer implements Player, Serializable 
{
	
	// Initial player values
	private String id;
	private String name;
	private int points = 0;
	private int bet = 0;
	
	// Initial game values
	private Face currentFacePick = null;
	private GameStatus gameResult = null;
	
	// Constructor to implement player objects
	public SimplePlayer(String id, String name, int defaultCreditPoints) 
	{
		
		// Validates ranges of player input
		assert id != null && name != null && defaultCreditPoints > 0 : "Invalid input values";
		
		// References fields in player to current player object
		this.id = id;
		this.name = name;
		this.points = defaultCreditPoints;
	   
	}
	
	@Override
	public int getBet() 
	{
		
		return this.bet;
		
	}

	@Override
	public Face getFacePick() 
	{
		
		return this.currentFacePick;
		
	}

	@Override
	public String getPlayerId() 
	{
		
		return this.id;
		
	}

	@Override
	public String getPlayerName() 
	{
		
		return this.name;
		
	}

	@Override
	public int getPoints() 
	{
		
		return this.points;
		
	}

	@Override
	public GameStatus getResult() 
	{
		
		return this.gameResult;
		
	}

	@Override
	public void placeBet(Face facePick, int bet) throws InsufficientFundsException 
	{
		
		// Validates correct bet values
		assert bet >= 0 : "invalid bet";

		// Checks to see if player can make a bet
		if (bet <= this.points) 
		{
			
			this.bet = bet;
			this.currentFacePick = facePick;
			
		}
		
		else
		{
			
			throw new InsufficientFundsException();
			
		}
			
	}

	@Override
	public void setPlayerId(String playerId) 
	{
		
		this.id = playerId;
		
	}

	@Override
	public void setPlayerName(String playerName)
	{
		
		this.name = playerName;
		
	}

	@Override
	public void setPoints(int points) 
	{
		
		this.points = points;
		
	}

	@Override
	public void setResult(GameStatus status) 
	{
		
		this.gameResult = status;
		
	}
	
	@Override
	public String toString()
	{
		// Logs updated player information to console
		return  "Player: id = " + this.getPlayerId() + ", name = " + 
				this.getPlayerName() +  ", bet amount = " + this.getBet() + 
				", selected coin face = " + this.getFacePick() + 
				", game result = " + this.getResult() + 
				", total points = " + this.getPoints(); 
		
	}

}
