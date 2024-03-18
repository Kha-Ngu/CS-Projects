import java.awt.Color;
/**
 * This class inherits from Vegetable and represents a pepper
 * @author Khanh Nguyen
 * @version 12/7/23
 */
public class Pepper extends Vegetable{
    /**
     * Constructor  
     * @param description    Description of the pepper
     * @param cost   Cost of the pepper
     * @param cal   Calorie count of the pepper
     */
    public Pepper(String description, Money cost, int cal) {
        super(description, cost, cal);
    }

    /**
     * Constructor that sets the color
     * @param description   Description of the pepper
     * @param cost      The cost of the pepper
     * @param cal   The calorie count of the pepper
     * @param color     the color of the pepper
     */
    public Pepper(String description, Money cost, int cal, Color color) {
        super(description, cost, cal, color);
    }

    /**
     * Main method for testing
     * @param args  Strings of commands
     * @throws Exception    thrown if methods called throws an exception
     */
    public static void main(String[] args) throws Exception {
        Pepper i = new Pepper("O1", new Money(1), 1);
        Pepper i2 = new Pepper("O2", new Money(2, 5), 2);
        Pepper i3 = new Pepper("O3", new Money(12, 99), 80, Color.black);

        if(!i.getDescription().equals("O1")) {
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
