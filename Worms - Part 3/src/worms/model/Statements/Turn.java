package worms.model.Statements;

import worms.model.Expression;
import worms.model.Program;
import worms.model.Worm;

public class Turn extends Action {

	public Turn(int line, int column, Expression angle) {
		// TODO Auto-generated constructor stub
		super(line, column);
	}

	@Override
	protected void doAction() {
		// TODO Auto-generated method stub
		Program program = getRootProgram();
		Worm worm = program.getWorm();
		Object value = getExpressions().get(0).evaluate().getValue(); 
		if ( !(value instanceof Number) ) 
		{ 
			program.typeErrorOccurred();
			return;
		}
		if ( !worm.isValidTurn((double)value) ) 
		{
			program.stopProgram();
			return;
		}
		System.out.println("Turning with angle: " + (double)(value));
		program.getHandler().turn(worm, (double)(value));
	}

}
