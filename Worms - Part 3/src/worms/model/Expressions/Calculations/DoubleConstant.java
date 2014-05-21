package worms.model.Expressions.Calculations;

import worms.model.Expression;
import worms.model.Type;

public class DoubleConstant extends Expression {

	private double d;

	public DoubleConstant(int line, int column, double d) {
		super(line, column);
		this.d = d;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		// TODO Auto-generated method stub
		return new Type<Double>(d);
	}

}
