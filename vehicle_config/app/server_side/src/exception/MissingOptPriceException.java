package exception;

public class MissingOptPriceException extends AutoException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorno;
	private String errormsg;
	
	public MissingOptPriceException() {
		super();
		printmyproblem();
	}
	
	public MissingOptPriceException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public MissingOptPriceException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public MissingOptPriceException(int errorno, String errormsg) {
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
