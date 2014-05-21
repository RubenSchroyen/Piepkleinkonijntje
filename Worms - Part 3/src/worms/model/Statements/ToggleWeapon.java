package worms.model.Statements;

import worms.model.Program;


public class ToggleWeapon extends Action {

	public ToggleWeapon(int line, int column) {
		super(line, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doAction() {
		// TODO Auto-generated method stub
		Program program = getRootProgram();
		System.out.println("Toggling weapon");
		program.getHandler().toggleWeapon(program.getWorm());
		
	}

}
