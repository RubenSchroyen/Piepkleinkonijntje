package worms.model.Expressions.Object;

import worms.model.Expression;
import worms.model.Food;
import worms.model.Type;
import worms.model.World;
import worms.model.Worm;

public class SearchObject extends Expression{

	public SearchObject(int line, int column, Expression e) {
		super(line, column, e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<?> evaluate() {
		Object value = getExpressions().get(0).evaluate().getValue();
		
		double x = getStatement().getRootProgram().getWorm().getPosX();
		double y = getStatement().getRootProgram().getWorm().getPosY();
		double angle = getStatement().getRootProgram().getWorm().getAngle() + (double)value;
		double resolution = 0.1*getStatement().getRootProgram().getWorm().getRadius();

		if ( value instanceof Worm )
		{ 
			while ( getStatement().getRootProgram().getWorm().getWorld().isWithinBoundaries(x,y) ) 
			{
				for ( Worm worm : getStatement().getRootProgram().getWorm().getWorld().getWorms() ) 
				{
					if ( World.isOverlapping(worm.getPosX(), worm.getPosY(), worm.getRadius(), x, y, 0) )
						return new Type<Worm>(worm);
				}	
				x = x + resolution*Math.cos(angle);
				y = y + resolution*Math.sin(angle);
			}
			return new Type<Worm>();
		}
		if (value instanceof Food) 
		{
			while ( getStatement().getRootProgram().getWorm().getWorld().isWithinBoundaries(x, y)) 
			{
				for (Food food : getStatement().getRootProgram().getWorm().getWorld().getFodder()) 
				{
					if ( World.isOverlapping(food.getPosX(), food.getPosY(), Food.getRadius(), x, y, 0) )
						return new Type<Food>(food);
				}
				x = x + resolution * Math.cos(angle);
				y = y + resolution * Math.sin(angle);
			}
		}
		if ((double) value == 0)
			System.out.println("No objects found closeby");
		else
			getRootProgram().typeErrorOccurred();
		return new Type<Object>(null);
	}

}
