package exception;

public class MissingOptNameException extends AutoException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorno;
	private String errormsg;
	
	public MissingOptNameException() {
		super();
		printmyproblem();
	}
	
	public MissingOptNameException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public MissingOptNameException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public MissingOptNameException(int errorno, String errormsg) {
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
