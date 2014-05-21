package worms.model.Expressions.Calculations;

import worms.model.Expression;
import worms.model.Type;

public class Cosine extends Expression {

	public Cosine(int line, int column, Expression e) {
		super(line, column, e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		// TODO Auto-generated method stub
		Object value = getExpressions().get(0).evaluate().getValue();
		if (value instanceof Number)
			return new Type<Double> (Math.cos((double) value));
		getRootProgram().typeErrorOccurred();
		return null;
	}

}
