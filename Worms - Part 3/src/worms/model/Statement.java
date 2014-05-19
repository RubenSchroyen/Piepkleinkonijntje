package worms.model;

import java.util.ArrayList;

public class Statement 
{
	private int line;
	private int column;
	private ArrayList<Expression> expressions;
	private ArrayList<Statement> statements;
	private Statement parent;
	private boolean terminated;
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
		//TODO
	}
	
	public boolean hasExpression(Expression expression)
	{
		return false;
		//TODO
	}
	
	public boolean isValidExpression(Expression expression)
	{
		return false;
		//TODO
	}
	
	public void removeStatement(Statement statement)
	{
		//TODO
	}
	
	public void removeAllStatements()
	{
		//TODO
	}
	
	public void removeParent(Statement statement)
	{
		//TODO
	}
	
	public void removeExpression(Expression expression)
	{
		//TODO
	}
	
	public void removeAllExpressions()
	{
		//TODO
	}
	
	public void removeProgram(Program program)
	{
		//TODO
	}

	public boolean isValidProgram(Program program)
	{
		return false;
		//TODO
	}
	
	public boolean hasProgram(Program program)
	{
		return false;
		//TODO
	}

	public Program getRootProgram() 
	{
		//TODO
		return program;
	}
	
	public ArrayList<Statement> getAllStatements()
	{
		//TODO
		return statements;
	}
	
	public boolean isWellFormed(Program program)
	{
		return false;
		//TODO
	}
	
	public void execute()
	{
		//TODO
	}
	
	public void beforeExecute()
	{
		//TODO
	}
	
	private boolean isValidParent(Statement statement) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	private boolean hasParent() 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean isTerminated() 
	{
		// TODO Auto-generated method stub
		return false;
	}
}
