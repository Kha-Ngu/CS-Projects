/**
 * This Queue class contains the implementations of a first-in-first-out (FIFO) 
 * queue of objects and all of its methods.
 * 
 * @author Khanh Nguyen
 * @version 10/24/23
 */
public class Queue {
    private int numElements; //The size of the queue
    private static final int DEFAULT_CAPACITY = 1; //Capacity if user doesn't set one
    private int capacity; //Stores the capacity
    private int tailIndex; //Stores the index of the rear element
    private int headIndex = 0; //Front of the queue will always be index 0
    private Object[] queue; //Internal array

    /**
     * Default constructor
     */
    public Queue() {
        this.capacity = DEFAULT_CAPACITY;
        this.headIndex = 0;
        this.tailIndex = 0;
        this.numElements = 0;
        queue = new Object[this.capacity];
    }

    /**
     * Constructor for user to set capacity
     * @param capacity      Capacity of the queue
     */
    public Queue(int capacity) {
        this.capacity = capacity;
        this.numElements = 0;
        this.headIndex = 0;
        this.tailIndex = capacity - 1;
        queue = new Object[this.capacity];
    }

    /**
     * Add object to the end of the queue
     * @param obj       Object to be added
     */
    public void enqueue(Object obj) {
        if(capacity == numElements) {
            increaseSize();
        }
        queue[numElements] = obj;
        numElements++;
        this.tailIndex = numElements - 1; //Sets the tail index
    }

    /**
     * Return and remove object from the front of the queue
     * @return
     */
    public Object dequeue() {
        //Check if queue is empty
        if(isEmpty()) {
            return "Queue is empty";
        }
        Object temp = queue[0]; //Temporarily store the front value
        queue[0] = null; //Deletes the front value

        //Shifts all elems up one index
        for(int i = 0; i < this.numElements - 1; i++) {
            queue[i] = queue[i+1];
        }
        this.headIndex = 0; //Head will always stay 0
        this.numElements--; //Decrease the size
        return temp;
    }

    /**
     * Returns the size of the queue
     * @return      The number of elements
     */
    public int size() {
        return this.numElements;
    }

    /**
     * Get the object at the rear of the queue
     * @return      The tail
     */
    public Object getTail() {
        return this.queue[this.tailIndex];
    }

    /**
     * Get the object at the front of the queue
     * @return      The head
     */
    public Object getHead() {
        return this.queue[this.headIndex];
    }

    /**
     * Prints queue from front to back
     */
    public String toString() {
        String str = "[";
        for(int i = 0; i < numElements; i++) {
            str += queue[i];
            if(i != numElements - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

    /**
     * See if queue is empty
     * @return      True or false
     */
    public boolean isEmpty() {
        return this.numElements == 0;
    }

    /**
     * Compare two queue objects
     */
    public boolean equals(Object obj) {
        Queue obj1 = (Queue) obj; //Cast to queue

        //Check the sizes of both
        if(this.size() != obj1.size()) {
            return false;
        }
        //Check the elements of both
        for(int i = 0; i < this.size(); i++) {
            if(this.get(i) != obj1.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method gets the element in the queue 
     * at a specified index. This is for internal-use
     * only, user will not have access to this method.
     * @param i     The specified index
     * @return      The element at the index
     */
    private Object get(int i) {
        return this.queue[i];
    }

    /**
     * Private method to help increase array size dynamically,
     * not meant for user usage. Increases capacity by 1 
     * each time it is called.
     */
    private void increaseSize() { 
        int newLength = this.capacity + 1; 
        //Create a new object array with new capacity
        Object[] resized = new Object[newLength];
        //Copy all values from current array into new array
        for(int i = 0; i < this.size(); i++) {
            resized[i] = this.queue[i];
        }
        //Set stack to the new array
        this.queue = resized;
        //Set capacity to new capacity
        this.capacity = newLength;
    } 
}
