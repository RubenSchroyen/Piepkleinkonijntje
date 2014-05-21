package worms.model.Statements;


public class Skip extends Action {

	public Skip(int line, int column) {
		super(line, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doAction() {
		// TODO Auto-generated method stub
		//NOTHING
		System.out.println("Skipping");
	}

}
