package au.edu.rmit.cpt222.controller;

import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.GameEngineCallback;
import au.edu.rmit.cpt222.view.GameWindowGUI;
import au.edu.rmit.cpt222.view.MainView;

/**
 * Assignment interface for SADI providing main model functionality
 * 
 * @author Mikhail Perepletchikov, Caspar Ryan base implementation
 * @author Joel Rehfeldt, used for correct Assignment 2 implementation
 * 
 */

// Calls model methods and performs view updates
public class MainController 
{

	
	// Default constants for coin values
	public final static int DEFAULT_FLIP_DELAY = 300;
	public final static int DEFAULT_COIN_DELAY = 500;

	// Storage for game internals and associated view
	private GameEngine model;
	private MainView view;
	
	public MainController(MainView view) 
	{
		
		// References view with model as part of MVC pattern
		this.view = view;
		this.model = view.getModel();
		
		// Creates and adds GUI callback to model
		GameEngineCallback callback = new GameWindowGUI(this);
		this.model.addGameEngineCallback(callback);
		
	}

	public void flip() 
	{
		
		// Calls game internals to flip coin with default values
		this.model.flip(DEFAULT_FLIP_DELAY, DEFAULT_COIN_DELAY);
		
	}

	public void updateView(Face coinFace) 
	{
		
		// Updates GUI with current coin face
		this.view.updateGamePanel(coinFace);
		
	}
	
	public void updatePlayers()
	{
		
		this.view.addPlayer();
		
	}
	
	public void removePlayer()
	{
		
		this.view.removePlayer();
		
	}

}
