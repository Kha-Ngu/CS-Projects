import java.awt.*;
/**
 * NEW SHAPE
 * This class represents a Cube
 */
public class Cube extends Shape{
    
    public static void main(String[] args) {
        Cube a = new Cube(10, 11, 12, 5, Color.black);

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
        if(a.getSideLength() != 12) {
            System.out.println("getSideLength is wrong");
        }
        else {
            System.out.println(".");
        }
        if(a.getShift() != 5) {
            System.out.println("getShift is wrong");
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
        if(a.getArea() != 144) {
            System.out.println("getArea is wrong");
        }
        else {
            System.out.println(".");
        }
    }
    private int sideLength; //Size of the sides
    private int shift; //Shifts the back square up or down by this amount
    private Color color; //Cube color
    private Point[] squareOne; //The points for the front square
    private Point[] squareTwo; //The points for the back square

    /**
     * This constructor sets all private instance variables
     * @param x             x-coord on panel
     * @param y             y-coord on panel
     * @param sideLength    The side length
     * @param shift         Shifts the back square up or down
     * @param color         Cube color
     */
    public Cube(int x, int y, int sideLength, int shift, Color color) {
        super(x, y); //Call super constructor
        this.sideLength = sideLength;
        this.shift = shift;
        this.color = color;
        squareOne = getSquareOnePoints(); //an array of points
        squareTwo = getSquareTwoPoints(); //an array of points
    }

    /**
     * This method gets the x-coordinate of the cube
     */
    public int getX() {
        return super.getX(); //call super method
    }

    /**
     * This method gets the y-coordinate of the cube
     */
    public int getY() {
        return super.getY(); //call super method
    }

    /**
     * Returns the side length of the cube
     * @return  Cube side length
     */
    public int getSideLength() {
        return this.sideLength;
    }

    /**
     * Returns the shift
     * @return  The shift
     */
    public int getShift() {
        return this.shift;
    }

    /**
     * Returns the color of the cube
     * @return  The color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Sets the color of the cube
     * @param color     The color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Returns the area of a cube
     * Area: sl x sl
     * @return The area
     */
    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    /**
     * Returns array of points containing the x & y coords
     * for all 4 points of the first square
     * @return  Array of points
     */
    public Point[] getSquareOnePoints() {
        Point[] points = new Point[4];
        points[0] = new Point(super.getX(), super.getY());
        points[1] = new Point(super.getX() + sideLength, super.getY());
        points[2] = new Point(super.getX() + sideLength, super.getY() + sideLength);
        points[3] = new Point(super.getX(), super.getY() + sideLength);
        return points;
    }

    /**
     * Returns array of points containing the x & y coords
     * for all 4 points of the second square
     * @return  Array of points
     */
    public Point[] getSquareTwoPoints() {
        Point[] points = new Point[4];
        points[0] = new Point(super.getX() + shift, super.getY() + shift);
        points[1] = new Point(super.getX() + shift + sideLength, super.getY() + shift);
        points[2] = new Point(super.getX() + shift + sideLength, super.getY() + shift + sideLength);
        points[3] = new Point(super.getX() + shift, super.getY() + shift + sideLength);
        return points;
    }

    /**
     * Draw cube
     * Reference: https://stackoverflow.com/questions/22549690/how-to-create-a-cube-in-swing
     */
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.color);
        g2d.drawRect(super.getX(), super.getY(), sideLength, sideLength); //Draw first square
        g2d.drawRect(super.getX() + shift, super.getY() + shift, sideLength, sideLength); //Draw second square
        //Draw connecting lines between the 2 squares
        for (int i = 0; i < 4; i++) {
            g2d.setColor(this.color);
            g2d.drawLine(squareOne[i].x, squareOne[i].y, 
                    squareTwo[i].x, squareTwo[i].y);
        }
    }
}
