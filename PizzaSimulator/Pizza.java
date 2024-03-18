import java.awt.Color;

public class Pizza implements PizzaComparable{
    private ArrayList<Ingredient> arr = new ArrayList<>(1); //List of ingredients
    private int totalCalories; //Sum of all ingredients' calories
    private Money totalCost; //CURRENT sum of all ingredients' costs
    private Shape myShape; //Shape of pizza (square or circle)
    private Fraction remainder; //The amount of pizza left

    /**
     * Constructor that generates a random pizza
     * @throws Exception
     */
    public Pizza() throws Exception {
        this.totalCost = new Money(0);
        this.totalCalories = 0;
        this.arr = getRandIngredients();
        this.myShape = getRandShape();
        this.remainder = new Fraction(1, 1);
    }
    
    /**
     * Constructor for Pizza   
     * Note: Setting the radius/lengths will be done manually in the constructor
     * each time a new Pizza object is created. 
     * For example: Pizza p = new Pizza(new Circle(x, y, z), new Money....);
     * @param shape  The shape of the pizza
     * @param cost  The cost of the pizza
     * @param remainder  The remaining parts of the pizza
     * @param cal   The calorie count of the pizza
     * @throws PizzaException   thrown if Pizza is invalid
     */
    public Pizza(Shape shape, Money cost, Fraction remainder, int cal) throws PizzaException {
        this.myShape = shape;
        this.totalCost = new Money(cost);
        this.remainder = new Fraction(remainder);
        this.totalCalories = cal;
        checkPizza();
    }

    /**
     * Gets the remaining amount of pizza as a fraction
     * @return  A Fraction object
     */
    public Fraction getRemaining() {
        return new Fraction(remainder);
    }

    /**
     * Sets the remaining amount of pizza
     * @param f  Fraction amount
     */
    public void setRemaining(Fraction f) {
        this.remainder = new Fraction(f);
    }

    /**
     * Gets the amount of calories
     * @return  An integer
     */
    public int getCalories() {
        return this.totalCalories;
    }

    /**
     * Gets the total cost of the CURRENT pizza,
     * not necessarily the cost of the full pizza.
     * @return  A Money object
     */
    public Money getCost() {
        return new Money(totalCost);
    }

    /**
     * Returns the list of ingredients
     * @return  An arraylist
     */
    public ArrayList<Ingredient> getList() {
        return this.arr;
    }
    /**
     * Returns the area of the Shape scaled by the fraction
     * of the remaining pizza
     * @return  A double
     */
    public double getRemainingArea() {
        return myShape.getArea() * remainder.getRationalValue();
    }

    /**
     * Adds an ingredient to the list of ingredients and adjusts
     * the cost and calories accordingly
     * @param a    The new ingredient
     */
    public void addIngredient(Ingredient a) {
        this.arr.add(a);
        this.totalCalories += a.getCalories();
        this.totalCost.add(a.getCost());
    }

    /**
     * Subtracts a specified amount from our Fraction of
     * the remaining pizza.
     * @param amt   An amount to "eat" (subtract)
     * @throws Exception    thrown if there is nothing left to eat, or the pizza fraction ends up negative
     */
    public void eatSomePizza(Fraction amt) throws Exception {
        double x1 = this.remainder.getNumerator();
        double y1 = this.remainder.getDenominator();
        double x2 = amt.getNumerator();
        double y2 = amt.getDenominator();

        //The amount of pizza left after subtraction
        double difference = (x1*y2 - x2*y1) / (y1*y2);
        //If there's nothing left to eat
        if(difference == 0) {
            arr.remove(arr.size() - 1);
            throw new PizzaException("No more pizza to eat.");
        }
        //If the amount to eat is negative
        else if(difference < 0) {
            throw new IllegalArgumentException("Can't eat negative pizza");
        }
        //Set the new cost of the pizza after it is eaten
        double moneySubstracted = this.totalCost.getMoney() - this.totalCost.getMoney() * amt.getRationalValue();
        this.totalCost.setMoney((int) moneySubstracted, (int)((moneySubstracted % 1) * 100));

        //Set the Fraction remaining
        double num = (x1*y2) - (x2*y1);
        double den = (y1*y2);
        Fraction temp = new Fraction(num, den);
        temp.reduceFraction();
        this.setRemaining(temp);
    }

