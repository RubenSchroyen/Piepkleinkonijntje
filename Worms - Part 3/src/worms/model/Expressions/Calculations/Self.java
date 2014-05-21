package worms.model.Expressions.Calculations;

import worms.model.Expression;
import worms.model.Type;
import worms.model.Worm;

public class Self extends Expression{

	public Self(int line, int column) {
		super(line, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		// TODO Auto-generated method stub
		return new Type<Worm>(getRootProgram().getWorm());
	}

}
