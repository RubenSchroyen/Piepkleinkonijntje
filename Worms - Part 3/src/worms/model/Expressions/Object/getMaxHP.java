package worms.model.Expressions.Object;

import worms.model.Expression;
import worms.model.Type;
import worms.model.Worm;

public class getMaxHP extends Expression{

	public getMaxHP(int line, int column, Expression e) {
		// TODO Auto-generated constructor stub
		super(line, column, e);
	}

	@Override
	public Type<?> evaluate() {
		Object value = getExpressions().get(0).evaluate().getValue();
		if (value instanceof Worm)
			return new Type<Integer>((int)((Worm) value).getMaxAP());
		getRootProgram().typeErrorOccurred();
		return null;
	}

}
