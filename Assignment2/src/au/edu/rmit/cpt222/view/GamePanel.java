package au.edu.rmit.cpt222.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import au.edu.rmit.cpt222.model.interfaces.Coin.Face;

/**
 * Assignment interface for SADI providing main model functionality
 * 
 * @author Mikhail Perepletchikov, Caspar Ryan base implementation
 * @author Joel Rehfeldt, used for correct Assignment 2 implementation
 * 
 */

@SuppressWarnings("serial")
public class GamePanel extends JPanel 
{

	@SuppressWarnings("unused")
	// Storage for main display panel components
	private MainView mainView;
	private JLabel displayOutput;

	public GamePanel(MainView mainView) 
	{
		
		// References panel components to current view, prompts user for action
		this.mainView = mainView;
		this.displayOutput = new JLabel("Choose an option");
		this.add(this.displayOutput);
		
	}

	public void displayCoin(Face coinFace)
	{
		
		// Shows current coin face in game panel
		this.displayOutput.setText(coinFace.toString());

	}
	
}
