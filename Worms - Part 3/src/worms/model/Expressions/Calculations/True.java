package worms.model.Expressions.Calculations;

import worms.model.Expression;
import worms.model.Type;

public class True extends Expression{

	public True(int line, int column) {
		super(line, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		// TODO Auto-generated method stub
		return new Type<Boolean>(true);
	}

}
