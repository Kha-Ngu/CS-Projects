/**
 * This class is used to track a USD amount consisting of 
 * two integers to manage dollars and cents. All dollars and cents 
 * will be positive or 0, and cents will never exceed 99. 
 * 
 * @author Khanh Nguyen
 * @version 10/27/23
 */
public class Money {
    private int dollars; //Dollar value: Cannot be < 0
    private int cents; //Cent value: Be between [0-99]

    /**
     * This constructor initializes using dollars input and assumes no cents
     * @param dol   Amount of dollars
     * @throws Exception
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
     * @throws Exception
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
    public Money(Money other) throws Exception {
        if(other == null) {
            throw new NullPointerException("Money object doesn't exist");
        }
        this.dollars = other.dollars;
        this.cents = other.cents;
        checkMoney(); //Check if class invariants were violated
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
     * @throws Exception
     */
    public void setDollars(int dol) throws Exception {
        this.dollars = dol;
        checkMoney(); //Check if dollars are bigger than 0
    }

    /**
     * Sets the cent amount
     * @param cent  Cent amount to set to
     * @throws Exception
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
     * @param dol
     * @param cent
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
    }

    /**
     * Adds to dollars and cents the two ints passed into the function.
     * Should accept positive and negative arguments 
     * Both arguments have to be positive or negative.
     * @param dol       Dollar amount to add
     * @param cents     Cent amount to add
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
     * @return True if the total amounts are equal
     */
    public boolean equals(Object o) throws IllegalArgumentException {
        if(!(o instanceof Money) || o == null) { //Check if object is a Money object
            throw new IllegalArgumentException("Not a money object");
        }
        Money other = (Money) o;
        return this.dollars == other.dollars && this.cents == other.cents;
    }

    /**
     * Prints out a Money object as a String, such as “$3.75”
     * @return a String
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
}