import java.io.Serializable;
import java.lang.Cloneable;

/**
 * This class is used to track a USD amount consisting of 
 * two integers to manage dollars and cents. All dollars and cents 
 * will be positive or 0, and cents will never exceed 99. 
 * 
 * @author Khanh Nguyen
 * @version 10/27/23
 */
public class Money implements Comparable, Cloneable, Serializable {
    private int dollars; //Dollar value: Cannot be < 0
    private int cents; //Cent value: Be between [0-99]

    /**
     * This constructor initializes using dollars input and assumes no cents
     * @param dol   Amount of dollars
     * @throws Exception   Thrown if class invariants are violated
     */
    public Money(int dol) throws Exception {
        this.dollars = dol;
        this.cents = 0;
        checkMoney();
    }

    /**
     * This constructor initializes dollars and cents accordingly
     * @param dol   Amount of dollars
     * @param cent  Amount of cents
     * @throws Exception   Thrown if class invariants are violated
     */
    public Money(int dol, int cent) throws Exception {
        this.dollars = dol;
        this.cents = cent;
        checkMoney(); //Check if class invariants were violated
    }

    /**
     * Copy constructor for Money
     * @param other     The other Money object
     * @throws Exception
     */
    public Money(Money other) throws NullPointerException {
        if(other == null) {
            throw new NullPointerException("Money object is null");
        }
        this.dollars = other.dollars;
        this.cents = other.cents;
        checkMoney(); //Check if class invariants were violated
    }

    /**
     * Creates and returns a copy of Money object.
     * @return  A cloned Money object
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Money copy = (Money) super.clone();
        return copy;
    }

    /**
     * Return the amount of dollars
     * @return  The dollar amount
     */
    public int getDollars() {
        return this.dollars;
    }

    /**
     * Return the amount of cents
     * @return  The cent amount
     */
    public int getCents() {
        return this.cents;
    }

    /**
     * Sets the dollar amount
     * @param dol   Dollar amount to set to
     * @throws Exception   thrown if class invariants are violated
     */
    public void setDollars(int dol) throws Exception {
        this.dollars = dol;
        checkMoney(); //Check if dollars are bigger than 0
    }

    /**
     * Sets the cent amount
     * @param cent  Cent amount to set to
     * @throws Exception  thrown if class invariants are violated
     */
    public void setCents(int cent) throws Exception {
        this.cents = cent;
        checkMoney(); //Check if cents are between [0-99]
    }

    /**
     * A getter for the total monetary amount, as a double 
     * For example: 5.75
     * @return  The total amount of money
     */
    public double getMoney() {
        Double tempCents = (double) this.cents;
        tempCents /= 100; //Convert into proper form (1 cent = 0.01 dollar)
        double total = this.dollars + tempCents;
        return total;
    }

    /**
     * Sets the dollars and cents, accordingly 
     * @param dol   The dollar amount
     * @param cent  The cent amount
     * @throws Exception
     */
    public void setMoney(int dol, int cent) throws Exception {
        this.setDollars(dol);
        this.setCents(cent);
        checkMoney(); // Check if class invariants were violated
    }

    /**
     * Adds the int passed into the function to dollars
     * Should accept positive and negative arguments.
     * @param dol   Dollar amount to add
     */
    public void add(int dol) {
        this.dollars += dol;
        checkMoney();
    }

    /**
     * Adds to dollars and cents the two ints passed into the function.
     * Should accept positive and negative arguments 
     * Both arguments have to be positive or negative.
     * @param dol       Dollar amount to add
     * @param cents     Cent amount to add
     * @throws Exception    thrown if class invariant is violated
     */
    public void add(int dol, int cents) throws Exception {
        this.dollars += dol;
        this.cents += cents;
        //Check if both dol and cents are negative or positive
        if(this.dollars < 0 && this.cents > 0 || this.dollars > 0 && this.cents < 0) {
            throw new IllegalArgumentException("Both dollars and cents have to be positive or negative");
        }
        checkMoney(); //Check if class invariants were violated
    }

    /**
     * Adds to this object the dollars and cents stored in the other object.
     * @param other  The other Money object
     */
    public void add(Money other) {
        this.dollars += other.getDollars();
        this.cents += other.getCents();
        checkMoney(); //Check if class invariants were violated
    }

    /**
     * Determines if this money object is equal to that Money object
     * @param o  The other Money object
     * @return  True if the total amounts are equal
     * @throws IllegalArgumentException     thrown if Money object is null
     */
    public boolean equals(Object o) throws IllegalArgumentException {
        if(!(o instanceof Money) || o == null) { //Check if object is a Money object
            throw new IllegalArgumentException("Not a money object");
        }
        Money other = (Money) o;
        return this.dollars == other.dollars && this.cents == other.cents;
    }

