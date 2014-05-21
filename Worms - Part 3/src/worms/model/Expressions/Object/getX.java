package worms.model.Expressions.Object;

import worms.model.Expression;
import worms.model.Type;
import worms.model.Worm;

public class getX extends Expression{

	public getX(int line, int column, Expression e) {
		super(line, column, e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		// TODO Auto-generated method stub
		Object value = getExpressions().get(0).evaluate().getValue();
		if (value instanceof Worm)
			return new Type<Double>((double)((Worm) value).getPosX());
		getRootProgram().typeErrorOccurred();
		return null;
	}

}
