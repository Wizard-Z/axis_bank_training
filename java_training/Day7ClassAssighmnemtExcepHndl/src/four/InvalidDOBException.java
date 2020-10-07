package four;

public class InvalidDOBException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidDOBException() {
		super();
	}
	@Override	
	public String getMessage() {
		return"Date of Birth cannot be after the current date";
	}


}