    /**
     * Compares this Money object with another Money object and returns 
     * a negative integer, zero, or a positive integer if this Money object
     * amount is less than, equal to, or greater than the other Money object amount.
     * @param o   The Money object to compare
     * @return    -1 if less than, 0 if equal to, or 1 if greater than
     */
    public int compareTo(Object o) {
        //Check if passed-in object is null
        if(o == null) {
            throw new IllegalArgumentException("Money object is null");
        }
        //Check if object is of class Money
        if(o.getClass() != this.getClass()) {
            throw new IllegalArgumentException("Not a Money object");
        }

        Money other = (Money) o;
        //If this Money object is greater than the other Money object, return 1
        if(this.getMoney() > other.getMoney()) {
            return 1;
        }
        //If this Money object is equal to the other Money object, return 0
        else if(this.getMoney() == other.getMoney()) {
            return 0;
        }
        //If this Money object is less than the other Money object, return
        else {
            return -1;
        }
    }

    /**
     * Prints out a Money object as a String, such as “$3.75”
     * @return a String representation of Money
     */
    @Override
    public String toString() {
        return "$" + Double.toString(this.getMoney());
    }

    /**
     * Private method to check if class invariants are broken
     */
    private void checkMoney() {
        if(this.dollars < 0 || this.cents < 0) {
            throw new IllegalArgumentException("You cannot have negative money");
        }
        if(this.cents > 99) {
            this.dollars += this.cents / 100;
            this.cents %= 100;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Money Test Starts:");
        Money money1 = new Money(10);
        Money money2 = new Money(money1);
        money1.setMoney(30,50);
        money1.add(10, 101);
        if(money2.equals(money1)) {
            System.out.println("Money equals method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(money2.getCents() != 0) {
            System.out.println("getCents method is wrong!");
        }
        else{
            System.out.println(".");
        }
        if(money2.getDollars() != 10) {
            System.out.println("getDollars method is wrong!");
        }
        else{
            System.out.println(".");
        }
        if(money1.toString().compareTo("$41.51") != 0) {
            System.out.println("Add method is wrong!");
        }
        else {
            System.out.println(".");
        }

        //Money money6 = new Money(-1); //this threw an exception: Test Passed!
        //Money money7 = new Money(null); // this threw an exception: Test Passed!
        //Money money8 = new Money(-10, -100); // this threw an exception: Test Passed!

        Money money3 = new Money(0, 101);
        if(money3.getMoney() != 1.01) {
            System.out.println("getMoney method is incorrect!");
        }
        else{
            System.out.println(".");
        }
        
        Money money4 = new Money(5, 10);
        money4.setCents(90);
        if(money4.getMoney() != 5.90) {
            System.out.println("setCents method is wrong!");
        }
        else {
            System.out.println(".");
        }
        money4.setDollars(200);
        if(money4.getMoney() != 200.9) {
            System.out.println("setDollars method is wrong!");
        }
        else {
            System.out.println(".");
        }
        money4.add(money2);
        if(money4.getMoney() != 210.9) {
            System.out.println("add(Money o) method is incorrect!");
        }
        else{
            System.out.println(".");
        }
        money4.add(money1);
        if(money4.getMoney() != 252.41) {
            System.out.println("Privacy leak: The actual reference of money1 was passed in!");
        }
        else{
            System.out.println(".");
        }

        Money money5 = new Money(19, 89);
        money5.add(12345);
        if(money5.getDollars() != 12364) {
            System.out.println("getDollars method is wrong!");
        }
        else{
            System.out.println(".");
        }

        Money money6 = new Money(10, 1);
        if(money6.equals(money5)) {
            System.out.println("Money equals method is wrong!");
        }
        else{
            System.out.println(".");
        }
        if(!(money6.toString().compareTo(money5.toString()) != 0)) {
            System.out.println("toString method is wrong!");
        }
        else{
            System.out.println(".");
        }
        money6 = money5;
        if(!(money6.equals(money5))) {
            System.out.println("Money equals method is wrong!");
        }
        else{
            System.out.println(".");
        }
        if(money6.toString().compareTo(money5.toString()) != 0) {
            System.out.println("toString method is wrong!");
        }
        else{
            System.out.println(".");
        }

        Money money9 = new Money(0, 2001);
        if(money9.getCents() == 2001) {
            System.out.println("Error: Class invariant is not kept");
        }
        System.out.println("All tests passed!");
        System.out.println("--------------------------------------");
    }
}