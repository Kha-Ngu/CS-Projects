/**
 * This ArrayList class contains the implementations of an ArrayList interface
 * and all of its methods.
 * 
 * @author Khanh Nguyen
 * @version 10/24/23
 */
public class ArrayList {
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
     * Constructor to set size of list
     * @param capacity     Size of list
     */
    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.numElements = 0;
        list = new Object[this.capacity];
    }

    /**
     * Add the object at the end of the ArrayList-like structure
     * @param nx    Object to add
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
     * This method returns the size of the Object array
     * @return      The size
     */
    public int size() {
        return this.numElements;
    }

    /**
     * Returns the list in the form of a string.
     * Prints values from first to last index
     */
    public String toString() {
        String str = "[";
        for(int i = 0; i < numElements; i++) {
            str += list[i];
            if(i != numElements - 1) {
                str += ", ";
            }
        }
        str += "]";
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
     * @return      True if the sizes and elements of both lists match
     */
    public boolean equals(Object obj) {
        ArrayList obj1 = (ArrayList) obj; //cast to Arraylist
        //Check the sizes of both 
        if(this.size() != obj1.size()) {
            return false;
        }
        //Check the elements of both
        for(int i = 0; i < numElements; i++) {
            if(this.get(i) != obj1.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param i     The specified index
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
}