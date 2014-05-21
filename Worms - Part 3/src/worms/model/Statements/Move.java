package worms.model.Statements;

import worms.model.Program;
import worms.model.Worm;

public class Move extends Action{

	public Move(int line, int column) {
		super(line, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doAction() {
		// TODO Auto-generated method stub
		Program program = getRootProgram();
		Worm worm = program.getWorm();
		if ( !worm.canMove() ) 
		{
			program.stopProgram();
			return;
		}
		System.out.println("Moving ");
		program.getHandler().move(worm);
	}

}
