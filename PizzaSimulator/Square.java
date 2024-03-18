import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
                               
/**
 * This class inherits from Shape and represents a Square
 * @author Khanh Nguyen
 * @version 12/7/23
 */
class Square extends Shape implements Cloneable {

    private int sideLength;

    /**
     * Constructor for Square
     * @param a  The x-int
     * @param b  THe y-int
     */
    public Square(int a, int b) {
        super(a, b);   
    }

    /**
     * Constructor for square that sets side length
     * @param a  The x-int
     * @param b  The y-int
     * @param sideLength   The side length
     */
    public Square(int a, int b, int sideLength) {
        super(a, b);
        this.sideLength = sideLength;
    }

    /**
     * Gets the side length
     * @return  An integer
     */
    public int getSideLength() {
        return sideLength;
    }

    /**
     * Sets the side length
     * @param s   Length to set to
     */
    public void setSideLength(int s) {
        this.sideLength = s;
    }

    /**
     * Gets the area
     * @return  A double
     */
    public double getArea() {
        return sideLength * sideLength; 
    }

    /**
     * Clones a Square object
     * @return The cloned object
     * @throws CloneNotSupportedException   thrown if Square not cloneable
     */
    public Object clone() throws CloneNotSupportedException {
        Square s = new Square(getX(), getY(), getSideLength());
        return s;
    }

    /**
     * Draws the square
     * @param g   Graphics object
     */
    public void draw(Graphics g) {
        g.fill3DRect(getX(), getY(), sideLength, sideLength, false);
   }

    /**
     * Main method for testing
     * @param args  String of commands
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Square a = new Square(10, 11, 5);

        if(a.getSideLength() != 5) {
            System.out.println("getSideLength failed");
        }
        else {
            System.out.println(".");
        }
        if(a.getX() != 10) {
            System.out.println("getX is wrong");
        }
        else {
            System.out.println(".");
        }
        if(a.getY() != 11) {
            System.out.println("getY is wrong");
        }
        else {
            System.out.println(".");
        }
        if(a.getArea() != 25) {
            System.out.println("getArea is wrong");
        }
        else {
            System.out.println(".");
        }
        a.setSideLength(10);
        if(a.getSideLength() != 10) {
            System.out.println("setSideLength failed");
        }
        else {
            System.out.println(".");
        }
        Square b = (Square) a.clone();
        if (b.toString().equals(a.toString())) {
            System.out.println("cloning failed");
        }
        else {
            System.out.println(".");
        }
    }
}
