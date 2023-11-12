/**
 * The purpose of this class is to store a reference to a Fraction 
 * object and a count of how many times this fraction object
 * has been seen in the input file.
 * 
 * @author Khanh Nguyen
 * @version 10/17/23
 */
public class FractionCounter {
    private Fraction theFraction; //A Fraction object
    private int theCounter = 1; //So when a new fraction is added the counter will automatically be 1

    /**
     * This method creates a FractionCounter object that holds
     * a Fraction object
     * @param theFraction   The Fraction object
     */
    public FractionCounter(Fraction theFraction) {
        this.theFraction = theFraction;
    }

    /**
     * This method sees if the newFraction is the same as
     * the Fraction that is stored. If so, it increments the
     * counter by one and returns true (otherwise, return false)
     * @param newFraction   The comparable Fraction object
     * @return              True or false
     */
    public boolean compareAndIncrement(Fraction newFraction) {
        if (theFraction.equals(newFraction)) {
            theCounter++;
            return true;
        }
        return false;
    }

    @Override
    /**
     * This method prints out both the Fraction and its count
     * @return      A String
     */
    public String toString() {
        String num = Integer.toString((int) this.theFraction.getNumerator());
        String den = Integer.toString((int) this.theFraction.getDenominator());
        return num + "/" + den + " has a count of " + this.theCounter;
    }
}
