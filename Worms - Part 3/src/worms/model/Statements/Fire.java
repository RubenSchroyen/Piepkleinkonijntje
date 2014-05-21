package worms.model.Statements;

import worms.model.Expression;
import worms.model.Program;
import worms.model.Worm;

public class Fire extends Action {

	public Fire(int line, int column, Expression yield) {
		super(line, column, yield);
		// TODO Auto-generated constructor stub
	}
	
	protected void doAction()
	{
		Program program = getRootProgram();
		Worm worm = program.getWorm();
		Object value = getExpressions().get(0).evaluate().getValue();
		if (!(value instanceof Number))
		{
			program.typeErrorOccurred();
			return;
		}	
		if (!worm.canShoot())
		{
			program.stopProgram();
			return;
		}
		
		System.out.println("Firing with a yield of: " + (int)Math.floor((double) value));
		program.getHandler().fire(worm, (int)Math.floor((double) (value)));
	}
}
