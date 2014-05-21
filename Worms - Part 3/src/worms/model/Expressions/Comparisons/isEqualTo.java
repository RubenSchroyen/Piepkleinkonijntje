package worms.model.Expressions.Comparisons;

import worms.model.Expression;
import worms.model.Type;

public class isEqualTo extends Expression{

	public isEqualTo(int line, int column, Expression e1, Expression e2) {
		super(line, column, e1, e2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		Object value = getExpressions().get(0).evaluate().getValue();
		Object otherValue = getExpressions().get(1).evaluate().getValue();
		if (value instanceof Number && otherValue instanceof Number)
			return new Type<Boolean> ((double) value == (double) otherValue);
		getRootProgram().typeErrorOccurred();
		// TODO Auto-generated method stub
		return null;
	}

}
