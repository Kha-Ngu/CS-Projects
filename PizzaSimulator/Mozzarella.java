/**
 * This class inherits from Cheese and it represents Mozzarella cheese
 * @author Khanh Nguyen
 * @version 12/7/23
 */
public class Mozzarella extends Cheese{
    /**
     * Constructor for Mozzarella
     * @param description   The description of the Mozzarella cheese
     * @param cost  The cost of the Mozzarella cheese
     * @param calories  The calories count of the Mozzarella cheese
     */
    public Mozzarella(String description, Money cost, int calories) {
        super(description, cost, calories);
    }

    /**
     * Main method for testing
     * @param args  Strings of commands
     * @throws Exception    thrown if methods called throws an exception
     */
    public static void main(String[] args) throws Exception {
        Mozzarella i = new Mozzarella("M1", new Money(1), 1);
        Mozzarella i2 = new Mozzarella("M2", new Money(2, 5), 2);

        if(!i.getDescription().equals("M1")) {
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
