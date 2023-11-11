/**
 * This class holds a Date object with a specific day, month, and year.
 * 
 * @author Khanh Nguyen
 * @version 10/27/23
 */
public class Date {
    private int day; //Should be between [1-31]
    private int month; //Should be between [1-12]
    private int year; //Should be between [2001-2024]

    /**
     * Default constructor
     */
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2001;
    }

    /**
     * Constructor that sets the month, day, and year
     * @param month                         The month
     * @param day                           The day
     * @param year                          The year
     * @throws IllegalArgumentException    Thrown if a class invariant is violated
     */
    public Date(int month, int day, int year) throws IllegalArgumentException {
        this.month = month;
        this.day = day;
        this.year = year;
        checkDate();
    }

    /**
     * Copy constructor
     * @param other                    The other Date object
     * @throws NullPointerException    Thrown if Date object is null
     */
    public Date(Date other) throws Exception {
        if(other == null) { //Checks if Date obj is null
            throw new NullPointerException("Date doesn't exist");
        }
        this.month = other.month;
        this.day= other.day;
        this.year = other.year;
        checkDate();
    
    }

    /**
     * Returns the day
     * @return  The day
     */
    public int getDay() {
        return this.day;
    }

    /**
     * Returns the month
     * @return  The month
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * Returns the year
     * @return  The year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Sets the day
     * @param day                          Day to set to
     * @throws IllegalArgumentException    Thrown if day violates class invariant
     */
    public void setDay(int day) throws IllegalArgumentException {
        this.day = day;
        checkDate();
    }

    /**
     * Sets the month
     * @param month                        Month to set to
     * @throws IllegalArgumentException    Thrown if month violates class invariant
     */
    public void setMonth(int month) throws IllegalArgumentException {
        this.month = month;
        checkDate();
    }

    /**
     * Sets the year
     * @param year                         Year to set to
     * @throw IllegalArgumentException     Thrown is yeat violates class invariant
     */
    public void setYear(int year) throws IllegalArgumentException {
        this.year = year;
        checkDate();
    }

    /**
     * Sets the Date
     * @param month                         Month to set to
     * @param day                           Day to set to
     * @param year                          Year to set to
     * @throws IllegalArgumentException     Thrown if class invariant is violated
     */
    public void setDate(int month, int day, int year) throws IllegalArgumentException {
        this.month = month;
        this.day = day;
        this.year = year;
        checkDate();
    }

    /**
     * This method compares whether or not another date is after this date.
     * Example: Date other (01/2/2001), this Date (01/1/2001)
     * Result:  this.isAfter(other) == true;
     * 
     * @param other     The other date
     * @return          True if the other date is after this date
     */
    public boolean isAfter(Date other) {
        //Code Reference from: A family member
        int otherDays = other.day + (other.month * 31) + (other.year * 365);
        int thisDays = day + (month * 31) + (year * 365);
        if (otherDays > thisDays)
            return true;
        else
            return false;
    }

    /**
     * This method checks if 2 Date objects are equal
     */
    public boolean equals(Object o) throws IllegalArgumentException {
        if(!(o instanceof Date) || o == null) {
            throw new IllegalArgumentException("Not a Date object");
        }
        Date other = (Date) o;
        return this.month == other.month && this.day == other.day && this.year == other.year;
    }

    /**
     * Prints the date in the format: mm/dd/yyyy
     */
    @Override
    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }
        
    /**
     * Private method to check if class invariants are broken
     * @return      True if they are
     */
    private void checkDate() {
        if(this.month < 1 || this.month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }
        if(this.day < 1 || this.day > 31) {
            throw new IllegalArgumentException("Invalid day");
        }
        if(this.year < 2001 || this.year > 2024) {
            throw new IllegalArgumentException("Invalid year");
        }
    }
}
