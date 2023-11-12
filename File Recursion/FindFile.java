import java.io.File;
import java.io.IOException;

/**
 * This class is used to search a computer's storage for a specific
 * file from a set of files indicated by a starting path.
 * @author Khanh Nguyen
 * @version 11/9/23
 */
public class FindFile {
    private int MAX_NUMBER_OF_FILES_TO_FIND; //Max number of files to find for a single call of the method
    private int count = 0; //Keep track of how many files have been found
    private String[] fileLocations; //store file locations
    
    /**
     * Constructor that sets the max number of files needed to find
     * @param maxFiles
     */
    public FindFile(int maxFiles) {
        this.MAX_NUMBER_OF_FILES_TO_FIND = maxFiles;
        fileLocations = new String[MAX_NUMBER_OF_FILES_TO_FIND];
    }

    /**
     * This method finds a file when given a target and directory
     * @param target    Name of file to find
     * @param dirName   THe name of the directory
     * @throws IndexOutOfBoundsException    Thrown when the max number of files to find is reached   
     * @throws SecurityException    Thrown when we cannot access a file
     * @throws IOException      Thrown when an I/O exception of some sort has occurred
     */
    public void directorySearch(String target, String dirName) throws IndexOutOfBoundsException, SecurityException, IOException {
        File file = new File(dirName); //Create file with directory name

        if(file.isDirectory()) { //Check if file is valid directory
            
            if(file.canRead()) { //Check if we have permission to read file 
                File[] f = file.listFiles(); //Create an array of files
                for(File temp : f) { //Traverse through array
                    
                    if(temp.isDirectory()) { //Check if each file contains its own subdirectory
                        directorySearch(target, temp.getPath()); //Recursive call
                    }
                    else { //If the file doesn't have a subdirectory
                        if(temp.getName().equals(target)) { //Check if the file matches the target
                            if(this.count < MAX_NUMBER_OF_FILES_TO_FIND){ //Check if we already reached the max number of files needed
                                this.fileLocations[count] = temp.getPath(); //Add file location to array
                                this.count++; //increase count of files found
                            }
                            else { //Throw exception because we exceeded the number of files we need to find
                                 throw new IndexOutOfBoundsException();
                            }
                        }
                    }
                }
            }
            else { //Throw exception because we cannot access the file
                throw new SecurityException();
            }
        }
        else { //Throw exception because the directory is not valid
            throw new IllegalArgumentException();
        }
        
    }
    

    /**
     * This method returns the count of matching files found
     * @return  The number of files that has been found
     */
    public int getCount() {
        return this.count;
    }

    /**
     * This method returns a String array of file locations
     * @return  A String array
     */
    public String[] getFiles() {
        return this.fileLocations;
    }
}
