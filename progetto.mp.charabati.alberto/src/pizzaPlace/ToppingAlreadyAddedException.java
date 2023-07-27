package pizzaPlace;

public class ToppingAlreadyAddedException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToppingAlreadyAddedException(String message) {
        super(message);
    }
}
