package au.edu.rmit.cpt222.model.comms.operations;

import java.io.ObjectOutputStream;

import au.edu.rmit.cpt222.comms.GameEngineServerStub;

@SuppressWarnings("serial")
public abstract class AbstractGameCommand implements GameCommand 
{
	
	// Enables command subclasses to implement their own structures
	@Override
	public abstract void execute(GameEngineServerStub serverStub, ObjectOutputStream responseStream);
		
	// Call toString operations in one place rather than in each class
		@Override
		public String toString()
		{
			
			return this.getClass().getName();
			
		}
	
}
