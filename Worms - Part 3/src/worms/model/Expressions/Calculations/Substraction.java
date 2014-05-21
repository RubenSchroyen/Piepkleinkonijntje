package worms.model.Expressions.Calculations;

import worms.model.Expression;
import worms.model.Type;

public class Substraction extends Expression{

	public Substraction(int line, int column, Expression e1, Expression e2) {
		super(line, column, e1, e2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		Object value = getExpressions().get(0).evaluate().getValue();
		Object otherValue = getExpressions().get(1).evaluate().getValue();
		if (value instanceof Number && otherValue instanceof Number)
			return new Type<Double> ((double) value - (double) otherValue);
		getRootProgram().typeErrorOccurred();
		// TODO Auto-generated method stub
		return null;
	}

}
