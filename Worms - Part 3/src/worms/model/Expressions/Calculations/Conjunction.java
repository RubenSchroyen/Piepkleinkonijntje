package worms.model.Expressions.Calculations;

import worms.model.Expression;
import worms.model.Type;

public class Conjunction extends Expression {

	public Conjunction(int line, int column, Expression e1, Expression e2) {
		// TODO Auto-generated constructor stub
		super(line, column, e1, e2);
	}

	@Override
	public Type<?> evaluate() {
		Object value = getExpressions().get(0).evaluate().getValue();
		Object otherValue = getExpressions().get(1).evaluate().getValue();
		if (value instanceof Boolean && otherValue instanceof Boolean)
			return new Type<Boolean> ((boolean) value || (boolean) otherValue);
		getRootProgram().typeErrorOccurred();
		// TODO Auto-generated method stub
		return null;
	}

}
