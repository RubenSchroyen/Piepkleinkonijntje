package worms.model;

import java.util.List;

import worms.gui.game.IActionHandler;
import worms.model.Expressions.Calculations.*;
import worms.model.Expressions.Comparisons.*;
import worms.model.Expressions.Object.*;
import worms.model.Statements.*;
import worms.model.programs.ProgramFactory;


public class ProgramFactoryImpl implements  ProgramFactory<Expression, Statement, Type>
{
	public ProgramFactoryImpl(IActionHandler handler)
	{
		
	}
	
	public Expression createDoubleLiteral(int line, int column, double d) 
	{
		return new DoubleConstant(line,column,d);
	}

	public Expression createBooleanLiteral(int line, int column, boolean b) 
	{
		if (b)
			return new True(line,column);
		else
			return new False(line,column);
	}

	public Expression createAnd(int line, int column, Expression e1, Expression e2) 
	{
		return new Disjunction(line,column, e1, e2);
	}

	
	public Expression createOr(int line, int column, Expression e1, Expression e2) 
	{
		return new Conjunction(line,column, e1, e2);
	}

	
	public Expression createNot(int line, int column, Expression e) 
	{
		return new Negation(line,column, e);
	}

	
	public Expression createNull(int line, int column) 
	{
		return new Null(line,column);
	}

	
	public Expression createSelf(int line, int column) 
	{
		return new Self(line,column);
	}

	
	public getX createGetX(int line, int column, Expression e) 
	{
		return new getX(line,column, e);
	}

	
	public Expression createGetY(int line, int column, Expression e) 
	{
		return new getY(line,column, e);
	}

	
	public Expression createGetRadius(int line, int column, Expression e) 
	{
		return new getRadius(line,column, e);
	}

	
	public Expression createGetDir(int line, int column, Expression e) 
	{
		return new getDirection(line,column, e);
	}

	
	public Expression createGetAP(int line, int column, Expression e) 
	{
		return new getAP(line,column, e);
	}

	
	public Expression createGetMaxAP(int line, int column, Expression e) 
	{
		return new getMaxAP(line,column, e);
	}

	
	public Expression createGetHP(int line, int column, Expression e) 
	{
		return new getHP(line,column, e);
	}

	
	public Expression createGetMaxHP(int line, int column, Expression e) 
	{
		return new getMaxHP(line,column, e);
	}

	
	public Expression createSameTeam(int line, int column, Expression e) 
	{
		return new SameTeam(line,column, e);
	}

	
	public Expression createSearchObj(int line, int column, Expression e) 
	{
		return new SearchObject(line,column, e);
	}

	
	public Expression createIsWorm(int line, int column, Expression e) 
	{
		return new isWorm(line,column, e);
	}

	
	public Expression createIsFood(int line, int column, Expression e) 
	{
		return new isFood(line,column, e);
	}

	/*
	public Expression createVariableAccess(int line, int column, String name) 
	{
		return new Variable(line,column,name);
	}
*/
	
	public Expression createLessThan(int line, int column, Expression e1, Expression e2) 
	{
		return new lessThan(line,column, e1, e2);
	}

	
	public Expression createGreaterThan(int line, int column, Expression e1, Expression e2) 
	{
		return new greaterThan(line,column, e1, e2);
	}

	
	public Expression createLessThanOrEqualTo(int line, int column, Expression e1,
			Expression e2) 
	{
		return new lessThanOrEqualTo(line,column, e1, e2);
	}

	
	public Expression createGreaterThanOrEqualTo(int line, int column, Expression e1,
			Expression e2) 
	{
		return new greaterThanOrEqualTo(line,column, e1, e2);
	}

	
	public Expression createEquality(int line, int column, Expression e1, Expression e2) 
	{
		return new isEqualTo(line,column, e1, e2);
	}

	
	public Expression createInequality(int line, int column, Expression e1, Expression e2) 
	{
		return new NotEqual(line,column, e1, e2);
	}

	
	public Expression createAdd(int line, int column, Expression e1, Expression e2) 
	{
		return new Addition(line,column, e1, e2);
	}

	
	public Expression createSubtraction(int line, int column, Expression e1, Expression e2) 
	{
		return new Substraction(line,column, e1, e2);
	}

	
	public Expression createMul(int line, int column, Expression e1, Expression e2) 
	{
		return new Multiplication(line,column, e1, e2);
	}

	
	public Expression createDivision(int line, int column, Expression e1, Expression e2) 
	{
		return new Division(line,column, e1, e2);
	}

	
	public Expression createSqrt(int line, int column, Expression e) 
	{
		return new SquareRoot(line,column, e);
	}

	
	public Expression createSin(int line, int column, Expression e) 
	{
		return new Sine(line,column, e);
	}

	
	public Expression createCos(int line, int column, Expression e) 
	{
		return new Cosine(line,column, e);
	}

	
	public Statement createTurn(int line, int column, Expression angle) 
	{
		return new Turn(line,column,angle);
	}

	
	public Statement createMove(int line, int column) 
	{
		return new Move(line,column);
	}

	
	public Statement createJump(int line, int column) 
	{
		return new Jump(line,column);
	}

	
	public Statement createToggleWeap(int line, int column) 
	{
		return new ToggleWeapon(line,column);
	}

	
	public Statement createFire(int line, int column, Expression yield) 
	{
		return new Fire(line,column,yield);
	}

	
	public Statement createSkip(int line, int column) 
	{
		return new Skip(line,column);
	}

	
	public Statement createAssignment(int line, int column, String variableName,
			Expression rhs) 
	{
		return new Assignment(line,column,variableName, rhs);
	}

	
	public Statement createIf(int line, int column, Expression condition, Statement then,
			Statement otherwise) 
	{
		return new IfThenElse(line,column,condition, then, otherwise);
	}

	
	public Statement createWhile(int line, int column, Expression condition,
			Statement body) 
	{
		return new While(line,column,condition, body);
	}

	
	public Statement createForeach(int line, int column, ForeachType type,
			String variableName, Statement body) 
	{
		return new ForEach(line,column,type, variableName, body);
	}

	
	public Statement createSequence(int line, int column, List<Statement> statements) 
	{
		return new Sequence(line,column,statements);
	}

	
	public Statement createPrint(int line, int column, Expression e) 
	{
		return new Print(line,column,e);
	}

	
	public Type<?> createDoubleType() 
	{
		return new Type<Double>();
	}

	
	public Type<?> createBooleanType() 
	{
		return new Type<Boolean>();
	}

	
	public Type<?> createEntityType() 
	{
		return new Type<Object>();
	}

	@Override
	public Expression createVariableAccess(int line, int column, String name,
			Type type) {
		// TODO Auto-generated method stub
	return new Variable(line,column,name);
	}

	/*
	public Expression createVariableAccess(int line, int column, String name,
			Type<?> type) 
	{
		
		return new Variable(line,column,name);
	}
*/
}
