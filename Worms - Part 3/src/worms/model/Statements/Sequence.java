package worms.model.Statements;

import java.util.List;

import worms.model.Statement;

public class Sequence extends Statement {

	public Sequence(int line, int column, List<Statement> statements) {
		super(line, column, statements.toArray(new Statement[statements.size()]));
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
		for (Statement statements : getStatements())
			statements.execute();
		
	}

}
