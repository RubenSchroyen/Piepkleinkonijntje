package worms.model.Statements;

import worms.model.Expression;
import worms.model.Statement;

public abstract class Action extends Statement {

	protected abstract void doAction();

	public Action(int line, int column, Expression expression) {
		super(line, column, new Expression[] {expression});
		// TODO Auto-generated constructor stub
	}
	

	
	public Action(int line, int column) {
		super(line, column);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() 
	{
		// TODO Auto-generated method stub
		if (!getRootProgram().continueExecution())
			return;
		if (getRootProgram().getCurrentLine() > getLine())
			return;
		beforeExecute();
		doAction();
		
	}

}
