package au.edu.rmit.cpt222.model.comms.operations;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import au.edu.rmit.cpt222.comms.GameEngineServerStub;

public interface GameCommand extends Serializable
{
	
	// Command functions that the client stub can call on the server
	// Allows for execution of game methods, e.g. flip, bet etc.
	void execute(GameEngineServerStub serverStub, ObjectOutputStream responseStream);
	
}
