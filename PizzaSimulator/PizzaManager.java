import java.util.Scanner;

public class PizzaManager {
    private ArrayList<Pizza> arr = new ArrayList<>(1);;

    /**
     * Constructor for PizzaManager. Handles all user input
     * @throws Exception    thrown if any method throws an exception
     */
    public PizzaManager() throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Welcome to Pizza Manager");
        System.out.println("-------------------------");
        System.out.println("(A)dd a random pizza");
        System.out.println("Add a (H)undred random pizzas");
        System.out.println("(E)at a fraction of a pizza");
        System.out.println("Sort pizzas by (P)rice");
        System.out.println("Sort pizzas by (S)ize");
        System.out.println("Sort pizzas by (C)alories");
        System.out.println("(B)inary Search pizzas by calories");
        System.out.println("(Q)uit");
        
        String choice = input.nextLine().toUpperCase();

        while(!choice.equals("Q")) {
            switch(choice.toUpperCase()) {
                case "A":   System.out.println("Adding a ramdom pizza to ArrayList");
                            Pizza newP = new Pizza();
                            arr.add(newP);
                            System.out.println(newP.toString());
                            break;
                case "H":   System.out.println("Adding a hundred ramdom pizzas to ArrayList");
                            for(int i = 0; i < 100; i++) {
                                try {
                                    arr.add(new Pizza());
                                } catch (Exception e) {
                                    System.out.println("Not a valid pizza");
                                }
                            }
                            break;
                case "E":   eatSomePizza(input);
                            break;
                case "P":   System.out.println("Sorting Pizzas by (P)rice");
                            sortByPrice();
                            displayAllPizzas();
                            break;
                case "S":   System.out.println("Sorting Pizzas by (S)ize");
                            sortBySize();
                            displayAllPizzas();
                            break;
                case "C":   System.out.println("Sorting Pizzas by (C)alories");
                            sortByCalories();
                            displayAllPizzas();
                            break; 
                case "B":   System.out.println("Performing Binary Search");
                            System.out.println("Enter a value to look for:");
                            int target = input.nextInt();
                            System.out.println(binarySearchByCalories(target));
                            break;
            }
            choice = input.nextLine();
        }
        System.out.println("Exiting Pizza Manager...");
        System.exit(0);
    }

    /**
     * Prints out all of the pizzas in the arraylist in their current order
     */
    public void displayAllPizzas() {
        System.out.println(arr.toString());
    }

    /**
     * A function to subtract a fractional amount from a Pizza
     * @param keys  Scanner to take in user input
     * @throws Exception    thrown if methods in pizza throws an exception
     */
    public void eatSomePizza(Scanner keys) throws Exception {
        System.out.println("Eating a fraction of a pizza. How much? (a/b)");
        String[] frac = keys.next().split("/");
        Fraction f = new Fraction(Double.parseDouble(frac[0]), Double.parseDouble(frac[1]));
        f.reduceFraction();
        System.out.println("At which index?");
        int index = keys.nextInt();
        Pizza p = (Pizza) arr.get(index);
        try {    
            p.eatSomePizza(f);
        }
        catch(PizzaException e) {
            arr.remove(index);
        }
        catch(IllegalArgumentException e) {
            System.out.println("Cannot have negative pizza.");
        }
        catch(Exception e) {
            System.out.println("Pizza is invalid");
        }
        System.out.println(p.toString());
    }

    /**
     * Utilizes selection sort to sort Pizzas
     * in order from greatest calories to least 
     */
    public void sortByCalories() {
        int n = arr.size();
        for(int i = 0; i < n - 1; i++) {
            int max_idx = i;
            
            for(int j = i+1; j < n; j++) { 
                Pizza p = (Pizza) arr.get(max_idx);
                if(((Pizza) arr.get(j)).getCalories() > p.getCalories()) {
                    max_idx = j;
                }
            }
        
            arr.swap(max_idx, i);
        }
    }
    /**
     * Utilizes insertion sort to sort Pizzas
     * in order from greatest price to least 
     */
    public void sortByPrice() {
        int n = arr.size();
        for(int i = 1; i < n; i++) {
            Pizza key = (Pizza) arr.get(i);
            int j = i - 1;

            while(j >= 0 && ((Pizza)arr.get(j)).getCost().compareTo(key.getCost()) == -1) {
                arr.set(j + 1, (Pizza) arr.get(j));
                --j;
            }
            arr.set(j + 1, key);
        }
    }

    /**
     * Utilizes selection sort to sort Pizzas
     * in order from greatest calories to least 
     */
    public void sortBySize() {
        int n = arr.size();
        for(int i = 0; i < n - 1; i++) {
            int max_idx = i;

            for(int j = i+1; j < n; j++) { 
                Pizza p = (Pizza) arr.get(max_idx);
                if(((Pizza) arr.get(j)).getRemaining().compareTo(p.getRemaining()) == 1) {
                    max_idx = j;
                }
            }
            arr.swap(max_idx, i);
        }
    }

    /**
     * Utlizes binary search to search for pizzas
     * with a specific calorie count
     * @param targetCal  Specified calorie count
     * @return  index of where the pizza is
     */
    public int binarySearchByCalories(int targetCal) {
        sortByCalories();
        int l = 0;
        int r = arr.size() - 1;
        
        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(targetCal == ((Pizza)arr.get(mid)).getCalories()) {
                return mid;
            }
            else if(targetCal < ((Pizza)arr.get(mid)).getCalories()) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws PizzaException, Exception {
        PizzaManager a = new PizzaManager();
        a.arr.add(new Pizza(new Square(1, 1, 10), new Money(10, 20), new Fraction(5, 5), 600));
        a.arr.add(new Pizza(new Square(1, 1, 10), new Money(10, 30), new Fraction(5, 5), 702));
        a.arr.add(new Pizza(new Square(1, 1, 10), new Money(10, 40), new Fraction(5, 5), 401));
        a.arr.add(new Pizza(new Square(1, 1, 10), new Money(10, 50), new Fraction(5, 5), 204));
        a.arr.add(new Pizza(new Square(1, 1, 10), new Money(10, 60), new Fraction(5, 5), 103));
        a.arr.add(new Pizza(new Square(1, 1, 10), new Money(10, 70), new Fraction(5, 5), 806));
        a.arr.add(new Pizza(new Square(1, 1, 10), new Money(10, 80), new Fraction(5, 5), 905));
        a.arr.add(new Pizza(new Square(1, 1, 10), new Money(10, 80), new Fraction(5, 5), 1005));
        Scanner input = new Scanner(System.in);

        a.sortByCalories();
        System.out.println("------------------------");
        if(a.binarySearchByCalories(600) != 4) {
            System.out.println("sortByCalories incorrect");
        }
        else {
            System.out.println(".");
        }

        a.sortByPrice();

        
        

    }
}
