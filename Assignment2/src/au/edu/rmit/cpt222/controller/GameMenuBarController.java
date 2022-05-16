package au.edu.rmit.cpt222.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import au.edu.rmit.cpt222.view.GameMenuBar;

/**
 * Assignment interface for SADI providing main model functionality
 * 
 * @author Mikhail Perepletchikov, Caspar Ryan base implementation
 * @author Joel Rehfeldt, used for correct Assignment 2 implementation
 * 
 */

public class GameMenuBarController implements ActionListener 
{

	// Storage for menu/controller elements
	private GameMenuBar menuBar;
	private MainController controller;

	public GameMenuBarController(GameMenuBar gameMenuBar) 
	{
		
		// References tools with controller and view to present content
		this.menuBar = gameMenuBar;
		this.controller = this.menuBar.getView().getController();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		// Action responses for menu items to provide response
		 if (e.getActionCommand() == GameMenuBar.ADD_PLAYER)
		 {
			
			 
			this.controller.updatePlayers();
			 
		 }
		 
		 if (e.getActionCommand() == GameMenuBar.REMOVE_PLAYER)
		 {
			
			 this.controller.removePlayer();
			 
		 }
		 
		 
		 if (e.getActionCommand() == GameMenuBar.VIEW_HISTORY)
		 {
			
			// Yet to be implemented
			 
		 }
		
	}

}
