public class Ingredient implements Comparable<Money>{
    private String description; //Description of ingredient
    private Money cost; //The cost of ingredient
    private int calories; //The calories of the ingredient

    /**
     * Constructor that sets all instance variables
     * in Ingredients
     * @param description   Description of the ingredient
     * @param cost      Cost of the ingredient
     * @param calories      Calories count of the ingredient
     * @throws CloneNotSupportedException
     */
    public Ingredient(String description, Money cost, int calories) {
        this.description = description;
        this.cost = new Money(cost);
        this.calories = calories;
    }

    /**
     * Gets the cost of the ingredient
     * @return  A Money object holding the cost
     * @throws CloneNotSupportedException   thrown if object cannot be cloned
     */
    public Money getCost() {
        return new Money(cost);
    }

    /**
     * Sets the cost of the ingredient
     * @param m     The cost to set to
     * @throws CloneNotSupportedException   Thrown if object cannot be cloned
     */
    public void setCost(Money m) {
        this.cost = new Money(m);
    }

    /**
     * Gets the calorie count of the ingredient
     * @return
     */
    public int getCalories() {
        return this.calories;
    }

    /**
     * Sets the calorie count
     * @param c Calorie amount to set to
     */
    public void setCalories(int c) {
        this.calories = c;
    }

    /**
     * Gets the description of the the ingredient
     * @return  A string description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description
     * @param str   A string to set to
     */
    public void setDescription(String str) {
        this.description = str;
    }

    /**
     * Compares ingredients based on cost. Returns -1, 0, or 1
     * if this ingredient's cost is less than, equal to, or greater than
     * another ingredient
     * @return  An integer
     */
    public int compareTo(Money o) {
        return compareTo(o);
    }

    /**
     * Prints out all attributes of the ingredient
     * @return A String
     */
    public String toString() {
        String str = "";
        str += "Ingredient description: " + getDescription() + "\n";
        str += "Cost: " + getCost() + "\n";
        str += "Calorie Count: " + getCalories() + "\n";

        return str;
    }

    /**
     * Checks if two ingredients are equals. To be equal
     * all of their attributes need to be the same
     * @return  True if equal
     */
    public boolean equals(Object obj) {
        if(!(obj instanceof Ingredient)) {
            throw new IllegalArgumentException("Not an ingredient");
        }

        Ingredient other = (Ingredient) obj;
        return this.getCalories() == other.getCalories() && this.getCost().equals(other.getCost()) && this.getDescription().equals(other.getDescription());
    }

    /**
     * Main method for testing
     * @param args  Strings of commands
     * @throws Exception    thrown if methods throws exception
     */
    public static void main(String[] args) throws Exception {
        Ingredient i = new Ingredient("I1", new Money(1), 1);
        Ingredient i2 = new Ingredient("I2", new Money(2, 5), 2);

        if(!i.getDescription().equals("I1")) {
            System.out.println("getDescription incorrect");
        }
        else {
            System.out.println(".");
        }

        if(i.getCalories() != 1) {
            System.out.println("getCalories incorrect");
        }
        else {
            System.out.println(".");
        }

        if(i.getCost().getMoney() != 1) {
            System.out.println("getCost incorrect");
        }
        else {
            System.out.println(".");
        }

        if(i.getCost().compareTo(i2.getCost()) != -1) {
            System.out.println("getDescription incorrect");
        }
        else {
            System.out.println(".");
        }

        i.setCalories(2);
        if(i.getCalories() != 2) {
            System.out.println("setCalories incorrect");
        }
        else {
            System.out.println(".");
        }

        i.setCost(new Money(2, 5));
        if(i.getCost().compareTo(i2.getCost()) != 0) {
            System.out.println("setCost incorrect");
        }
        else {
            System.out.println(".");
        }

        i.setDescription("NEWDESCRIPTION");
        if(!i.getDescription().equals("NEWDESCRIPTION")) {
            System.out.println("setDescription incorrect");
        }
        else {
            System.out.println(".");
        }

        i2.setCost(new Money(3));
        if(i.getCost().compareTo(i2.getCost()) != -1) {
            System.out.println("compareTo incorrect");
        }
        else {
            System.out.println(".");
        }

        if(i.equals(i2) != false) {
            System.out.println("equals incorrect");
        }
        else {
            System.out.println(".");
        }

        i.setCalories(1);
        i2.setCalories(1);
        i.setCost(new Money(20));
        i2.setCost(new Money(20));
        i.setDescription("Description");
        i2.setDescription("Description");

        if(i.equals(i2) != true) {
            System.out.println("equals incorrect");
        }
        else {
            System.out.println(".");
        }

    }
}
