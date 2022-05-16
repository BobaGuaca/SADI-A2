package au.edu.rmit.cpt222.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import au.edu.rmit.cpt222.controller.GameMenuBarController;

/**
 * Assignment interface for SADI providing main model functionality
 * 
 * @author Mikhail Perepletchikov, Caspar Ryan base implementation
 * @author Joel Rehfeldt, used for correct Assignment 2 implementation
 * 
 */

@SuppressWarnings("serial")
public class GameMenuBar extends JMenuBar 
{
	
	// Storage for main view and control structures
	private MainView mainView;
	private GameMenuBarController controller;
	
	// Storage for menu item tags
	public static final String ADD_PLAYER = "Add player";
	public static final String REMOVE_PLAYER = "Remove player";
	public static final String VIEW_HISTORY = "View history";
	
	// Storage for menu item components
	private JMenu dropMenu;
	public JMenuItem addPlayerOption;
	private JMenuItem editPlayerOption;
	private JMenuItem viewGameHistoryOption;

	public GameMenuBar(MainView mainView) 
	{
		
		// References view to menu controller
		this.mainView = mainView;
		this.controller = new GameMenuBarController(this);

		// Generates menu elements
		dropMenu = new JMenu("Game menu");
		addPlayerOption = new JMenuItem(ADD_PLAYER);
		
		// Associates action responses to menu items
		this.addPlayerOption.setActionCommand(ADD_PLAYER);
		this.add(this.addPlayerOption);
		
		// Associates listener to controller so that controller can manage inputs from various listeners
		this.addPlayerOption.addActionListener(this.controller);

		editPlayerOption = new JMenuItem(REMOVE_PLAYER);
		this.editPlayerOption.setActionCommand(REMOVE_PLAYER);
		this.add(this.editPlayerOption);
		this.editPlayerOption.addActionListener(this.controller);

		viewGameHistoryOption = new JMenuItem(VIEW_HISTORY);
		this.viewGameHistoryOption.setActionCommand(VIEW_HISTORY);
		this.add(this.viewGameHistoryOption);
		this.viewGameHistoryOption.addActionListener(this.controller);
		
		// Adds menu elements to base menu structure, adds structure to root frame
		dropMenu.add(addPlayerOption);
		dropMenu.add(editPlayerOption);
		dropMenu.add(viewGameHistoryOption);
		this.add(dropMenu);
			
	}

	// Presents current view to model, updates when changes are made
	public MainView getView() 
	{
		
		return this.mainView;
		
	}

}
