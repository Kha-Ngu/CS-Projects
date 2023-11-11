/**
 * This class creates an array of type Object and keep track of
 * difference fractions in the object list. 
 * 
 * @author Khanh Nguyen
 * @version 10/10/23
 */
public class ObjectList {

    private Object[] fracList = new Object[0]; //array of type Object. It can hold both objects and primitive data types
    private int numElements = 0; // count to keep track of how many shapes there are
    
    /**
     * This method adds the object nx to the fracList array
     * and dynamically increase the size.
     * @param n     Object to add to array
     */
    public void add(Object nx) {
        fracList = increaseSize(fracList, numElements + 1);
        fracList[numElements] = nx;
        numElements++;
    }

    /**
     * This method returns the size of the Object array
     * @return      The size
     */
    public int size() {
        return this.numElements;
    }

    //Reference: https://stackoverflow.com/questions/59369156/is-there-any-way-to-extend-a-array-without-copy-or-without-using-arraylist-and-i
    /**
     * This method increases the size of the Object array by
     * what the newLength amount is
     * @param array         The array to increase
     * @param newLength     The new size of the array
     * @return              The updated array
     */
    public Object[] increaseSize(Object[] array, int newLength) {
        if (this.size() >= newLength) {
            return array;
        }
        Object[] newArray = new Object[newLength];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    /**
     * This method returns the object at a specific index
     * @param i     The specified index
     * @return      The object at the index
     */
    public Object get(int i) {
        return fracList[i];
    }

    /**
     * This method prints out all of the values in data array
     * separated by a comma
     * @return      A String
     */
    @Override
     public String toString() {
        String retVal = "";
        for(int i = 0; i < numElements; i++) {
            if (i == numElements - 1) 
                retVal = retVal + fracList[i];
            else
                retVal = retVal + fracList[i] + ", ";
        }
        return retVal;
    }

    //Reference: https://www.geeksforgeeks.org/euclidean-algorithms-basic-and-extended/
    /**
     * This method finds the greatest common divisor between
     * two integers    
     * @param numerator     The numerator
     * @param denominator   The denominator
     * @return              The greatest common divisor
     */
    public static int gcd(int numerator, int denominator) {
        if (denominator == 0) {
            return numerator;
        }
        return gcd(denominator, numerator % denominator);
    }   
}

