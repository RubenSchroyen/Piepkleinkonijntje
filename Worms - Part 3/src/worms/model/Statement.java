package worms.model;

import java.util.ArrayList;

public abstract class Statement 
{
	private int line;
	private int column;
	private ArrayList<Expression> expressions = new ArrayList<Expression>();;
	private ArrayList<Statement> statements = new ArrayList<Statement>();;
	private Statement parent;
	private boolean terminated = false;
	Program program;
	
	public Statement(int line, int column) 
	{
		super();
		setLine(line);
		setColumn(column);
	}

	public Statement(int line, int column, Statement[] statements) 
	{
		setLine(line);
		setColumn(column);
		for ( int i=0; i < statements.length; i++ ) 
		{
			addStatement(statements[i]);
		}
	}

	private void addStatement(Statement statement) 
	{
		if (!isValidStatement(statement))
			throw new ModelException("This statement is not valid");
		if (hasStatement(statement))
			throw new ModelException("This statement has already been called");
		statement.setParent(this);
		statements.add(statement);
		
	}

	private void setParent(Statement statement) 
	{
		if (!isValidParent(statement))
			throw new ModelException("This parent statement is not valid");
		if (hasParent())
			throw new ModelException("This parent statement has already been called");
		this.parent = statement;
	}

	

	private boolean hasStatement(Statement statement) 
	{
		return statements.contains(statement);
	}

	private boolean isValidStatement(Statement statement) 
	{
		if (statement != null && !statement.isTerminated())
			return true;
		return false;
	}

	public Statement(int line, int column, Expression[] expressions)
	{
		setLine(line);
		setColumn(column);
		for ( int i=0; i < expressions.length; i++ ) 
		{
			addExpression(expressions[i]);
		}
	}

	private void addExpression(Expression expression) 
	{
		expressions.add(expression);
		
	}

	public Statement(int line, int column, Statement[] statements, Expression[] expressions) 
	{
		setLine(line);
		setColumn(column);
		for ( int i=0; i < statements.length; i++ ) 
		{
			addStatement(statements[i]);
		}
		for ( int i=0; i < expressions.length; i++ ) 
		{
			addExpression(expressions[i]);
		}
	}
	
	public int getLine() 
	{
		return line;
	}

	public void setLine(int line) 
	{
		this.line = line;
	}

	public int getColumn() 
	{
		return column;
	}

	public void setColumn(int column) 
	{
		this.column = column;
	}

	public ArrayList<Expression> getExpressions() 
	{
		return expressions;
	}

	public void setExpressions(ArrayList<Expression> expressions) 
	{
		this.expressions = expressions;
	}

	public ArrayList<Statement> getStatements() 
	{
		return statements;
	}

	public void setStatements(ArrayList<Statement> statements) 
	{
		this.statements = statements;
	}

	public Statement getParent() 
	{
		return parent;
	}
	
	public Program getProgram() 
	{
		return program;
	}

	public void setProgram(Program program) 
	{
		this.program = program;
	}
	
	public void terminate()
	{
		removeAllStatements();
		removeAllExpressions();
		terminated = true;
	}
	
	public boolean hasExpression(Expression expression)
	{
		return expressions.contains(expression);
	}
	
	public boolean isValidExpression(Expression expression)
	{
		return (expression != null && !hasExpression(expression));
	}
	
	public void removeStatement(Statement statement) throws ModelException
	{
		if (!hasStatement(statement))
			throw new ModelException("Statement is not called yet");
		statement.removeParent();
		statements.remove(statement);
	}
	
	public void removeAllStatements()
	{
		for (Statement statement : statements) 
		{
			statement.removeParent();
			removeStatement(statement);
		}
	}
	
	public void removeParent()
	{
		setParent(null);
	}
	
	public void removeExpression(Expression expression) throws ModelException
	{
		if (!hasExpression(expression))
			throw new ModelException("Expression is not called yet");
		expression.removeStatement();
		expressions.remove(expression);
	}
	
	public void removeAllExpressions()
	{
		for (Expression expression : expressions) 
		{
			expression.removeStatement();
			removeExpression(expression);
		}
	}
	
	public void removeProgram(Program program)
	{
		setProgram(null);
	}

	public boolean isValidProgram(Program program)
	{
		return (program != null && !program.isTerminated());
	}
	
	public boolean hasProgram(Program program)
	{
		return (program != null);
	}

	public Program getRootProgram() 
	{
		Statement statement = this;
		
		while ( statement.hasParent() ) 
		{
			statement = statement.getParent();
		}
		
		return statement.getProgram();
	}
	
	public ArrayList<Statement> getAllStatements()
	{
		statements.add(this);
		for (Statement statement : getStatements() ) 
		{
			if (statement != null)
				statements.addAll(statement.getAllStatements());
		}
		return statements;
	}
	
	public boolean isWellFormed(Program program)
	{
		for ( Statement statement : getStatements() ) 
		{
			if (!statement.isWellFormed(program))
				return false;
		}
		return true;
	}
	
	public abstract void execute();
	
	public void beforeExecute()
	{
		Program program = getRootProgram();
		if (!program.skip())
			program.stop();
		if (program.amountOfStatements() >= program.maxAmountOfStatements())
			program.stop();
		program.setCurrentLine(getLine());
		program.setCurrentColumn(getColumn());
		program.IncreaseAmountOfStatements();
	}
	
	private boolean isValidParent(Statement statement) 
	{
		return (statement != null && !statement.isTerminated());
	}

	private boolean hasParent() 
	{
		return (this.getParent() != null);
	}
	
	private boolean isTerminated() 
	{
		return terminated;
	}
}
