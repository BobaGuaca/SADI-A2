package au.edu.rmit.cpt222.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import au.edu.rmit.cpt222.controller.GameToolBarController;

/**
 * Assignment interface for SADI providing main model functionality
 * 
 * @author Mikhail Perepletchikov, Caspar Ryan base implementation
 * @author Joel Rehfeldt, used for correct Assignment 2 implementation
 * 
 */

@SuppressWarnings("serial")
public class GameToolBar extends JPanel 
{

	// Storage for button labels and components
	public static final String FLIP_COMMAND = "Flip";
	public static final String BET_COMMAND = "Bet";
    private JButton flip, bet;
    
    // Storage for controller and view references
	private GameToolBarController controller;
	private MainView mainView;

	public GameToolBar(MainView mainView) 
	{
		
		// Sets up view of tool area, associates it with controller for I/O
		this.setBackground(Color.WHITE);
		this.mainView = mainView;
		this.controller = new GameToolBarController(this);

		// Builds tool buttons, associates listeners with controller for I/O
		this.flip = new JButton(FLIP_COMMAND);
		this.flip.setActionCommand(FLIP_COMMAND);
		this.add(this.flip);
		this.flip.addActionListener(this.controller);

		this.bet = new JButton(BET_COMMAND);
		this.bet.setActionCommand(BET_COMMAND);
		this.add(this.bet);
		this.bet.addActionListener(this.controller);
		
	}

	public MainView getView() 
	{
		
		return this.mainView;
		
	}
	
}
