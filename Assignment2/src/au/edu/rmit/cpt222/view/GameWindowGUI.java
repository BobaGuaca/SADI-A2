package au.edu.rmit.cpt222.view;

import au.edu.rmit.cpt222.controller.MainController;
import au.edu.rmit.cpt222.model.GameEngineCallbackImpl;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;
import au.edu.rmit.cpt222.model.interfaces.Player;

/**
 * Assignment interface for SADI providing main model functionality
 * 
 * @author Mikhail Perepletchikov, Caspar Ryan base implementation
 * @author Joel Rehfeldt, used for correct Assignment 2 implementation
 * 
 */

public class GameWindowGUI extends GameEngineCallbackImpl 
{

	private MainController controller;

	public GameWindowGUI(MainController mainController) 
	{
		
		// References GUI output to game controller
		this.controller = mainController;
		
	}

	@Override
	public void coinFlip(Face coinFace, GameEngine engine) 
	{
		
		// Calls on parent to use flip functionality
		super.coinFlip(coinFace, engine);
		
		// Calls controller to update GUI output
		this.controller.updateView(coinFace);
		
	}

	@Override
	public void coinFlipOutcome(Face coinFace, GameEngine engine) 
	{
		// Calls on parent to use flip outcomes
		super.coinFlipOutcome(coinFace, engine);
		this.controller.updateView(coinFace);
		
	}

	@Override
	public void gameResult(Player player, GameStatus result, GameEngine engine) 
	{
		
		// Calls on parent to show game result with player and game values
		super.gameResult(player, result, engine);
		
	}
	
}
