/**
 * This Stack class contains the implementations of a last-in-first-out (LIFO) 
 * stack of objects and all of its methods.
 * 
 * @author Khanh Nguyen
 * @version 10/24/23
 */
public class Stack {
    private int numElements; //The size of the stack
    private int topIndex; //The index of the last added elem
    private static final int DEFAULT_CAPACITY = 1; //Capacity if user does not set one
    private int capacity; //Stores the capacity
    private Object[] stack; //Internal array

    /**
     * Default constructor
     */
    public Stack() {
        this.capacity = DEFAULT_CAPACITY;
        this.numElements = 0;
        this.topIndex = 0;
        stack = new Object[this.capacity];
    }

    /**
     * This constructor allows user to set capacity of stack
     * @param capacity
     */
    public Stack(int capacity) {
        this.capacity = capacity;
        this.numElements = 0;
        this.topIndex = capacity - 1;
        stack = new Object[this.capacity];
    }

    /**
     * Pushes an item onto the top of this stack.
     * @param obj   Item to add
     */
    public void push(Object obj) {
        if (capacity == numElements) {
            increaseSize();
        }
        this.stack[numElements] = obj;
        this.topIndex = numElements;
        this.numElements++;
    }

    /**
     * Removes the object at the top of this stack and returns 
     * that object as the value of this function.
     * @return      The removed object
     */
    public Object pop() {
        if(topIndex == -1) {
            return "Stack is empty";
        }
        Object temp = stack[numElements - 1];
        stack[numElements - 1] = null;
        this.numElements--;
        this.topIndex = numElements - 1;
        return temp;
    }

    /**
     * Looks at the object at the top of this stack without 
     * removing it from the stack.
     * @return      The top element
     */
    public Object peek() {
        if(topIndex == -1) {
            return "Stack is empty";
        }
        return this.stack[numElements - 1];
    }

    /**
     * Returns the size of the stack
     * @return      The number of elements
     */
    public int size() {
        return this.numElements;
    }

    /**
     * Returns the string representation of a stack from the top down
     */
    public String toString() {
        String str = "[";
        //Starts loop from the last index as that is the "top"
        //of the stack
        for(int i = this.numElements - 1; i >= 0; i--) {
            str += stack[i];
            if(i != 0) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }


    /**
     * Sees whether or not the stack is empty
     * @return      True or false
     */
    public boolean isEmpty() {
        return this.numElements == 0;
    }

    /**
     * Same purpose as the peek() method. Meant
     * for testing the peek method.
     * @return      The element at the top of the stack
     */
    public Object getTop() {
        return this.stack[topIndex];
    }

    /**
     * Compares 2 stack objects and see if they're equal
     * in size and elements
     * @return      True or false
     */
    public boolean equals(Object obj) {
        Stack obj1 = (Stack) obj;
        //Check if the sizes are equal
        if(this.size() != obj1.size()) {
            return false;
        }
        //Check if the elements are the same
        for(int i = 0; i < this.size(); i++) {
            if(this.get(i) != obj1.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method gets the element in the stack 
     * at a specified index. This is for internal-use
     * only, user will not have access to this method.
     * @param i     The specified index
     * @return      The element at the index
     */
    private Object get(int i) {
        return this.stack[i];
    }

    /**
     * Private method to help increase array size dynamically,
     * not meant for user usage. It increases the capacity by 1
     * each time it is called.
     */
    private void increaseSize() { 
        int newLength = this.capacity + 1; 
        //Create a new object array with new capacity
        Object[] resized = new Object[newLength];
        //Copy all values from current array into new array
        for(int i = 0; i < this.size(); i++) {
            resized[i] = this.stack[i];
        }
        //Set stack to the new array
        this.stack = resized;
        //Set capacity to new capacity
        this.capacity = newLength;
    } 
}
