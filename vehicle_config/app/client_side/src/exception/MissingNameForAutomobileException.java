package exception;

public class MissingNameForAutomobileException extends AutoException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorno;
	private String errormsg;
	
	public MissingNameForAutomobileException() {
		super();
		printmyproblem();
	}
	
	public MissingNameForAutomobileException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public MissingNameForAutomobileException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public MissingNameForAutomobileException(int errorno, String errormsg) {
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
