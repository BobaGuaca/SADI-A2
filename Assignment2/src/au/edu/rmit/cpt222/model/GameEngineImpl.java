package au.edu.rmit.cpt222.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import au.edu.rmit.cpt222.model.exceptions.InsufficientFundsException;
import au.edu.rmit.cpt222.model.interfaces.Coin;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.GameEngineCallback;
import au.edu.rmit.cpt222.model.interfaces.Player;

/**
 * Assignment interface for SADI providing main model functionality
 * 
 * @author Mikhail Perepletchikov, Caspar Ryan base implementation
 * @author Joel Rehfeldt, used for correct Assignment 2 implementation
 * 
 */

public class GameEngineImpl implements GameEngine 
{


	// Collection of player IDs and associated player objects
	private Map<String, Player> players = new ConcurrentHashMap<String, Player>();
	
	// Collection of coin objects currently in the game
	private List<Coin> coins = new ArrayList<Coin>(GameEngine.NUM_OF_COINS);
	
	// Organised collection of game engine interactions
	private Set<GameEngineCallback> gameEngineCallbacks = Collections
			.newSetFromMap(new ConcurrentHashMap<GameEngineCallback, Boolean>());

	// Called to initiate a collection for coins
	public GameEngineImpl() 
	{
		
		// Initialises coins by calling coin constructor until there are two coins
		for (int i = 0; i < GameEngine.NUM_OF_COINS; i++)
		{
			
			this.coins.add(new CoinImpl());
			
		}
			
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		
		// Attaches a game engine interaction to current object
		this.gameEngineCallbacks.add(gameEngineCallback);
		
	}

	@Override
	public void addPlayer(Player player) 
	{
		
		// Attaches a player object to current game
		this.players.put(player.getPlayerId(), player);
		
	}

	@Override
	public void calculateResult() 
	{

		// Iterates through player collection to determine player properties
		for (Player player : this.players.values())
		{
			
			// Determine game outcome given a specific result
			processGameOutcome(player);
			
		}
			

		// Iterates through interactions with engine callbacks to generate game logs
		for (GameEngineCallback gameEngineCallback : this.gameEngineCallbacks)
		{
			
			// Iterates through interactions with players to generate game values
			for (Player player : this.players.values())
			{
				
				// Logs game information to console
				gameEngineCallback.gameResult(player, player.getResult(),
						GameEngineImpl.this);
				
			}
			
		}
			
	}

	@Override
	public void flip(int flipDelay, int coinDelay) 
	{
		
		// Evaluates given flip method parameters to ensure correct values are given
		assert flipDelay >= 0 && coinDelay >= 0 : "invalid delay";

		// Flips pre-specified number of coins
		for (int i = 0; i < this.coins.size(); i++) 
		{
			
			// Generates a thread to flip current coin independent of other game processes
			try 
			{
				
				Thread.sleep(coinDelay);
				
			} 
			
			catch (InterruptedException e) 
			{
				
				e.printStackTrace();
				
			}
			
			// Generates a random amount of coins to flip
			int flipNumber = (int) (Math.random() * 10);

			// Flips the predetermined number of coins until there are none left
			for (int j = 0; j <= flipNumber; j++) 
			{
				
				// Pauses current thread to introduce gap between different coin flips
				try 
				{
					
					Thread.sleep(flipDelay);
					
				} 
				
				catch (InterruptedException e) 
				{
					
					e.printStackTrace();
					
				}
				
				// Simulates coin flip by calling method to change coin face
				this.coins.get(i).swapFace();
				
				// Logs final coin face within current game object to game engine
				for (GameEngineCallback gameEngineCallback : this.gameEngineCallbacks)
				{
					
					// for (Player p : players.values())
					gameEngineCallback.coinFlip(this.coins.get(i)
							.getCurrentFace(), GameEngineImpl.this);
					
				}
					
			}
			
			// Updates logger with coin flip outcome for console output
			for (GameEngineCallback gameEngineCallback : this.gameEngineCallbacks)
			{
				
				gameEngineCallback.coinFlipOutcome(this.coins.get(i)
					.getCurrentFace(), GameEngineImpl.this);
				
			}
			
				
		}
		
		// Coin flip results are combined with bets to determine game outcome
		calculateResult();
		
	}

	@Override
	public Collection<Player> getAllPlayers() 
	{
		
		return Collections.unmodifiableCollection(new ArrayList<Player>(
				this.players.values()));
		
	}

	@Override
	public Player getPlayer(String id) 
	{
		
		return this.players.get(id);
		
	}

	@Override
	public void placeBet(Player player, Coin.Face face, int bet)
			throws InsufficientFundsException 
	{
		
		// Set default values for player if no values have been set
		player = (player != null) ? getPlayer(player.getPlayerId()) : null;

		// Resets the players bet 
		player.placeBet(face, bet);
		
	}

	@Override
	public void removeGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		
		// Removes callbacks pending client or server disconnection
		this.gameEngineCallbacks.remove(gameEngineCallback);

	}

	@Override
	public boolean removePlayer(Player player) 
	{
		
		// Searches map given player values to remove a player from map
		return this.players.remove(player.getPlayerId()) != null ? true : false;
		
	}

	@Override
	public void setPlayerPoints(Player player, int totalPoints) 
	{
		
		// Determines player existence, updates points
		player = (player != null) ? getPlayer(player.getPlayerId()) : null;
		player.setPoints(totalPoints);
		

	}
	

	// Calculates game outcome given a coin vale
	private void processGameOutcome(Player player) 
	{
		
		// Determines current player coin face pick
		Coin.Face selected = player.getFacePick();
		
		// Stores number of matches played for game outcome
		int match = 0;
		
		// Iterates through coins and increments/decrement match wins depending on the state
		for (Coin coin : this.coins)
		{
			
			if (coin.getCurrentFace().equals(selected))
			{
				
				match++;
				
			}
				
			else
			{
				
				match--;
				
			}
				
			
		}
		
		// Checks tally of coin wins per player to determine game outcome
		if (match == this.coins.size()) 
		{
			
			player.setResult(GameStatus.WON);
			player.setPoints(player.getPoints() + player.getBet());
			
		} 
		
		else if (match == Math.negateExact(this.coins.size())) 
		{
			
			player.setResult(GameStatus.LOST);
			player.setPoints(player.getPoints() - player.getBet());
			
		} 
		
		else
		{
			
			player.setResult(GameStatus.DREW);
			
		}
			
	}
}
