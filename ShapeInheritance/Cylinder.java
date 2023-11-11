import java.awt.*;

/**
 * FROM LAB
 * This class represents a Cylinder shape
 */
public class Cylinder extends Shape{

    public static void main(String[] args) {
        Cylinder a = new Cylinder(10, 11, 10, 10, Color.red);

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
        if(a.getRadius() != 10) {    
            System.out.println("getRadius is wrong");
        }
        else {
            System.out.println(".");
        }
        if(a.getHeight() != 10) {
            System.out.println("getHeight is wrong");
        }
        else {
            System.out.println(".");
        }
        if(!a.getColor().equals(Color.red)) {
            System.out.println("getColor is wrong");
        }
        else {
            System.out.println(".");
        }
        if(!Double.toString(a.getArea()).contains("628")) {
            System.out.println("getArea is wrong");
        }
        else {
            System.out.println(".");
        }
        
    }
    private int radius; //Radius of cylinder
    private int height; //Height of cylinder
    private Color color; //Color of cylinder

    /**
     * Creates a cylinder with a radius, height, and color
     * @param radius    The radius
     * @param height    The height
     * @param color     The color
     */
    public Cylinder(int x, int y, int radius, int height, Color color) {
        super(x, y); //Call super constructor
        this.radius = radius;
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
     * Returns the y-coordinate
     * @return y-coord
     */
    public int getY() {
        return super.getY(); //call super method
    }

    /**
     * Returns the radius of cylinder
     * @return  The radius
     */
    public int getRadius() {
        return this.radius;
    }

    /**
     * Sets the radius of the cylinder
     * @param radius    The new radius
     */
    public void setRadius(int radius){
        this.radius = radius;
    }

    /**
     * Returns the height of the cylinder
     * @return  The height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Sets the height of the cylinder
     * @param height    The new height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Returns the area of the cylinder
     * Area formula: 2πrh
     * @return The area
     */
    @Override
    public double getArea() {
        return 2 * Math.PI * radius * height;
    }

    /**
     * Returns the color of the cylinder
     * @return  The color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Sets the color of the cylinder
     * @param c     The new color
     */
    public void setColor(Color c) {
       this.color = c;
    }

    /**
     * Draw the cylinder
     * Reference: https://stackoverflow.com/questions/71282181/creating-a-2d-cylinder-with-java-graphics
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.translate((super.getX() - radius) / 2, (super.getY() - (height + (radius / 4))) / 2);

        Color newColor = new Color(	238,238,238);
        g2d.setColor(newColor);
        g2d.drawRect(0, 0, radius, height + (radius / 4));

        g2d.setColor(this.color);
        g2d.fillOval(0, height - (radius / 4), radius, radius / 2);

        g2d.setColor(this.color);
        g2d.drawOval(0, 0, radius, radius / 2);

        g2d.setColor(this.color);
        g2d.drawLine(0, radius / 4, 0, height);
        g2d.drawLine(radius, radius / 4, radius, height);
    }

}
