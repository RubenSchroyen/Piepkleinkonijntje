package worms.model.Statements;

import java.util.ArrayList;

import worms.model.Food;
import worms.model.Program;
import worms.model.Statement;
import worms.model.Type;
import worms.model.Worm;
import worms.model.programs.ProgramFactory.ForeachType;

public class ForEach extends Statement 
{

	private ForeachType type;
	private String variable;
	private boolean begin = true;
	private Object last;
	private int counter;

	public ForEach(int line, int column, worms.model.programs.ProgramFactory.ForeachType type, String variableName, Statement body) {
		super(line, column, new Statement[] {body});
		this.type = type;
		this.variable = variableName;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if (!getRootProgram().continueExecution())
			return;
		if (getRootProgram().getCurrentLine() > getLine())
			return;
		beforeExecute();
		Program program = getRootProgram();
		
		//Go through all types
		//WORMS
		if ( type == ForeachType.WORM ) 
		{
			//Add all worms to a list and let them do their stuff
			ArrayList<Worm> worms = new ArrayList<Worm>();
			worms.addAll(program.getWorm().getWorld().getWorms());
			if (begin == true) 
			{
				for (int i = 0; i < worms.size(); i++ ) 
				{
					begin = false;
					last = worms.get(i);
					counter = i;
					getRootProgram().setCurrentLine(getLine());
					getRootProgram().setCurrentColumn(getColumn());

					program.assignVariable(variable, new Type<Worm>((Worm) last));
					getStatements().get(0).execute();
				}
			}
			else 
			{	//Program was already running when stopped, just continue from last point
				for (int i = counter; i < worms.size(); i++) 
				{
					last = worms.get(i);
					counter = i;
					getRootProgram().setCurrentLine(getLine());
					getRootProgram().setCurrentColumn(getColumn());

					program.assignVariable(variable, new Type<Worm>((Worm) last));
					getStatements().get(0).execute();
				}
			}
			begin = true;	//All worms have been done
		}
		
		//FOOD (practically the same as worms)
		if ( type == ForeachType.FOOD ) {
			ArrayList<Food> foods = new ArrayList<Food>();
			foods.addAll(program.getWorm().getWorld().getFodder());
			if (begin == true) 
			{	
				for (int i = 0; i < foods.size(); i++) {
					begin = false;
					last = foods.get(i);
					counter = i;
					getRootProgram().setCurrentLine(getLine());
					getRootProgram().setCurrentColumn(getColumn());

					program.assignVariable(variable, new Type<Food>((Food) last));
					getStatements().get(0).execute();
				}
			}
			else 
			{	
				for (int i = counter; i < foods.size(); i++) 
				{
					last = foods.get(i);
					counter = i;
					getRootProgram().setCurrentLine(getLine());
					getRootProgram().setCurrentColumn(getColumn());

					program.assignVariable(variable, new Type<Food>((Food) last));
					getStatements().get(0).execute();
				}
			}
			begin = true; 
		}
		
		//Do this for any object, we don't know if it is worm or food
		if ( type == ForeachType.ANY ) 
		{
			ArrayList<Object> objects = new ArrayList<Object>();
			objects.addAll(program.getWorm().getWorld().getWorms());
			objects.addAll(program.getWorm().getWorld().getFodder());
			if (begin == true) {
				for (int i = 0; i < objects.size(); i++) 
				{
					begin = false;
					last = objects.get(i);
					counter = i;
					getRootProgram().setCurrentLine(getLine());
					getRootProgram().setCurrentColumn(getColumn());

					program.assignVariable(variable, new Type<Object>(last));
					getStatements().get(0).execute();
				}
			}
			else 
			{
				for (int i = counter; i < objects.size(); i++) 
				{
					last = objects.get(i);
					counter = i;
					getRootProgram().setCurrentLine(getLine());
					getRootProgram().setCurrentColumn(getColumn());

					program.assignVariable(variable, new Type<Object>(last));
					getStatements().get(0).execute();
				}
			}
		}
	
	}
	
	public boolean isWellFormed()
	{
		for (Statement statement : getAllStatements())
		{
			if (statement instanceof Action)
				return false;
		}
		return true;
	}

}
