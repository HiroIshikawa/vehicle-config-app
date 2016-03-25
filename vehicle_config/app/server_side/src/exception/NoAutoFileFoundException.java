package exception;

public class NoAutoFileFoundException extends AutoException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorno;
	private String errormsg;

	public NoAutoFileFoundException() {
		super();
		printmyproblem();
	}
	
	public NoAutoFileFoundException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public NoAutoFileFoundException(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public NoAutoFileFoundException(int errorno, String errormsg) {
		this.errorno = errorno;
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public int getErrorno() {
		return errorno;
	}
	
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	
	public String getErrormsg() {
		return errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public void printmyproblem() {
		System.out.println("FixProblems [errorno=" + errorno + ", errormsg=" + errormsg); 
	}

	public void fix(int errorNum)
	{;}
}
