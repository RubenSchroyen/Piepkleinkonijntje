package worms.model.Expressions.Comparisons;

import worms.model.Expression;
import worms.model.Type;

public class Negation extends Expression {

	public Negation(int line, int column, Expression e) {
		super(line, column, e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		Object value = getExpressions().get(0).evaluate().getValue();
		if (value instanceof Boolean)
			return new Type<Boolean> (!(boolean) value);
		getRootProgram().typeErrorOccurred();
		// TODO Auto-generated method stub
		return null;
	}

}
