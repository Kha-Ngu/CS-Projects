import java.awt.*;
/**
 * NEW SHAPE
 * This class represents a Rectangle
 * @author Khanh Nguyen
 * @version 11/2/23
 */
public class Rectangle extends Shape{
    private int width; //Rectangle width
    private int height; //Rectangle height
    private Color color; //Rectangle color

    public static void main(String[] args) {
        Rectangle a = new Rectangle(10, 11, 12, 13, Color.black);

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
        if(a.getHeight() != 13) {
             System.out.println("getHeight is wrong");
        }
        else {
            System.out.println(".");
        }
        if(a.getWidth() != 12) {
             System.out.println("getWidth is wrong");
        }
        else {
            System.out.println(".");
        }
        if(!a.getColor().equals(Color.BLACK)) {
             System.out.println("getHeight is wrong");
        }
        else {
            System.out.println(".");
        }
        if(a.getArea() != 156) {
             System.out.println("getArea is wrong");
        }
        else {
            System.out.println(".");
        }
        
        
    }
    /**
     * This constructor sets all private instance variables
     * @param x         x-coord of rectangle
     * @param y         y-coord of rectangle
     * @param width     Width of rectangle
     * @param height    Height of rectangle
     * @param color     Color of rectangle
     */
    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y); //Call super constructor
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Returns the x-coordinate
     * @return x-coord
     */
    public int getX() {
        return super.getX(); //call super method
    }

    /**
     * Returnst the y-coordinate
     * @return y-coord
     */
    public int getY() {
        return super.getY(); //call super method
    }

    /**
     * Returns the width of rectangle
     * @return  The width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Sets the width of the rectangle
     * @param width     The new width
     */
    public void setWidth(int width) {
        this.width = width;
    }
     
    /**
     * Returns the height of rectangle
     * @return  The height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Sets the height of the rectangle
     * @param height    The new height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Returns the color of the rectangle
     * @return  The color 
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Sets the color of the rectangle
     * @param color The new color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Returns the area of the rectangle
     * Area: W x H
     * @return The area
     */
    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    /**
     * This method draws a rectangle
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        g2d.drawRect(super.getX(), super.getY(), getWidth(), getHeight()); //Draw rectangle
        g2d.fillRect(super.getX(), super.getY(), getWidth(), getHeight()); //Fill rectangle with current color
    }
}
