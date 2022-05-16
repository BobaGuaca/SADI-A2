package au.edu.rmit.cpt222.driver;

import javax.swing.*;

//import au.edu.rmit.cpt222.model.GameEngineImpl;
import au.edu.rmit.cpt222.model.comms.GameEngineClientStub;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.view.MainView;

/*
 * NOTE! I provide a driver constructor for declaring then initialising functionality
 * Not technically needed, more for highlighting what's happening while I program
 * 
 * */
public class Ass2Driver 
{
	
	// Constructor to initialise main game behaviours
	private Ass2Driver(GameEngine model) 
	{
				
		// Creates a new view associated with game engine internals
		MainView mainView = new MainView(model);
		
		// Toggles GUI visibility
		mainView.setVisible(true);
				
	}
	
	public static void main(String[] args) 
	{
		
		// Creates a new model for clients to utilise for game
		final GameEngine model = new GameEngineClientStub();
		
		// Starts a new thread to allow for multiple clients
		SwingUtilities.invokeLater( new Runnable()
			
				{
				@Override
					public void run() 
					{
					
						new Ass2Driver(model);
						
					}
				});
		
	}
		
}
	


