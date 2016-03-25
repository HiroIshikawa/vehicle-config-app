package exception;

public class MissingPriceForAutomobileException extends AutoException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorno;
	private String errormsg;
	
	public MissingPriceForAutomobileException() {
		super();
		printmyproblem();
	}
	
	public MissingPriceForAutomobileException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public MissingPriceForAutomobileException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public MissingPriceForAutomobileException(int errorno, String errormsg) {
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
