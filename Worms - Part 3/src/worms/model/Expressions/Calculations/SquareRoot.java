package worms.model.Expressions.Calculations;

import worms.model.Expression;
import worms.model.Type;

public class SquareRoot extends Expression{

	public SquareRoot(int line, int column, Expression e) {
		super(line, column, e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		// TODO Auto-generated method stub
				Object value = getExpressions().get(0).evaluate().getValue();
				if (value instanceof Number)
					return new Type<Double> (Math.sqrt((double) value));
				getRootProgram().typeErrorOccurred();
				return null;
	}

}
