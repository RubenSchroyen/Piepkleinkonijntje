package worms.model.Expressions.Calculations;

import worms.model.Expression;
import worms.model.Type;

public class False extends Expression{

	public False(int line, int column) {
		super(line, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		// TODO Auto-generated method stub
		return new Type<Boolean>(false);
	}

}
