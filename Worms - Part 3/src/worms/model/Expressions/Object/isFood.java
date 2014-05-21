package worms.model.Expressions.Object;

import worms.model.Expression;
import worms.model.Food;
import worms.model.Type;

public class isFood extends Expression{

	public isFood(int line, int column, Expression e) {
		super(line, column, e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		// TODO Auto-generated method stub
		return new Type<Boolean>(getExpressions().get(0).evaluate().getValue() instanceof Food);
	}

}
