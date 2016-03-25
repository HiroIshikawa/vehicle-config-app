package exception;

public class AutoException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorno;
	private String errormsg;
	
	public AutoException() {
		super();
		printmyproblem();
	}
	
	public AutoException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public AutoException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public AutoException(int errorno, String errormsg) {
		this.errorno = errorno;
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public String fix(){
		return "Not Named Yet";
	}
	
	public void printmyproblem() {
		System.out.println("FixProblems [errorno=" + errorno + ", errormsg=" + errormsg); 
	}
}
