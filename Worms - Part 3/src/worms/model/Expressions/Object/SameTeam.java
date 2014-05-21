package worms.model.Expressions.Object;

import worms.model.Expression;
import worms.model.Type;
import worms.model.Worm;

public class SameTeam extends Expression{

	public SameTeam(int line, int column, Expression e) {
		super(line, column, e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		// TODO Auto-generated method stub
		Object value = getExpressions().get(0).evaluate().getValue();
		if ( value instanceof Worm ) 
			if (getRootProgram().getWorm().getTeam() == null) 
			{	
				System.out.println("This worm is neutral");
				return new Type<Boolean>(false);
			}
			else 
			{
				System.out.println("This worm has a team");
				System.out.println("Returntype: " + getRootProgram().getWorm().getTeam());
				return new Type<Boolean>(getRootProgram().getWorm().getTeam() == ((Worm)value).getTeam());
			}
		getRootProgram().typeErrorOccurred();
		return null;
	}

}
