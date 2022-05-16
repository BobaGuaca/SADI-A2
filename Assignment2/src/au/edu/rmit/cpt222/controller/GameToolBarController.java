package au.edu.rmit.cpt222.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import au.edu.rmit.cpt222.view.GameToolBar;

/**
 * Assignment interface for SADI providing main model functionality
 * 
 * @author Mikhail Perepletchikov, Caspar Ryan base implementation
 * @author Joel Rehfeldt, used for correct Assignment 2 implementation
 * 
 */

public class GameToolBarController implements ActionListener 
{

	// Storage for toolbar/controller components
	private GameToolBar toolBar;
	
	@SuppressWarnings("unused")
	private MainController controller;

	public GameToolBarController(GameToolBar gameToolBar) 
	{
		
		// References tool bar with controller and view to present content
		this.toolBar = gameToolBar;
		this.controller = this.toolBar.getView().getController();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		// Responds to user input with appropriate engine response
		if (e.getActionCommand() == GameToolBar.FLIP_COMMAND)
		{
			
			// Placeholder method for flip mechanic
			/*this.controller.flip();*/
			
			System.out.println("Simulating coin flip...");
			
		}
		
		if (e.getActionCommand() == GameToolBar.BET_COMMAND)
		{
			
			// Placeholder method for bet mechanic
			/*this.controller.placeBet();*/
			
			System.out.println("Placing bet...");
			
		}
			
	}
	
}
