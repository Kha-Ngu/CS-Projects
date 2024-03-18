/**
 * This class is a simple abstraction that represents a Fraction
 * object of two numbers and stores them in reduced form,
 * with the numerator and denominator as whole numbers.
 * 
 * @author Khanh Nguyen
 * @version 10/17/23
 */
public class Fraction implements Comparable<Fraction>{
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
     * Copy constructor
     * @param f     Fraction to copy
     * @throws NullPointerException     thrown if Fraction object is null
     */
    public Fraction(Fraction f) throws NullPointerException {
        if(f == null) {
            throw new NullPointerException("Fraction object is null");
        }
        this.denominator = f.denominator;
        this.numerator = f.numerator;
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

    /**
     * This method compares a Fraction with another Fraction object and returns 
     * a positive, zero, or negative number if this Fraction has a bigger, equal, or smaller
     * rational value.
     * @param obj   The other Fraction object
     * @return  An integer
     */
    public int compareTo(Fraction obj) {
        obj.reduceFraction();
        this.reduceFraction();
        if(obj.getRationalValue() < this.getRationalValue()) {
            return 1;
        }
        else if(obj.getRationalValue() > this.getRationalValue()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    @Override
    /**
     * This method returns a string of the fraction in the format: "a/b"
     * @return      A String
     */
    public String toString() {
        return (int) numerator + "/" + (int) denominator;
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

    /**
     * This recursive method is Euclid's GCD algorithm, it takes in the numerator and
     * denominator returns the greatest common factor between them. 
     * Reference: geeksforgeeks.org/java-program-to-compute-gcd/
     * @param numerator    The numerator of the fraction
     * @param denominator  The denominator of the fraction
     * @return             The greatest common factor
     */
    private static int gcd(int numerator, int denominator) {
        if (denominator == 0) {
            return numerator;
        }
        return gcd(denominator, numerator % denominator);
    }

    /**
     * Returns the rational value of the fraction
     * as a decimal
     * @return  A double
     */
    public double getRationalValue() {
        return this.getNumerator() / this.getDenominator();
    }

    /**
     * Turns a numerator from decimal to whole number
     * @param num   The decimal numerator
     * @return  The numerator as a whole number
     */
    private int wholeNumerator(double num) {
        int wholeNumberNumerator = 0;
        String numeratorStr = Double.toString(num);
        String decimal = numeratorStr.substring(numeratorStr.indexOf(".") + 1);
        int power = (int) Math.pow(10, decimal.length()); //The amount of times to multiply by 10 to get rid of decimal
        wholeNumberNumerator = (int)(Double.parseDouble(numeratorStr) * power);

        return wholeNumberNumerator;
    }

    /**
     * Turns a denominator from a decimal to a whole number
     * @param den   The decimal denominator
     * @return  The denominator as a whole number
     */
    private int wholeDenominator(double den) {
        int wholeNumberDen = 0;
        String denominatorStr = Double.toString(den);
        String decimal = denominatorStr.substring(denominatorStr.indexOf(".") + 1);
        int power = (int) Math.pow(10, decimal.length());
        wholeNumberDen = (int)(Double.parseDouble(denominatorStr) * power);

        return wholeNumberDen;
    }

    /**
     * Calculates and sets the numerator and denominator to their reduced forms
     */
    public void reduceFraction(){
        int num = 0;
        int den = 0;
        
        //Check if numerator AND denominator is a decimal
        if(this.getNumerator() % 1 != 0 && this.getDenominator() %1 != 0) {
            //Check whether the numerator or denominator requires a bigger power multiplier
            //in order to turn into a whole number. This is done to maintain the ratio 
            //between the num and den.
            String numDec = Double.toString(this.getNumerator()).substring(Double.toString(this.getNumerator()).indexOf(".") + 1);
            int numDecPow = (int) Math.pow(10, numDec.length());
            String denDec = Double.toString(this.getDenominator()).substring(Double.toString(this.getDenominator()).indexOf(".") + 1);
            int denDecPow = (int) Math.pow(10, denDec.length());

            //If the multiplier to turn numerator into a whole number is bigger, multiply 
            //denominator by that power
            if(numDecPow > denDecPow) {
                num = wholeNumerator(this.getNumerator());
                den = (int)(this.getDenominator() * numDecPow);
            }
            //Vice versa
            else if(denDecPow > numDecPow) {
                num = (int)(this.getNumerator() * denDecPow);
                den = wholeDenominator(this.getDenominator());
            }
            //If the powre required for both to become whole numbers are equal,
            //call the methods as normal
            else if(numDecPow == denDecPow) {
                num = wholeNumerator(this.getNumerator());
                den = wholeDenominator(this.getDenominator());
            }
        }
        //Check if only the numerator is a decimal
        else if(this.getNumerator() % 1 != 0) {
            num = wholeNumerator(this.getNumerator());
            /*
             * Because num was changed into a whole number by multiplying
             * by some power, we have to multiply the denominator by that same
             * power to keep the ratio
             */
            String numStr = Double.toString(this.getNumerator());
            String decimal = numStr.substring(numStr.indexOf(".") + 1);
            int power = (int) Math.pow(10, decimal.length());
            
            den = (int)(this.getDenominator() * power);
        }
        //Check if only the denominator is a decimal
        else if(this.getDenominator() % 1 != 0) {        
            den = wholeDenominator(this.getDenominator());
            /*
             * Because den was changed into a whole number by multiplying
             * by some power, we have to multiply the numerator by that same
             * power to keep the ratio
             */
            String denStr = Double.toString(this.getDenominator());
            String decimal = denStr.substring(denStr.indexOf(".") + 1);
            int power = (int) Math.pow(10, decimal.length());
            
            num = (int)(this.getNumerator() * power);            
        }
        else {
            //Can cast from double to int without worry b/c we are guaranteed a
            //whole number
            num = (int) this.getNumerator();
            den = (int) this.getDenominator();
        }

        //Utilize gcd to reduce num and den
        double reducedNum = (double) num / gcd(num, den);
        double reducedDen = (double) den / gcd(num, den);

        if(reducedNum == reducedDen) {
            reducedNum = 1;
            reducedDen = 1;
        }
        
        this.numerator = reducedNum;
        this.denominator = reducedDen;
    }

    /**
     * Main method for testing
     * @param args  String of commands
     */
    public static void main(String[] args) {
        Fraction f = new Fraction(2.5, 6.5);
        Fraction f2 = new Fraction(2, 5.5);
        Fraction f3 = new Fraction(3.5, 9);
        f.reduceFraction();
        if(!f.toString().equals("5/13")) {
            System.out.println("reduceFraction incorrect");
        }
        else {
            System.out.println(".");
        }
        if(!Double.toString(f.getRationalValue()).contains("0.38461")) {
            System.out.println("getRationalValue incorrect");
        }
        else {
            System.out.println(".");
        }
        if(f.compareTo(f2) != 1) {
            System.out.println("compareTo incorrect");
        }
        else {
            System.out.println(".");
        }
        f3.reduceFraction();
        if(!f3.toString().equals("7/18")) {
            System.out.println("reduceFraction incorrect");
        }
        else {
            System.out.println(".");
        }
        if(!Double.toString(f3.getRationalValue()).contains("0.38888")) {
            System.out.println("getRationalValue incorrect");
        }
        else {
            System.out.println(".");
        }
        if(f3.compareTo(f2) != 1) {
            System.out.println("compareTo incorrect");
        }
        else {
            System.out.println(".");
        }
    }
}
