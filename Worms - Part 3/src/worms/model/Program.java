package worms.model;

import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.ModelException;
import worms.model.programs.ParseOutcome;
import worms.model.programs.ProgramFactory;
import worms.model.programs.ProgramParser;

public class Program {

	private IActionHandler handler;
	private boolean typeErrorOccurred;
	private Map<String,Type<?>> variables;
	private ProgramParser<Expression,Statement,Type<?>> parser;
	private int currentLine;
	private int currentColumn;
	private int AmountOfStatements;
	private final int maxAmountOfStatements = 1000;
	private Worm worm;
	
	public Program(Map<String, Type> globals, Statement statement){
		this.setGlobals(globals);
		this.setStatement(statement);
		System.out.println(statement);

	
		}
	


	/*public ParseOutcome<?> parseProgram(String programText,IActionHandler handler) {
		
		ProgramParser<Expression,Statement,Type> parser= new ProgramParser(ProgramFactory<Expression,Statement,Type> factory);
		parser.parse(programText);
		if (!parser.getErrors().isEmpty())
			return ParseOutcome.failure(parser.getErrors());
		else
			return ParseOutcome.success(new Program());
	
		
		/* 
		Program program = new Program();
		return program.parseProgram(programText, handler);
		
	}
*/
	public boolean isWellFormed() 
	{
		return getStatement().isWellFormed(this);
	}


	public void typeErrorOccurred() 
	{
		typeErrorOccurred = true;
		System.err.println("A type error occurred in the specified worm program.");
		System.err.println("This happened at line " + getCurrentLine() + " and column " + getCurrentColumn() + ".");
		stopProgram();
	}


	public void assignVariable( String variable, Type<?> type ) 
	{
		variables.put(variable, type);
	}

	public void setVariables( Map<String,Type<?>> map ) 
	{
		variables = map;
	}

	public Type<?> getVariable(String variable) 
	{
		Type<?> type = variables.get(variable);
		if (type == null)
			return new Type<Object>(null);
		return type;
	}

	public int getCurrentLine() 
	{
		return currentLine;
	}
	public int getCurrentColumn() 
	{
		return currentColumn;
	}
	
	public IActionHandler getHandler() 
	{
		return handler;
	}

	public void setCurrentLine(int line) 
	{
		currentLine = line;
	}
	public void setCurrentColumn(int column) 
	{
		currentColumn = column;
	}
	public int getAmountOfStatements() 
	{
		return AmountOfStatements;
	}
	public void incAmountOfStatements() 
	{
		AmountOfStatements++;
	}

	public int getMaxAmountOfStatements() {
		return maxAmountOfStatements;
	}

	private boolean continueExecution;

	public boolean continueExecution() {
		return continueExecution;
	}

	public void setContinueExecution(boolean bool) {
		this.continueExecution = bool;
	}

	private boolean hasReachedEnd;

	public boolean getHasReachedEnd() {
		return hasReachedEnd;
	}

	public void runProgram() 
	{
		AmountOfStatements=0;
		if (typeErrorOccurred) 
		{
			typeErrorOccurred();
			getWorm().getWorld().nextWorm();
			return;
		}
		if (hasReachedEnd) 
		{
			hasReachedEnd = false;
			setVariables(parser.getGlobals());
			setCurrentLine(0);
			setCurrentColumn(0);
		}
		continueExecution = true;

		getStatement().execute();
		if (continueExecution)
			hasReachedEnd = true;
		System.out.println("runProgram() has reached end. Next turn initiating.");
		this.getWorm().getWorld().nextWorm();
	}

	public void stopProgram() 
	{
		continueExecution = false;
		hasReachedEnd = false;
	}

	

	public Worm getWorm() 
	{
		return worm;
	}
	
	void setWorm(Worm worm) throws ModelException 
	{
		if (!isValidWorm(worm))
			throw new ModelException("This worm is not valid");
		if (hasWorm())
			throw new ModelException("This program already has a worm");
		this.worm = worm;
	}
	
	private static boolean isValidWorm(Worm worm) 
	{
		return (worm != null && worm.isAlive());
	}

	private boolean hasWorm() {
		return (worm != null);
	}

	void removeWorm() 
	{
		worm = null;
	}

	private Statement statement;

	public Statement getStatement() 
	{
		return statement;
	}

	void setStatement(Statement statement) 
	{
		if (!isValidStatement(statement))
			throw new ModelException("This statement is not valid");
		if (hasStatement())
			throw new ModelException("This program already has a statement");
		statement.setProgram(this);
		this.statement = statement;
	}

	private static boolean isValidStatement(Statement statement) 
	{
		return (statement != null && !statement.isTerminated());
	}

	protected boolean hasStatement() 
	{
		return (statement != null);
	}

	void removeStatement() 
	{
		if (hasStatement())
			statement.removeProgram(this);
		statement = null;
	}

	private boolean terminated;
	
	private Map<String, Type> globals;

	public boolean isTerminated() 
	{
		return terminated;
	}

	public void terminate() 
	{
		if (hasWorm())
			worm.removeProgram();
		removeStatement();
		terminated = true;
	}

	
	private void setGlobals(Map<String, Type> globals) 
	{
		this.globals = globals;
		
	}

	
	
}
	
	
	
	
	
	
	
	
	
	
