package worms.model.Expressions.Calculations;

import worms.model.Expression;
import worms.model.Type;

public class Variable extends Expression{

	private String variable;

	public Variable(int line, int column, String name) {
		super(line, column);
		this.variable = name;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		// TODO Auto-generated method stub
		return getRootProgram().getVariable(variable);
	}

}
