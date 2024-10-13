import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class has a driver that tests if the Fraction,
 * FractionCounter, and ObjectList class work as expected.
 * @author Khanh Nguyen
 * @version 10/17/23
 */
public class Driver {
    private static ObjectList fracList = new ObjectList();
    private static ObjectList fractionAndCounters = new ObjectList();

    /**
     * This main method tests the program
     * @param args  The method calls
     */
    public static void main(String[] args) {

        Scanner scanner = null; //Creates a null scanner
        try {
            scanner = new Scanner(new FileReader("fractions.txt")); //File to scan
        }
        catch (FileNotFoundException e) { //Throws error if the file cannot be found
            System.out.println("The file is corrupted");
            System.exit(0);
        } 

        //Scans the input and tests all boundary cases
        while(scanner.hasNextLine()) {  
            String str = scanner.nextLine();
            String[] frac = str.split("/"); // {num, den}
            try { //This try-catch statment catches any errors that Double.parseDouble() or Integer.parseInt() may throw
                if (str.isEmpty()) { //Check if there is a blank line and skip
                    continue;
                }
                if (frac[1].charAt(0) == '0') { //Check if the denominator is a 0
                    continue;
                }
                if ((Double.parseDouble(frac[0]) / Double.parseDouble(frac[1])) < 0) { //Check for negative fractions
                    continue;
                }
                if (frac[0].charAt(0) == '-' && frac[1].charAt(0) == '-') { //Check for double negatives
                    frac[0] = Integer.toString(Integer.parseInt(frac[0]) * -1); //Turn numerator positive
                    frac[1] = Integer.toString(Integer.parseInt(frac[1]) * -1); //Turn denominator positive
                }
                if (Double.parseDouble(frac[0]) % 1 != 0) { //Check for decimal in numerator
                        String dec = frac[0].substring(frac[0].indexOf(".") + 1); //The length is how many decimal places there are
                        int power = (int) Math.pow(10, dec.length()); //The amount of times to multiply by 10 to get rid of decimal
                        frac[0] = Integer.toString((int)(Double.parseDouble(frac[0]) * power)); //Turns decimal into whole number
                }
                if (Double.parseDouble(frac[1]) % 1 != 0) { //Check for decimal in denominator
                    String dec = frac[1].substring(frac[1].indexOf(".") + 1); //The length is how many decimal places there are
                    int power = (int) Math.pow(10, dec.length()); //The amount of times to multiply by 10 to get rid of decimal.
                    frac[1] = Integer.toString((int)(Double.parseDouble(frac[1]) * power)); //Turns decimal into whole number
                }

                int numerator = Integer.parseInt(frac[0]) / ObjectList.gcd(Integer.parseInt(frac[0]), Integer.parseInt(frac[1])); //reduce the numerator
                int denominator = Integer.parseInt(frac[1]) / ObjectList.gcd(Integer.parseInt(frac[0]), Integer.parseInt(frac[1])); //reduce the denominator
                Fraction fracs = new Fraction(numerator, denominator); //adds reduced num and den to fracList
                fracList.add(fracs); //add fracList to fracs
            }
            catch (Exception e) { //Catches any other error that's not already accounted for
                System.out.println("This file is corrupted");
                System.exit(0);
            }
        }
        scanner.close();        
    
        for(int i = 0; i < fracList.size(); i++) {
            boolean exist = false;
            for(int j = 0; j < fractionAndCounters.size(); j++) {
                //If the fraction already exist then it adds a count and skips it
                //Reference: https://github.com/alex-t-l/CSS-143/blob/main/FractionsV2/FractionsV2.java
                exist = !(!exist && !((FractionCounter)fractionAndCounters.get(j)).compareAndIncrement((Fraction)fracList.get(i)));
            }
            if(!exist) { //If the fraction does not exist in fractionCounters yet then add
                FractionCounter fc = new FractionCounter((Fraction) fracList.get(i));
                fractionAndCounters.add(fc);
            }
        }

        //Prints out all of the unique fractions and their counters
        for(int i = 0; i < fractionAndCounters.size(); i++) {
            System.out.println((fractionAndCounters.get(i).toString()));
        }
    }
}




