/**
 * This class is a simple abstraction that represents the
 * ratio of two numbers and stores them in reduced form,
 * with the numerator and denominator as whole numbers.
 * 
 * @author Khanh Nguyen
 * @version 10/17/23
 */
public class Fraction {
    private double numerator; //variable for the numerator
    private double denominator; //variable for the denominator

    /**
     * Default constructor
     */
    public Fraction() {
        this.numerator = 0;
        this.denominator = 0;
    }

    /**
     * Constructor that takes the numerator and denominator as ints
     * @param numerator     The numerator from the file as an integer
     * @param denominator   The denominator from the file as an integer
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Constructor that takes the numerator and denominator as doubles
     * @param numerator     The numerator from the file as a double
     * @param denominator   The denominator from the file as a double
     */
    public Fraction(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * This method compares if this Fraction object is equal to the other
     * Fraction object
     * @param other     The comparable Fraction object
     * @return          True or False
     */
    public boolean equals(Fraction other) {
        return this.numerator == other.getNumerator() && this.denominator == other.getDenominator();
    }

    @Override
    /**
     * This method returns a string of the fraction in the format: "a/b"
     * @return      A String
     */
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * This method returns this numerator as a double
     * @return      The numerator
     */
    public double getNumerator() {
        return this.numerator;
    }

    /**
     * This method returns this denominator as a double
     * @return      The denominator
     */
    public double getDenominator() {
        return this.denominator;
    }

    /**
     * This method sets the numerator and denominator as ints
     * @param numerator     The numerator
     * @param denominator   The denominator
     */
    public void setFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * This method sets the numerator and denominator as doubles
     * @param numerator     The numerator
     * @param denominator   The denominator
     */
    public void setFraction(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
}
