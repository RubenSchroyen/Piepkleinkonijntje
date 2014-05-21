package worms.model.Statements;

import worms.model.Expression;
import worms.model.Statement;

public class While extends Statement {

	public While(int line, int column, Expression condition, Statement body) {
		super(line, column, new Statement[] {body}, new Expression[] {condition});
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if (!getRootProgram().continueExecution())
			return;
		
		if (getRootProgram().getCurrentLine() > getLine())
			return;
		
		beforeExecute();
		Object value = getExpressions().get(0).evaluate().getValue();
		if ( !(value instanceof Boolean) ) 
		{
			getProgram().typeErrorOccurred();
			return;
		}
		while ((boolean)value) 
		{
			if (!getRootProgram().continueExecution())
				return;
			getStatements().get(0).execute();
			getRootProgram().setCurrentLine(getLine());
			getRootProgram().setCurrentColumn(getColumn());
		}
		
	}

}
