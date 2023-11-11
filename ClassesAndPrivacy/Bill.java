/**
 * This class represents a bill that contains data related to 
 * an outstanding or paid bill of a specific amount of money.  
 * The class should contain the amount of the bill as a Money object, 
 * the due date of the bill (a Date object) and a Date object to track 
 * the date paid (null if not yet paid). 
 * 
 * @author Khanh Nguyen
 * @version 10/27/23
 */
public class Bill {
    private Money amount;
    private Date dueDate; //Should be later then paid date
    private Date paidDate; //Should be earlier than due date
    private String originator; //Should never be empty

    /**
     * Constructor with parameters
     * @param amount        The bill amount
     * @param dueDate       The bill due date
     * @param originator    Company or institution who issued the bill
     * @throws Exception    Thrown if class invariant is violated
     */
    public Bill(Money amount, Date dueDate, String originator) throws Exception {   
        this.amount = new Money(amount);
        //It's ok not to check for class invariant here because paid date is still null
        this.dueDate = new Date(dueDate); 
        this.originator = originator;
        this.paidDate = null;
    }

    /**
     * Copy constructor
     * @param toCopy        The other Bill object
     * @throws Exception    Thrown if object is null
     */
    public Bill(Bill toCopy) throws Exception {
        if(toCopy == null) {
            throw new NullPointerException("Bill doesn't exist");
        }
        this.amount = toCopy.amount;
        this.dueDate = toCopy.dueDate;
        this.paidDate = toCopy.paidDate;
        this.originator = toCopy.originator;
        
    }

    /**
     * Returns the due date
     * @return              The due date   
     * @throws Exception    Thrown if due date is not valid date
     */
    public Date getDueDate() throws Exception {
        return new Date(dueDate);
    }

    /**
     * Returns the paid date
     * @return              The paid date
     * @throws Exception    Thrown if the paid date is not a valid date
     */
    public Date getPaidDate() throws Exception {
        return new Date(paidDate);
    }

    /**
     * Returns the party that issued the bill
     * @return    The company or institution
     */
    public String getOriginator() {
        return this.originator;
    }

    /**
     * Checks if a bill is already paid
     * @return  True if the bill is paid
     */
    public boolean isPaid() {
        if(this.paidDate == null) {
            return false;
        }
        return true;
    }

    /**
     * Sets the paid date
     * @param onDay         Date to set to 
     * @throws Exception    Thrown if paid date is later than due date
     */
    public void setPaid(Date onDay) throws Exception {
        if(this.dueDate.isAfter(onDay)) { //Check if paid date is after due date
            throw new Exception("Paid date cannot be later than due date");
        }
        else {
            this.paidDate = new Date(onDay);
        }
    }

    /**
     * Make the bill unpaid
     */
    public void setUnpaid() {
        this.paidDate = null;
    }

    /**
     * Set the due date of the bill
     * @param nextDate      The due date
     * @throws Exception    Thrown if date is not valid or violates class invariants
     */
    public void setDueDate(Date nextDate) throws Exception {
        if(this.paidDate.isAfter(nextDate)) { //Check if due date is before paid date
            throw new Exception("Due date cannot be earlier than paid date");
        }
        if(isPaid()) {
            System.out.println("Bill is already paid.");
        }
        this.dueDate = new Date(nextDate);
    }

    /**
     * Change the amount
     * @param amount        The amount to change to
     * @throws Exception    Thrown if bill is already paid
     */
    public void setAmount(Money amount) throws Exception {
        this.amount = new Money(amount);
    }

    /**
     * Provide the Money object for the bill that is the amount
     * @return              The Money object amount
     * @throws Exception    Thrown if money object is null
     */
    public Money getAmount() throws Exception {
        return new Money(amount);
    }

    /**
     * Change the originator
     * @param originator    The party that issued the bill
     */
    public void setOriginator(String originator) {
        this.originator = originator;
    }

    /**
     * Prints a string that reports the amount, when its due, 
     * to whom, whether paid, and if paid, the date paid.
     */
    @Override
    public String toString() {
        String paid = "";
        String unpaid = "";
        if(isPaid()) { //Prints if bill is paid
            paid += "Status: Paid" + "\n";
            paid += "Bill is paid on: " + this.paidDate.toString() + "\n";
            paid += "Bill was due on: " + this.dueDate.toString() + "\n";
            paid += "Bill issued by: " + this.getOriginator();
            return paid;
        }
        else { //Prints if bill is unpaid
            unpaid += "Status: Not paid" + "\n";
            unpaid += "Amount owed: " + this.amount + "\n";
            unpaid += "Bill is due on: " + this.dueDate.toString() + "\n";
            unpaid += "Bill issued by: " + this.getOriginator();
            return unpaid;
        }
    }

    /**
     * Determine if the two bills are identical
     * @param toCompare     The other Bill object
     * @return              True if the two Bills are equal
     * @throws Exception    Thrown if a Bill is null
     */
    public boolean equals(Bill toCompare) throws Exception {
        if(toCompare == null) {
            throw new NullPointerException("Bill doesn't exist");
        }
        return this.getAmount().equals(toCompare.getAmount()) && 
            this.getDueDate().equals(toCompare.getDueDate()) && 
            this.isPaid() == toCompare.isPaid() && 
            this.getOriginator().equals(toCompare.getOriginator());
    }


}
