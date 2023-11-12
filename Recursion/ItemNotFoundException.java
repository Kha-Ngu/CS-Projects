/**
 * This class represents a personalized personalized exception 
 * that is thrown when an item is not found.
 * @author Khanh Nguyen
 * @version 11/9/23
 */
public class ItemNotFoundException extends Exception{
    /**
     * Constructor that borrows message method from super class
     */
    public ItemNotFoundException() {
        super("Item is not found");
    }

    /**
     * Constructor that takes in a personalized message
     * @param message   A personalized error message
     */
    public ItemNotFoundException(String message) {
        super(message);
    }
}