    /**
     * Sets the shape of the pizza
     * @param s   The shape to set to
     * @throws CloneNotSupportedException   Thrown if shape is not cloneable
     */
    public void setShape(Shape s) throws CloneNotSupportedException {
        myShape = (Shape) s.clone();
    }

    /**
     * Gets the shape of the pizza
     * @return  The shape
     * @throws CloneNotSupportedException   Thrown if shape is not cloneable
     */
    public Shape getShape() throws CloneNotSupportedException {
        return (Shape) myShape.clone();
    }

    /**
     * Compare two pizzas by the amount of area left
     * @param o   The other pizza
     * @return    1 if this pizza has a greater area, 0 if the same, and -1 if less
     */
    public int compareToBySize(Object o) throws IllegalArgumentException {
        //Check if object o is a Pizza and is not null
        if(o.getClass() != this.getClass() || o == null) {
            throw new IllegalArgumentException("Not a pizza");
        }

        Pizza other = (Pizza) o;
        if(this.getRemainingArea() > other.getRemainingArea()) {
            return 1;
        }
        else if(this.getRemainingArea() < other.getRemainingArea()) {
            return -1;
        }
        else {
            return 0;
        }
    }    

    /**
     * Compare two pizzas by their calorie count
     * @param o   The other pizza
     * @return    1 if this pizza has more calories, 0 if the same, -1 if less
     */
	public int compareToByCalories(Object o) throws IllegalArgumentException {
        if(o.getClass() != this.getClass() || o == null) {
            throw new IllegalArgumentException("Not a pizza");
        }

        Pizza other = (Pizza) o;
        if(this.getCalories() > other.getCalories()) {
            return 1;
        }
        else if(this.getCalories() < other.getCalories()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    /**
     * Compares Pizza objects based on price. Returns
     * 1, 0, or -1 if this pizza cost less, equal, or more
     * than the other pizza.
     * @return An integer
     */
    @Override
    public int compareTo(Object o) {
        if(o.getClass() != this.getClass() || o == null) {
            throw new IllegalArgumentException("not a valid pizza");
        }
        Pizza other = (Pizza) o;
        return this.getCost().compareTo(other.getCost());
    }

    /**
     * Returns a string that containing all attributes of
     * the pizza object
     * @return A String
     */
    public String toString() {
        String str = "";
        str += "Pizza has a price: " + this.getCost() + " and calories " + this.getCalories() + ", ";
        str += "Fraction remaining: " + this.getRemaining() + " and area left: " + this.getRemainingArea();
        try {
            if(this.getShape().toString().contains("Square")) {
                str += " and Shape: Square";
            }
            else {
                str += " and Shape: Circular";
            }
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }

        return str;
    }

    /**
     * Check for class invariant violations
     * @throws PizzaException
     */
    private void checkPizza() throws PizzaException {
        if(this.remainder.getRationalValue() != 1) {
            throw new PizzaException("Pizza needs to start with 100% of its area");
        }
    }

    /**
     * Get a random shape from the provided list of shapes
     * @return	A shape
     */
    private Shape getRandShape() {
        Shape retVal = null;
        final int x = (int) ( Math.random() * 200 );
        final int y = (int) ( Math.random() * 200 );

        switch( ( int )(Math.random() * 2) ) {
            case 0: 	retVal = new Circle(x, y, Color.BLUE, (int) ( Math.random() * 200 )); //A Circle
                        break;
            case 1: 	retVal = new Square(x, y, (int) ( Math.random() * 200 )); //A Square
                        break;			
        }
    
        return retVal;
    }

    /**
     * Generates a list of random ingredients
     * @return  An arraylist with random ingredients
     * @throws Exception    thrown if the ingredients throws exception
     */
    private ArrayList<Ingredient> getRandIngredients() throws Exception {
        ArrayList<Ingredient> temp = new ArrayList<>();

        while(temp.size() < 12) {
            switch((int)(Math.random() * 12)) {
                case 0:     Ingredient a = new Alfredo("Alfredo", new Money((int) (Math.random() * 200)), (int)(Math.random()*200));
                            addIngredient(a);
                            break;
                case 1:     Ingredient b = new Goat("Goat", new Money((int)(Math.random() * 200)), (int)(Math.random()*200));
                            addIngredient(b);
                            break;
                case 2:     Ingredient c = new Mozzarella("Mozzarella", new Money((int)(Math.random() * 200)), (int)(Math.random()*200));
                            addIngredient(c);
                            break;
                case 3:     Ingredient d = new Pepperoni("Pepperoni", new Money((int)(Math.random() * 200)), (int)(Math.random()*200));
                            addIngredient(d);
                            break;
                case 4:     Ingredient e = new Sausage("Sausage", new Money((int)(Math.random() * 200)), (int)(Math.random()*200));
                            addIngredient(e);
                            break;
                case 5:     Ingredient f = new Marinara("Marinara", new Money((int)(Math.random() * 200)), (int)(Math.random()*200));
                            addIngredient(f);
                            break;
                case 6:     Ingredient g = new Olive("Olive", new Money((int)(Math.random() * 200)), (int)(Math.random()*200));
                            addIngredient(g);
                            break;
                case 7:     Ingredient h = new Pepper("Pepper", new Money((int)(Math.random() * 200)), (int)(Math.random()*200));
                            addIngredient(h);
                            temp.add(h);
                            break;
                case 8:     Ingredient i = new Cheese("Cheese", new Money((int)Math.random() * 200), (int)Math.random()*200);
                            addIngredient(i);
                            break;
                case 9:     Ingredient j = new Meat("Meat", new Money((int)Math.random() * 200), (int)Math.random()*200);
                            addIngredient(j);
                            break;
                case 10:    Ingredient k = new Base("Base", new Money((int)Math.random() * 200), (int)Math.random()*200);
                            addIngredient(k);
                            break;
                case 11:    Ingredient l = new Vegetable("Vegetable", new Money((int)Math.random() * 200), (int)Math.random()*200);
                            addIngredient(l);
                            break;
            }
        }

        return temp;
    }

    /**
     * Main method for testing
     * @param args  Strings of commands
     * @throws Exception    thrown if any method throws exception
     */
    public static void main(String[] args) throws Exception{
        Pizza p1 = new Pizza(new Circle(1, 2, Color.black, 10), new Money(200), new Fraction(5, 5), 120);
        
        System.out.println("Pizza Test Start");

        //Testing getters and setters
        if(p1.getCalories() != 120) {
            System.out.println("getCalories is incorrect");
        }
        else {
            System.out.println(".");
        }

        if(p1.getCost().getMoney() != 200) {
            System.out.println("getCost incorrect");
        }
        else {
            System.out.println(".");
        }

        if(p1.getRemaining().getRationalValue() != 1) {
            System.out.println("getRemaining incorrect");
        }
        else {
            System.out.println(".");
        }
        p1.setRemaining(new Fraction(1, 5));
        if(!p1.getRemaining().equals(new Fraction(1, 5))) {
            System.out.println("setRemaining is wrong");
        }
        else {
            System.out.println(".");
        }
        p1.setShape(new Circle(1, 1, Color.black, 2));
        if(!p1.getShape().toString().contains("Circle")) {
            System.out.println("setShape inccorect");
        }
        else {
            System.out.println(".");
        }

        p1.addIngredient(new Alfredo("Alfredo", new Money(15), 200));

        //Testing addIngredient
        if(p1.getCalories() != 320) {
            System.out.println("addIngredient is wrong");
        }
        else {
            System.out.println(".");
        }
        if(p1.getCost().getMoney() != 215) {
            System.out.println("addIngredient is wrong");
        }
        else {
            System.out.println(".");
        }
        p1.setRemaining(new Fraction(5, 5));
        p1.eatSomePizza(new Fraction(1, 5));
        //Testing eatSomePizza
        if(!p1.getRemaining().equals(new Fraction(4, 5))) {
            System.out.println("eatSomePizza incorrect");
        }
        else {
            System.out.println(".");
        }
        //p1.eatSomePizza(new Fraction(4, 5)); Test Passed: Threw exception when amount gets to 0
        p1.eatSomePizza(new Fraction(2, 5));
        if(!p1.getRemaining().equals(new Fraction(2, 5))) {
            System.out.println("eatSomePizza incorrect");
        }
        else {
            System.out.println(".");
        }

        //Pizza p2 = new Pizza(new Square(1, 1, 4), new Money(20, 9), new Fraction(6, 10), 0);  Test Passed: Exception thrown b/c Pizza didn't start w/ 100% area
        Pizza p2 = new Pizza(new Square(1, 1, 4), new Money(20, 9), new Fraction(10, 10), 0);
        p2.addIngredient(new Alfredo("Alfredo", new Money(1), 10));
        p2.addIngredient(new Sausage("Sausage", new Money(12), 20));
        p2.addIngredient(new Marinara("Marinara", new Money(22, 1), 30));

        if(p2.arr.size() != 3) {
            System.out.println("addIngredient incorrect");
        }
        else {
            System.out.println(".");
        }

        if(p2.getCalories() != 60) {
            System.out.println("getCalories incorrect");
        }
        else {
            System.out.println(".");
        }
        //Test getRemainingArea and if cost changes accordingly to amount eaten
        p2.eatSomePizza(new Fraction(2, 5));
        if(p2.getRemainingArea() != 9.6) {
            System.out.println("getRemainingArea incorrect");
        }
        else {
            System.out.println(".");
        }
        if(p2.getCost().getMoney() != 33.06) {
            System.out.println("Current amount of money did not change after eating");
        }
        else {
            System.out.println(".");
        }

        Pizza p3 = new Pizza(new Circle(1, 1, Color.black, 1), new Money(10, 22), new Fraction(1, 1), 315);
        p3.eatSomePizza(new Fraction(1, 5));
        if(p3.getRemainingArea() != (Math.PI * 0.8)) {
            System.out.println("getRemainingArea is wrong");
        }
        else{
            System.out.println(".");
        }
        if(p3.getCost().getMoney() != 8.17) {
            System.out.println("Current amount of money did not change after eating");
        }
        else {
            System.out.println(".");
        }
        if(!p3.getRemaining().equals(new Fraction(4, 5))) {
            System.out.println("Remaining fraction did not change");
        }
        else {
            System.out.println(".");
        }

        //Testing compare methods
        if(p1.compareTo(p2) != 1) {
            System.out.println("compareTo based on price wrong");
        }
        else {
            System.out.println(".");
        }
        if(p2.compareTo(p1) != -1) {
            System.out.println("compareTo based on price wrong");
        }
        else {
            System.out.println(".");
        }
        if(p1.compareToBySize(p3) != 1) {
            System.out.println("compareToBySize wrong");
        }
        else {
            System.out.println(".");
        }
        if(p2.compareToBySize(p1) != 1) {
            System.out.println("compareToBySize wrong");
        }
        else {
            System.out.println(".");
        }
        if(p3.compareToByCalories(p1) != -1) {
            System.out.println("compareToByCalories wrong");
        }
        else {
            System.out.println(".");
        }
        if(p2.compareToByCalories(p3) != -1) {
            System.out.println("compareToByCalories wrong");
        }
        else {
            System.out.println(".");
        }

        Pizza z = new Pizza();
        System.out.println(z.toString()); //Test Passed: Generated a random Pizza object
    }
}
