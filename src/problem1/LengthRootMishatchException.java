package problem1;

/**
 * @author Zekrom
 *
 */
public class LengthRootMishatchException extends Exception{
	/**
	 *
	 */
	private static final long serialVersionUID=1L;


	/**
	 * Creates a new exception
	 */
	public LengthRootMishatchException(){
		super("Encountered a mismatch of length and null root");
	}

	/**
	 * Creates a new exception
	 * 
	 * @param string
	 *                   Message to append
	 */
	public LengthRootMishatchException(final String string){
		super("Encountered a mismatch of length and null root. "+string);
	}
}
