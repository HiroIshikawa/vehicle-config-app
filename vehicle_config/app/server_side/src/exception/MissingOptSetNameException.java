package exception;

public class MissingOptSetNameException extends AutoException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorno;
	private String errormsg;
	
	public MissingOptSetNameException() {
		super();
		printmyproblem();
	}
	
	public MissingOptSetNameException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public MissingOptSetNameException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public MissingOptSetNameException(int errorno, String errormsg) {
		this.errorno = errorno;
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public String fix(){
		return "Null";
	}
	
	public void printmyproblem() {
		System.out.println("FixProblems [errorno=" + errorno + ", errormsg=" + errormsg); 
	}

}
