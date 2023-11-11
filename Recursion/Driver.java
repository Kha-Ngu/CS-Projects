import java.io.IOException;

/**
 * This is the driver to test the FindFile class
 * @author Khanh Nguyen
 * @version 11/9/23
 */
public class Driver {
    //Main Method
    public static void main(String[] args) {
        FindFile a = new FindFile(30); //Create a file object
        
        try {
            a.directorySearch("PolyDemo.java", "C:/Users/khanh/OneDrive"); //Call search method
            System.out.println("The number of files found: " + a.getCount());
            System.out.println("The paths of all files found:");
            //Print out all the paths
            for(int i = 0; i < a.getFiles().length; i++) {
                if(a.getFiles()[i] == null) {
                    break;
                }
                System.out.println(a.getFiles()[i]);
            }
        }
        catch(IOException e) {
            System.out.println("Something went wrong when trying to read pathname");
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("The maximum number of files to find has been reached.");
            System.out.println("The number of files found: " + a.getCount());
            System.out.println("The paths of all files found:");
            //Print out all of the paths
            for(int i = 0; i < a.getFiles().length; i++) {
                System.out.println(a.getFiles()[i]);
            }
            System.exit(0);
        }
        catch(SecurityException e) {
            System.out.println("File Access Denied");
        }
        catch(IllegalArgumentException e) {
            System.out.println("Not a valid directory. Try another one.");
        }
        
    }
}
