package worms.model.Statements;

import worms.model.Expression;
import worms.model.Statement;

public class Action extends Statement {


	public Action(int line, int column, Expression[] expressions) {
		super(line, column, expressions);
		// TODO Auto-generated constructor stub
	}
	
	public Action(int line, int column, Statement[] statements) {
		super(line, column, statements);
		// TODO Auto-generated constructor stub
	}

	
	public Action(int line, int column) {
		super(line, column);
		// TODO Auto-generated constructor stub
	}

	public Action(int line, int column, Statement[] statements,
			Expression[] expressions) {
		super(line, column, statements, expressions);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
