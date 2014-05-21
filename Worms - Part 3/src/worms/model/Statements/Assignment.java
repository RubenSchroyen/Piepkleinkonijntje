package worms.model.Statements;

import worms.model.Expression;
import worms.model.Statement;

public class Assignment extends Statement {

	private String variable;

	public Assignment(int line, int column, String variableName, Expression rhs) {
		super(line, column, new Expression[] {rhs});
		this.variable = variableName;
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
		getRootProgram().assignVariable(variable, getExpressions().get(0).evaluate());
	}

}
