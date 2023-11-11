import java.awt.*;

/**
 * FROM LAB
 * This class represents a Circle
 */
public class Circle extends Shape{ 
    private int rad; //Radius
    private Color color; //The circle color

    /**
     * Sets the color and radius
     * @param x         x-coordinate
     * @param y         y-coordinate
     * @param color     the color of the circle
     * @param radius    the radius of the circle
     */
    public Circle(int x, int y, Color color, int radius) {
        // call the super constructor here
        super(x, y);
        // initialize the radius here
        this.color = color;
        this.rad = radius;
    }

    /**
     * Returns the radius
     * @return  The radius
     */
    public int getRadius() {
        return this.rad;
    }

    /**
     * Sets the radius
     * @param rad   The radius
     */
    public void setRadius(int rad) {
        this.rad = rad;
    }

    /**
     * Returns the color
     * @return  The color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Returns the area of the circle
     * Area: πr^2
     * @return The area
     */
    @Override
    public double getArea() {
        return Math.PI * rad * rad;
    }

    /**
     * Draws the circle
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getColor());
        //Draws an oval given the top-left corner, width, and height of the rectangle that bounds this circle. 
        g2d.fillOval(getX() - rad, getY() - rad, 2 * rad, 2 * rad);
    }

    public static void main(String[] args) {
        Circle a = new Circle(10, 11, Color.black, 5);

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
        if(!a.getColor().equals(Color.black)) {
            System.out.println("getColor is wrong");
        }
        else {
            System.out.println(".");
        }
        if(!Double.toString(a.getArea()).contains("78")) {
            System.out.println("getArea is wrong");
        }
        else {
            System.out.println(".");
        }
        
    }
}