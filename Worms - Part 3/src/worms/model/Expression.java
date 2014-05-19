package worms.model;

import java.util.ArrayList;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;

public abstract class Expression 
{

	private final int line;
	private final int column;
	private Statement statement;
	public abstract Type<?> evaluate(); 
	private final ArrayList<Expression> expressions = new ArrayList<Expression>();
	private Expression parent;

	public Expression(int line, int column) 
	{
		this.line = line;
		this.column = column;
	}

	public Expression(int line, int column, Expression expression) 
	{
		this.line = line;
		this.column = column;
		addExpression(expression);
	}

	public Expression(int line, int column, Expression expression1, Expression expression2) 
	{
		this.line = line;
		this.column = column;
		addExpression(expression1);
		addExpression(expression2);
	}

	public Expression(int line, int column, Expression[] expressions) 
	{
		this.line = line;
		this.column = column;
		for ( int i=0; i < expressions.length; i++ ) 
		{
			addExpression(expressions[i]);
		}
	}

	public int getLine() 
	{
		return line;
	}
	
	public int getColumn() 
	{
		return column;
	}

	public Program getRootProgram() 
	{
		Expression expression = this;

		while ( expression.hasParent() ) 
		{
			expression = expression.getParent();
		}

		return expression.getStatement().getRootProgram();
	}

	

	@Basic
	public Statement getStatement() {
		return statement;
	}

	@Raw
	void setStatement(Statement statement) {
		if (!isValidStatement(statement))
			throw new ModelException("This statement is not valid");
		if (hasStatement())
			throw new ModelException("This statement is already called");
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

	@Raw
	void removeStatement() 
	{
		statement = null;
	}

	

	@Basic
	public ArrayList<Expression> getExpressions() 
	{
		return expressions;
	}

	public void addExpression(Expression expression) throws ModelException 
	{
		if (!isValidExpression(expression))
			throw new ModelException("This expression is not valid");
		if (hasExpression(expression))
			throw new ModelException("Expression is already called");
		expression.setParent(this);
		expressions.add(expression);
	}

	private static boolean isValidExpression(Expression expression) 
	{
		if (expression==null)
			return false;
		if (expression.isTerminated())
			return false;
		return (expression != null && !expression.isTerminated());
	}

	private boolean hasExpression(Expression expression) {
		return expressions.contains(expression);
	}

	public void removeExpression(Expression expression) throws ModelException 
	{
		if (!hasExpression(expression))
			throw new ModelException("This expression does not exist");
		expression.removeParent();
		expressions.remove(expression);
	}

	private void removeAllExpressions() 
	{
		for ( Expression expression : expressions ) 
		{
			expression.removeParent();
			removeExpression(expression);
		}
	}


	@Basic
	public Expression getParent() 
	{
		return parent;
	}

	@Raw
	void setParent(Expression expression) 
	{
		if (!isValidParent(expression))
			throw new ModelException("This parent expression is not valid");
		if (hasParent())
			throw new ModelException("This parent expression is already called");
		this.parent = expression;
	}

	private static boolean isValidParent(Expression expression) 
	{
		return (expression != null && expression.isTerminated());
	}

	protected boolean hasParent() 
	{
		return (parent != null);
	}

	@Raw
	void removeParent() 
	{
		parent = null;
	}

	private boolean terminated;

	@Basic
	public boolean isTerminated() 
	{
		return terminated;
	}

	public void terminate() 
	{
		terminated = true;
		removeAllExpressions();
	}

}
