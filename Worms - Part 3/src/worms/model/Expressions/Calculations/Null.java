package worms.model.Expressions.Calculations;

import worms.model.Expression;
import worms.model.Type;

public class Null extends Expression{

	public Null(int line, int column) {
		super(line, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		// TODO Auto-generated method stub
		return new Type<Object>(null);
	}

}
