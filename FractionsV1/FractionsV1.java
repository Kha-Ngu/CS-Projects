import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class reads a series of fractions from a text file, each formatted as: "A/B".
 * The purpose of the class is to read each fraction and counts the amount of occurrences 
 * for the current fraction. When all the input is consumed (or as the input is consumed), 
 * the class will print out its list of unique fraction and their corresponding count. 
 * 
 * @author (Khanh Nguyen)
 * @version (10/5/23)
 */
public class FractionsV1
{   
    // ArrayList to hold all of the fractions in strings
    static ArrayList<String> fractions = new ArrayList<String>(); 
    // ArrayList to hold all of the unique fraction forms
    static ArrayList<String> uniqueFrac = new ArrayList<String>();
    // ArrayList to hold the counts for each unique fraction 
    static ArrayList<Integer> count = new ArrayList<Integer>(); 
    
    /**
     * This is the main method where we will test if the program works
     * by calling all of the methods.
     * @param args   The supplied command-line arguments
     */
    public static void main (String[] args) {
        //Here we input the text file "fractions.txt" required for testing
        File fracTXT = new File ("fractions.txt"); 

        //This calls the storeFractions method on the input file
        storeFractions(fracTXT); 
        //This calls the countOccurences method on the result of the storeFractions method
        countOccurences(); 
        //This prints the output in this format: "6/8 has a count of 1"
        printOccurences(); 
        
    }
    
    /**
     * This method takes in an input file, and includes a scanner that scans 
     * the input file line by line and pass the fraction on each line into the 
     * String array 'fractions' so that it holds all of the fractions separately 
     * in strings. It also includes an exception wrap in the case that Java 
     * throws the FileNotFoundException error.
     * @param file   the input text file that holds the strings of fractions
     */
    public static void storeFractions (File file) {
        try {
            Scanner scanner = new Scanner(new File("fractions.txt"));
            // This while loop scans the text file until there are no tokens left to scan
            while(scanner.hasNext()) { 
                String str = scanner.nextLine();
                //add the string that the scanner just scanned to the ArrayList fractions
                fractions.add(str); 
            }
        } 
        // catches the error if it occurs and prints out an error message
        catch (FileNotFoundException e) { 
            System.out.println("Error");
        }     
    }
    
    /**
     * This recursive method is Euclid's GCD algorithm, it takes in the numerator and
     * denominator returns the greatest common factor between them. 
     * @param numerator    The numerator of the fraction
     * @param denominator  The denominator of the fraction
     * @return             The greatest common factor
     */
    //This gcd function comes from: geeksforgeeks.org/java-program-to-compute-gcd/
    public static int gcd(int numerator, int denominator) {
        if (denominator == 0) {
            return numerator;
        }
        return gcd(denominator, numerator % denominator);
    }
    
    /**
     * This method traverses through the fractions ArrayList and 
     * takes out the '/' using the split() method so that we have
     * an array of only the numbers. Then we access the numerator
     * and denominator numbers in the array (still strings at this point) 
     * and convert them to actual numbers using Integer.parseInt(). Then
     * we divide them both by their greatest common factor and pass their
     * simplified values into a num and den variable accordingly. Then we
     * create a string object to store those simplified forms, using
     * Integer.toString() to turn them back into strings so that their
     * final form will look like "3/4". Then, an if statment passes the
     * string into the uniqueFrac arraylist if it is our first iteration,
     * because it is guaranteed to be unique. Every iteration after that 
     * will go into the else statement, which checks if this string value 
     * already exists in the uniqueFrac. If not, it will add the string 
     * to the array and add a count of 1 to the corresponding count[] array index. 
     * If it is, then it will just increment the count value in the count[] array 
     * where the index corresponds with the index of the fraction in the uniqueFrac 
     * arraylist.
     */
    public static void countOccurences() {
        // for loop to traverse through fractions arraylist
        for(int i = 0; i < fractions.size(); i++) { 
            // The string will hold an array like this: {"6", "8"}
            String[] arr = fractions.get(i).split("/"); 
            // the simplified numerator
            int num = Integer.parseInt(arr[0]) / gcd(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
            // the simplified denominator 
            int den = Integer.parseInt(arr[1]) / gcd(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])); 
            
            // The string will hold a string in this format: "3/4"
            String str = Integer.toString(num) + "/" + Integer.toString(den); 
            
            // base case
            if(i == 0) { 
                uniqueFrac.add(str);
                count.add(1);
            }
            else {
                // if the str value does not yet exist in the uniqueFrac arrayList
                if (!uniqueFrac.contains(str)) { 
                    uniqueFrac.add(str); 
                    // -1 to make sure that we don't get IndexOutOfBounds error
                    count.add(uniqueFrac.size() - 1, 1); 
                }
                //if the str value does exist already in the uniqueFrac arrayList
                else { 
                    for(int j = 0; j < uniqueFrac.size(); j++) {
                        if(uniqueFrac.get(j).equals(str)) {
                            count.set(j, count.get(j) + 1);
                        }
                    }
                }
            }   
        }
    }
    
    /**
     * This method prints the unique fractions in their simplified
     * form with their corresponding count value. This method access
     * both the uniqueFrac arrayList and count array by using a for loop.
     * We can assume that the size of uniqeFrac and count are the same
     * because there is only one count per fraction, so the boolean
     * condition in the loop can use either the size of uniqueFrac
     * or length of count[]. For each iteration we will pass a fraction
     * and its corresponding count at k index into a frac and counter 
     * variable. Then we will print both out using a print statement in
     * the format: "3/4 has a count of 1".
     */
    public static void printOccurences() {
        for(int k = 0; k < uniqueFrac.size(); k++) {
            String frac = uniqueFrac.get(k);
            int counter = count.get(k);
            System.out.println(frac + " has a count of " + counter);
        }  
    }
}

/**
 * QUESTIONS
 * 1. From what it took to make this program works, I don't think that it
 *    is possible to finish this without using arrays. Because you have 
 *    so many fractions and the fact that you have to check each of them 
 *    shows that you're going to have to use a loop. And if you have to 
 *    use a loop, then most likely you will have to use an array. I think the
 *    least amount of variables is at least 9, because there would be at
 *    least 3 arrays and 3 methods, each will include some form of var for
 *    the numerator and denominator.
 * 
 * 2. I think you definitely can use one array to solve it. The data type
 *    of the array I think would be String, because the input file will be
 *    strings and the output needs to be strings.
 * 
 * 3. I think that means you are making a parent-child class, meaning that
 *    the child class will inherit all the functions that the parent class
 *    have. In other words, Inheritance. Composition is where classes 
 *    have a 'has a' relationship with each other, and are dependent on each 
 *    other. It's done by having the child class put the keyword 'extends'
 *    with the parent class.
 * 
 * 4. You can use the general method, where you put a loop, increment i, and check 
 *    if a value i is divisible by both the numerator and denominator instead of
 *    doing recursion like Euclid's GCD.
 */