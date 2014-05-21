package worms.model.Statements;

import worms.model.Program;
import worms.model.Worm;

public class Jump extends Action {

	public Jump(int line, int column) {
		super(line, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doAction() {
		// TODO Auto-generated method stub
		Program program = getRootProgram();
		Worm worm = program.getWorm();
		if (!worm.canJump())
		{
			program.stopProgram();
			return;
		}
		System.out.println("Jumping");
		program.getHandler().jump(worm);
	}

}
