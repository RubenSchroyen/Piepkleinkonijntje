package worms.model.Expressions.Calculations;


import worms.model.Expression;
import worms.model.Type;

public class VariableAccess extends Expression {

	private String variable;
	private Type<?> type;

	public VariableAccess(int line, int column, String variable, Type<?> type) {
		super(line, column);
		this.variable = variable;
		this.type = type;
	}

	@Override
	public Type<?> evaluate() {
		if (type.getValue().getClass().isAssignableFrom(getRootProgram().getVariable(variable).getValue().getClass()))
			return getRootProgram().getVariable(variable);		
		getRootProgram().typeErrorOccurred();
		return null;
	}

}
