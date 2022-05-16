package au.edu.rmit.cpt222.model.comms;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collection;

import au.edu.rmit.cpt222.comms.Config;
import au.edu.rmit.cpt222.comms.HostDetails;
import au.edu.rmit.cpt222.model.comms.operations.AddCallbackCommand;
import au.edu.rmit.cpt222.model.comms.operations.AddPlayerCommand;
import au.edu.rmit.cpt222.model.exceptions.InsufficientFundsException;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.GameEngineCallback;
import au.edu.rmit.cpt222.model.interfaces.Player;

@SuppressWarnings("serial")
public class GameEngineClientStub implements GameEngine, Serializable 
{
	
	//Streams to/from the ServerStub, sending an object from client to server
	private ObjectOutputStream requestStream;
	@SuppressWarnings("unused")
	private ObjectInputStream responseStream;
	@SuppressWarnings("unused")
	private GameEngineCallback callback;
	private Socket clientSocket;
	
	// Link from client stub to client callback
	private ClientGameEngineCallbackServer callbackServer;
	
	public GameEngineClientStub()
	{
		
		//Open a socket to perform client/server communications
		try 
		{
			
			// Create new socket, assocaite it with new I/O streams
			clientSocket = new Socket(Config.SERVER_HOST, 
					Config.SERVER_PORT);
			
				this.requestStream = new ObjectOutputStream(
						clientSocket.getOutputStream());
				
				this.responseStream = new ObjectInputStream(
						clientSocket.getInputStream());
					
		} 
		
		
		catch (UnknownHostException e) 
		{
		
			// Stops unrelated hosts from connecting to the server
			System.out.println("Unknown host connection");
			e.printStackTrace();
			
		} 
		catch (IOException e) 
		{
			
			// Catches illegal input from client
			e.printStackTrace();
			
		}
		
		// Enables GUI callback invocation based on client requests
		this.callbackServer = new ClientGameEngineCallbackServer();
		
		// Connects client with provided details to server callback on a given port
		this.registerGECallbackServer(new HostDetails 
				(Config.SERVER_HOST, this.callbackServer.getSocketPort()));
		
	}
	
	
	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		
		// Links individual client callback to overall game engine callbacks
		this.callback = gameEngineCallback;
		
	}

	@Override
	public void addPlayer(Player player) 
	{
		
		// Use output stream to send data to server to invoke addPlayer
		try 
		{
			
			this.requestStream.writeObject(new AddPlayerCommand(player));
			
		} 
		
		catch (IOException e) 
		{
			
			// Catches illegal player input from client
			e.printStackTrace();
		}
		
	}

	@Override
	public void calculateResult() 
	{
		
		// Sends calculate request to server in current object
		this.calculateResult();

	}

	@Override
	public void flip(int flipDelay, int coinDelay) 
	{
		
		// Flips coin within current game client
		this.flip(flipDelay, coinDelay);
	
	}

	@Override
	public Collection<Player> getAllPlayers() 
	{
		
		// Allows player list to be queried for history
		return this.getAllPlayers();
		
	}

	@Override
	public Player getPlayer(String id) 
	{
		
		return this.getPlayer(id);
		
	}

	@Override
	public void placeBet(Player player, Face face, int bet) throws InsufficientFundsException 
	{
		
		this.placeBet(player, face, bet);

	}

	@Override
	public void removeGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		
		// Removes callbacks should a client disconnect
		this.removeGameEngineCallback(gameEngineCallback);

	}

	@Override
	public boolean removePlayer(Player player) 
	{
		
		return false;
		
	}

	@Override
	public void setPlayerPoints(Player player, int totalPoints) 
	{
		
		this.setPlayerPoints(player, totalPoints);

	}
	
	private void registerGECallbackServer(HostDetails hostDetails)
	{
		
		// Adds callback commands between client stub and callback server
		try 
		{
			
			this.requestStream.writeObject(new AddCallbackCommand(hostDetails));
		
		} 
		
		catch (IOException e) 
		{
			
			// Catches illegal callback input
			e.printStackTrace();
			
		}
		
	}

}
