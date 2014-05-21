package worms.model.Expressions.Object;

import worms.model.Expression;
import worms.model.Type;
import worms.model.Worm;

public class getY extends Expression{

	public getY(int line, int column, Expression e) {
		// TODO Auto-generated constructor stub
		super(line, column, e);
	}

	@Override
	public Type<?> evaluate() {
		// TODO Auto-generated method stub
		Object value = getExpressions().get(0).evaluate().getValue();
		if (value instanceof Worm)
			return new Type<Double>((double)((Worm) value).getPosY());
		getRootProgram().typeErrorOccurred();
		return null;
	}

}
