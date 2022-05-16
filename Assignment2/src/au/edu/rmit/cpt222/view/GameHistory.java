package au.edu.rmit.cpt222.view;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameHistory extends JPanel 
{
	
	@SuppressWarnings("unused")
	private MainView mainView;
	
	// Builds a space for game history to be displayed
	public GameHistory(MainView mainView)
	{
		
		this.setBackground(Color.YELLOW);
		this.mainView = mainView;
		
	}
}
