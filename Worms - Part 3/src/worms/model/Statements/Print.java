package worms.model.Statements;

import worms.model.Expression;
import worms.model.Statement;

public class Print extends Statement {

	public Print(int line, int column, Expression e) {
		super(line, column, new Expression[] {e});
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
		System.out.println(getExpressions().get(0).evaluate().getValue());
	}

}
