package au.edu.rmit.cpt222.model;

import java.io.Serializable;
import java.util.Random;
import au.edu.rmit.cpt222.model.interfaces.Coin;

@SuppressWarnings("serial")
public class CoinImpl implements Coin, Serializable 
{
	
	// Initialisation of coin face structures
	private Face [] faces = { Face.heads, Face.tails };
	private Face currentFace = null;
	
	// Default constructor for coin object
	public CoinImpl() 
	{
	
	// Generation of a random coin face to insert into coin object (from lectures)
	int randomFace = new Random().nextInt(this.faces.length);
	setCurrentFace(this.faces[randomFace]);
	
	}
	
	@Override
	public Face getCurrentFace() 
	{
		
		return currentFace;
		
	}

	@Override
	public void setCurrentFace(Face currentFace) 
	{
		
		// Sets the instance coin face to the parameter given
		this.currentFace = currentFace;

	}

	@Override
	public void swapFace() 
	{
		
		// Evaluates the current coin face and sets the face to the opposite to simulate coin flip
		if(currentFace.equals(Face.heads))
		{
			
			currentFace = Face.tails;
			
		}
		
		else
		{
		
			currentFace = Face.heads;
			
		}

	}

}
