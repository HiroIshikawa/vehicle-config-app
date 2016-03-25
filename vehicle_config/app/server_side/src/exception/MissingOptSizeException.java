package exception;

public class MissingOptSizeException extends AutoException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorno;
	private String errormsg;
	
	public MissingOptSizeException() {
		super();
		printmyproblem();
	}
	
	public MissingOptSizeException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public MissingOptSizeException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public MissingOptSizeException(int errorno, String errormsg) {
		this.errorno = errorno;
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public String fix(){
		return "0";
	}
	
	public void printmyproblem() {
		System.out.println("FixProblems [errorno=" + errorno + ", errormsg=" + errormsg); 
	}
}
