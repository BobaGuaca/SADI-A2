package au.edu.rmit.cpt222.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import au.edu.rmit.cpt222.controller.MainController;
import au.edu.rmit.cpt222.model.AddPlayerHandler;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;

/**
 * Assignment interface for SADI providing main model functionality
 * 
 * @author Mikhail Perepletchikov, Caspar Ryan base implementation
 * @author Joel Rehfeldt, used for correct Assignment 2 implementation
 * 
 */

@SuppressWarnings("serial")
public class MainView extends JFrame 
{
	
	// Storage for responsive structures
	private GameEngine model;
	private MainController controller;
	
	// Storage for display structures in GUI
	private GameToolBar toolBar;
	private GamePanel gamePanel;
	private GameMenuBar menuBar;
	private GameHistory historyBox;
	
	// Storage for custom player mechanic handler
	private AddPlayerHandler handler;

	public MainView(GameEngine model) 
	{
		
		// Calls parent to reference model and controller with player handler in relation to GUI frame
		super("CPT222 Assignment 2");
		this.model = model;
		this.controller = new MainController(this);
		this.handler = new AddPlayerHandler();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		initView();
		
	}

	public MainController getController() 
	{
		
		return this.controller;
		
	}

	public GameEngine getModel() 
	{
		
		return this.model;
		
	}

	public void updateGamePanel(Face coinFace) 
	{
		
		// Outputs coin and other values to GUI panel
		this.gamePanel.displayCoin(coinFace);
		
	}
	
	public void addPlayer()
	{
		
		// Manages add player functionality in custom class
		this.handler.addPlayerToGame();
		
	}
	
	public void removePlayer()
	{
		
		this.handler.removePlayerFromGame();
		
	}
	
	private void initView() 
	{
		
		// Creates initial layout for GUI window
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		// Creates initial structures for interactive GUI internals
		this.toolBar = new GameToolBar(this);
		this.gamePanel = new GamePanel(this);
		this.menuBar = new GameMenuBar(this);
		this.historyBox = new GameHistory(this);

		// Adds layout framework to GUI internals
		this.add(this.toolBar, BorderLayout.NORTH);
		this.add(this.gamePanel, BorderLayout.CENTER);
		this.add(this.historyBox, BorderLayout.WEST);
		this.setJMenuBar(this.menuBar);

	}
	
}
