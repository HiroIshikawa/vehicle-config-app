package exception;

public class MissingOpsetSizeException extends AutoException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorno;
	private String errormsg;
	
	public MissingOpsetSizeException() {
		super();
		printmyproblem();
	}
	
	public MissingOpsetSizeException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public MissingOpsetSizeException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public MissingOpsetSizeException(int errorno, String errormsg) {
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
