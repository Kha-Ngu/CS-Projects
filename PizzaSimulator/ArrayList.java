import java.util.Iterator;
import java.awt.Color;
import java.lang.Iterable;

/**
 * This ArrayList class contains the implementations of an ArrayList interface
 * and all of its methods.
 * 
 * @author Khanh Nguyen
 * @version 10/24/23
 * @param <T>
 */
public class ArrayList<T> implements Iterable<Object>{
    private int numElements; //The size of the arraylist
    private static final int DEFAULT_CAPACITY = 1; //Capacity if user doesn't set one
    private int capacity; //Stores the capacity
    private Object[] list; //Internal array

    /**
     * Default constructor
     */
    public ArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.numElements = 0;
        list = new Object[this.capacity];
    }

    /**
     * Constructor to set capacity of list
     * @param capacity  Size of list
     */
    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.numElements = 0;
        list = new Object[this.capacity];
    }

    /**
     * Add the object at the end of the ArrayList-like structure
     * @param obj    Object to add
     * @param black
     * @param blue
     */
    public void add(Object obj) {
        if(capacity == numElements) {
            increaseSize();
        }
        this.list[numElements] = obj;
        this.numElements++;
    }

    /**
     * Add the object at the specified index
     * @param obj       Object to add
     * @param index     The index to add to
     */
    public void insert(Object obj, int index) {
        if(capacity == numElements) {
            increaseSize();
        }
        //if the index is equivalent to the last place 
        //in the array then just call add()
        if(numElements == index) { 
            add(obj);
            return;
        }
        //Shifts all elems up 1 index
        for(int i = numElements; i > index; i--) {
            this.list[i] = list[i-1];
        }

        list[index] = obj;
        numElements++;
    }

    /**
     * Remove and return the object at the specified index
     * @param index     The index of the removed object
     * @return          The value of the removed object
     */
    public Object remove (int index) {
        Object temp = list[index]; //temporarily store the value

        //Check if the object removed is the last in the list,
        //If not, shift all elems after the specified index down 1 index
        if(index != numElements) {
            for(int i = index; i < this.numElements - 1; i++) {
                list[i] = list[i+1];
            }
        }
        this.numElements--;
        return temp;
    }

    /**
     * This is a private class that implements iteration over the elements
     * of the list. It is not accessed directly by the user, but is used in
     * the iterator() method of the Array class. It implements the hasNext()
     * and next() methods.
     */
    private class ArrayIterator implements Iterator<Object> {
            private int currentIndex = 0;

            /**
             * Check if next elem exists
             * @return  True if elem is not null
             */
            @Override
            public boolean hasNext() {
                return currentIndex < size();
            }
            /**
             * Returns the next element in the arraylist
             * @return The next elem
             */
            @Override
            public Object next() {
                return list[currentIndex++];
            }

            /**
             * Used to remove an element
             * @throws UnsupportedOperationException   thrown if not implemented
             */
            public void remove() {
                throw new UnsupportedOperationException();
            }
    }

    /**
     * Return an iterator over the elements in the arraylist.
     * @return  An iterator
     */
    public Iterator<Object> iterator() {
        return new ArrayIterator();
    }

    /**
     * This method returns the size of the Object array
     * @return      The size
     */
    public int size() {
        return this.numElements;
    }

    /**
     * Returns the list in the form of a string.
     * Prints values from first to last index
     * @return   a string representation of the arraylist
     */
    public String toString(){
        String str = "";
        for(int i = 0; i < numElements; i++) {
            if(i == numElements - 1) {
                str += list[i];
            }
            else {
            str += list[i] + "\n";
            }
        }
        str += "";
        return str;
    }

    /**
     * Returns true if the list contains no elements
     * @return  True or false
     */
    public boolean isEmpty() {
        return numElements == 0;
    }

    /**
     * Returns the index of the first occurrence of the specified 
     * element in this list, or -1 if this list does not contain 
     * the element.
     * @param obj   The element to locate
     * @return      The index of the first occurence of the specified element
     */
    public int indexOf(Object obj) {
        //Loop through array until target object is found
        for(int i = 0; i < numElements; i++) {
            if(list[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Compare sizes and elements in the data structure
     * @param obj   The object to compare with
     * @return      True if the sizes and elements of both lists match
     */
    public boolean equals(Object obj) {
        //Check the sizes of both 
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        
        ArrayList<T> temp = (ArrayList<T>) obj;
        //Check size of both
        if(this.size() != temp.size()) {
            return false;
        }
        //Check the elements of both
        for(int i = 0; i < numElements; i++) {
            if(this.get(i) != temp.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Swap two elements in the arraylist using the 
     * specified indices
     * @param idx1  First index to swap
     * @param idx2  Second index to swap
     */
    public void swap(int idx1, int idx2) {
        Object temp = this.get(idx1);
        this.list[idx1] = this.get(idx2);
        this.list[idx2] = temp;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index     The specified index
     * @return      The element at the specified index
     */
    public Object get(int index) {
        return this.list[index];
    }

    /**
     * Replaces the element at the specified position in this list 
     * with the specified element
     * @param i     The specified index
     * @param obj   The element to set
     */
    public void set(int i, Object obj) {
        this.list[i] = obj;
    }

    /**
     * Private method to help increase array size dynamically,
     * not meant for user usage. Increases capacity by 1 each time
     * it is called.
     */
    private void increaseSize() { 
        int newLength = this.capacity + 1; 
        //Create a new object array with new capacity
        Object[] resized = new Object[newLength];
        //Copy all values from current array into new array
        for(int i = 0; i < this.size(); i++) {
            resized[i] = this.list[i];
        }
        //Set stack to the new array
        this.list = resized;
        //Set capacity to new capacity
        this.capacity = newLength;
    } 

    /**
     * Main method for testing
     * @param args  Strings of commands
     */
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<String> b = new ArrayList<String>(10);

        System.out.println("This is ArrayList Test");

        //TEST 1
        a.insert("B", 0);
        a.insert("a",0);
        a.insert("t",1);
        if(!a.get(1).equals("t")) {
             System.out.println("Insert method is wrong!");
        }
        else {
            System.out.println(".");
        }
        while(a.isEmpty() == false) {
            a.remove(0);
        }
        if(!a.isEmpty()) {
            System.out.println("isEmpty method is wrong!");
        }
        else {
            System.out.println(".");
        }

        //TEST 2
        a.add(100);
        a.add("b");
        a.add("String");
        a.add("120.0");
        a.insert("CSS 143", 0);
        b.add("1");
        b.add("2");
        b.add("4");
        if(!b.get(2).equals("4")) {
            System.out.println("Add method is wrong!");
        }
        else {
            System.out.println(".");
        }
        b.add(5);
        b.insert(1,3);
        b.add(7);
        if(!b.remove(4).equals("5") && b.size() != 5) {
             System.out.println("Remove method is wrong!");
        }
        else {
            System.out.println(".");
        }

        b.insert("C", 0);
        b.insert("S", 2);
        b.insert("S", 4);
        if(b.indexOf("S") != 2) {
             System.out.println("IndexOf method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(b.size() != 8) {
             System.out.println("Size method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(a.equals(b)) {
             System.out.println("Equals method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(!b.get(6).equals(1)) {
             System.out.println("Get method is wrong!");
        }
        else {
            System.out.println(".");
        }
        while(b.isEmpty() == false) {
            b.remove(0);
        }
        System.out.println("All tests passed!");
        System.out.println("------------------------------------------");
    }
}