/**
 * This class represents an exception that is thrown if
 * Pizza does not work as intended.
 * @author Khanh Nguyen
 * @version 12/7/23
 */
public class PizzaException extends Exception {
    /**
     * Constructor
     */
    public PizzaException() {
        super("Pizza not valid");
    }

    /**
     * Constructor sets personalized message
     * @param message   Personalized message 
     */
    public PizzaException(String message) {
        super(message);
    }
}