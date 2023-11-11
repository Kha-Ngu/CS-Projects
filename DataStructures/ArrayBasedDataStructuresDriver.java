/**
 * This driver is for testing the ArrayList, Stack, and Queue classes
 * @author Khanh Nguyen
 * @version 10/24/23
 */
public class ArrayBasedDataStructuresDriver {
    public static void main(String[] args) {
        arrayListTests();
        queueTests();
        stackTests();
    }
    private static void arrayListTests() {
        ArrayList a = new ArrayList();
        ArrayList b = new ArrayList(10);

        System.out.println("This is ArrayList Test");

        //TEST 1
        a.insert('B', 0);
        a.insert('a',0);
        a.insert('t',1);
        if(!a.toString().contains("[a, t, B]")) {
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
        a.add('b');
        a.add("String");
        a.add(120.0);
        a.insert("CSS 143", 0);
        if(!a.toString().contains("[CSS 143, 100, b, String, 120.0]")) {
            System.out.println("toString method is wrong!");
        }
        else {
            System.out.println(".");
        }
        b.add(1);
        b.add(2);
        b.add(4);
        if(b.get(2) != (Object) 4) {
            System.out.println("Add method is wrong!");
        }
        else {
            System.out.println(".");
        }
        b.add(5);
        b.insert(1,3);
        b.add(7);
        if(b.remove(4) != (Object) 5 && b.size() != 5) {
             System.out.println("Remove method is wrong!");
        }
        else {
            System.out.println(".");
        }

        b.insert('C', 0);
        b.insert('S', 2);
        b.insert('S', 4);
        if(b.indexOf('S') != 2) {
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
        if(b.get(6) != (Object) 1) {
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
    private static void queueTests() {
        //todo: make more tests here
        Queue a = new Queue();
        Queue b = new Queue(10);

        System.out.println("This is Queue Test");

        //TEST 1
        a.enqueue('B');
        a.enqueue('a');
        a.enqueue('t');
        if(!a.toString().contains((String)"[B, a, t]")){
             System.out.println("toString method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(a.dequeue() != (Object) 'B') {
            System.out.println("Dequeue method is wrong!");
        }
        else {
            System.out.println(".");
        }
        while(a.isEmpty() == false) {
            a.dequeue();
        }

        //TEST 2
        a.enqueue(1);
        a.enqueue(4);
        a.enqueue(6);
        a.enqueue(7);
        a.enqueue(5);
        if(a.getTail() != (Object) 5) {
            System.out.println("Enqueue method is wrong!");
        }
        else {
            System.out.println(".");
        }
            b.enqueue(1);
            b.enqueue(2);
            b.enqueue(3);
            b.enqueue(4);
            b.enqueue(5);
        if(b.size() != 5) {
            System.out.println("Size method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(a.equals(b)){
            System.out.println("Equals method is wrong!");
        }
        else {
            System.out.println(".");
        }
        b.dequeue();
        b.dequeue();
        if(b.dequeue() != (Object) 3) {
            System.out.println("Dequeue method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(b.size() != 2) {
            System.out.println("Size method is wrong!");
        }
        else {
            System.out.println(".");
        }
        while(!b.isEmpty()) {
            b.dequeue();
        }
        if(!b.isEmpty()) {
            System.out.println("isEmpty method is wrong!");
        }
        else {
            System.out.println(".");
        }

        //TEST 3
        b.enqueue(1);
        b.enqueue(4);
        b.enqueue(6);
        b.enqueue(7);
        b.enqueue(5);;
        if(!a.equals(b)) {
            System.out.println("Equals method is wrong!");
        }
        else {
            System.out.println(".");
        }
        System.out.println("All tests passed!");
        System.out.println("-----------------------------------------");
    }
    private static void stackTests() {
        //todo: make more tests here
        Stack a = new Stack();
        Stack b = new Stack(10);

        System.out.println("This is Stack Test");

        //TEST 1
        a.push('B');
        a.push('a');
        a.push('t');
        if(a.getTop() != (Object) 't') {
             System.out.println("Push method is wrong!");
        }
        else {
            System.out.println(".");
        }
        a.pop();
        if (a.peek() != (Object)'a') {
             System.out.println("Peek method is wrong!");
        }
        else {
            System.out.println(".");
        }
        b.push(1);
        b.push(2);
        b.push(3);
        if(b.pop() != (Object) 3) {
             System.out.println("Pop method is wrong!");
        }
        else {
            System.out.println(".");
        }
        while(!a.isEmpty()) {
             a.pop();
        }
        while(!b.isEmpty()) {
             b.pop();
        }
        if(!b.isEmpty()) {
             System.out.println("isEmpty method is wrong!");
        }
        else {
            System.out.println(".");
        }
        
        //TEST 2
        a.push('H');
        a.push('E');
        a.push('L');
        a.push('L');
        a.push('O');
        if(a.size() != 5) {
             System.out.println("Size method is wrong!");
        }
        else {
            System.out.println(".");
        }
        b.push('A');
        b.push('B');
        b.push('C');
        b.push('D');
        b.push('O');
        if(b.equals(a)) {
             System.out.println("Equals method is wrong!");
        }
        else {
            System.out.println(".");
        }
        if(!b.toString().contains("[O, D, C, B, A]")) {
             System.out.println("toString method is wrong!");
        }
        else {
            System.out.println(".");
        }
        while(a.isEmpty() == false) {
            a.pop();
        }
        while(b.isEmpty() == false) {
            b.pop();
        }

        //TEST 3
        a.push('C');
        a.push('S');
        a.push('S');
        a.push(1);
        a.push(4);
        a.push(3);
        b.push('C');
        b.push('S');
        b.push('S');
        b.push(1);
        b.push(4);
        b.push(3);
        if(!a.equals(b)) {
            System.out.println("Equals method is wrong!");
        }
        else {
            System.out.println(".");
        }
        a.pop();
        if(a.size() == 6) {
            System.out.println("Size method is wrong!");
        }
        else {
            System.out.println(".");
        }
        System.out.println("All tests passed!");
        System.out.println("-----------------------------------------");
    }
}

