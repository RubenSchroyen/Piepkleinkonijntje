package worms.model.Statements;

import worms.model.Expression;
import worms.model.Statement;

public class IfThenElse extends Statement {

	public IfThenElse(int line, int column, Expression condition,
			Statement then, Statement otherwise) {
		super(line, column, new Statement[] {then,otherwise}, new Expression[] {condition});
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Object value = getExpressions().get(0).evaluate().getValue();
		if (!(value instanceof Boolean))
			getProgram().typeErrorOccurred();
		if ((boolean) value)
			getStatements().get(0).execute();
		else
			getStatements().get(1).execute();
	}

}
