import java.awt.Color;
/**
 * This class represents a type of vegetable on a Pizza.
 * It contains the description, cost, and calories of the vegetable.
 * @author Khanh Nguyen
 * @version 12/7/23
 */
public class Vegetable extends Ingredient{
    private Color color;
    /**
     * Constructor for Vegetable that utilize super constructor
     * @param description   The description of the vegetable
     * @param cost  The cost of the vegetable
     * @param calories  The calories of the vegetable
     */
    public Vegetable(String description, Money cost, int calories) {
        super(description, cost, calories);
        this.color = Color.green;
    }

    /**
     * Constructor for the Vegetable that takes in color
     * @param description   The description of the vegetable
     * @param cost  The cost of the vegetable
     * @param calories  The calories of the vegetable
     * @param color   The color of the vegetable given in RBG values
     */
    public Vegetable(String description, Money cost, int calories, Color color) {
        super(description, cost, calories);
        this.color = color;
    }

    /**
     * Gets the color of the vegetable
     * @return  The color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Sets the color of the vegetable
     * @param c  The color to set to
     */
    public void setColor(Color c) {
        this.color = c;
    }

    /**
     * Prints out the information of the vegetable
     * @return A String
     */
    @Override
    public String toString() {
        return super.toString() + "Vegetable Color: " + getColor();
    }

    /**
     * Compares 2 vegetable objects and returns true if all of their
     * attributes are the same
     * @return true if all attributes are the same
     */
    public boolean equals(Object v) {
        if(!(v instanceof Vegetable)) {
            throw new IllegalArgumentException("Not a vegetable object");
        }
        Vegetable other = (Vegetable) v;
        return super.equals(other) && this.color.equals(other.color);
    }

    /**
     * Main method for testing
     * @param args  Strings of commands
     * @throws Exception    thrown if methods called throws an exception
     */
    public static void main(String[] args) throws Exception {
        Vegetable i = new Vegetable("V1", new Money(1), 1);
        Vegetable i2 = new Vegetable("V2", new Money(2, 5), 2);
        Vegetable i3 = new Vegetable("V3", new Money(12, 99), 80, Color.black);

        if(!i.getDescription().equals("V1")) {
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

        i.setDescription("BASEDESCRIPTION");
        if(!i.getDescription().equals("BASEDESCRIPTION")) {
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

        if(i.equals(i3) != false) {
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

        if(i3.getColor() != Color.BLACK) {
            System.out.println("getColor incorrect");
        }
        else {
            System.out.println(".");
        }

        i3.setColor(Color.blue);
        if(i3.getColor() != Color.blue) {
            System.out.println("setColor incorrect");
        }
        else {
            System.out.println(".");
        }
    }
}
