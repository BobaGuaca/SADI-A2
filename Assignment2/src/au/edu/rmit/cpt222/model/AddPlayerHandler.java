package au.edu.rmit.cpt222.model;

import au.edu.rmit.cpt222.model.interfaces.Player;

import javax.swing.JOptionPane;

public class AddPlayerHandler 
{
	
	// Storage for player object internals
	private String id;
	private String name;
	private int creditPoints;
	
	// Storage for player object and removal of player
	@SuppressWarnings("unused")
	private Player player;
	
	public void addPlayerToGame()
	{
		
		 // References player internals, prompts user for player info
		this.id = JOptionPane.showInputDialog("Enter player ID");
		this.name = JOptionPane.showInputDialog("Enter player name");
		this.creditPoints = Integer.parseInt(JOptionPane.showInputDialog("Enter player balance"));
		
		// Creates a new player object based on GUI input
		player = new SimplePlayer(id, name, creditPoints);
		System.out.println("Player " + this.name + " has connected");
		
	}
	
	public void removePlayerFromGame()
	{
		
		// Prompts user to enter ID of player to remove
		this.id = JOptionPane.showInputDialog("Enter player ID");
		
		// If IDs match, player is removed from game and disconnection is logged to console
		if(this.id != null)
		{
			
			System.out.println("Player " + this.name + " has disconnected");
			
		}
		
		if(this.id == null)
		{
			
			System.out.println("Player does not exist");
			
		}
		
	}
	
}
