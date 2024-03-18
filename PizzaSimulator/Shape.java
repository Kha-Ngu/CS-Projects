import java.awt.*;

/* Class Shape
 *
 * By Rob Nash (with minor edits by Johnny Lin)
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

//the superclass in our inheritance hierarchy
//all "common" features, functions and data should go here
//for example, all shapes in Java2D have a x,y that declares their position
//and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
//note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area (future subclasses must override getArea() to provide something reasonable)
//also, the draw method is empty too, as we don't know what shape to draw here! (again, our subclasses will need to replace this method with one that actually draws things)

abstract class Shape extends Object implements Cloneable{
	private int x = 0;
	private int y = 0;
	
	/**
	 * Constructor for shape
	 * @param a	  x-int
	 * @param b   y-int
	 */
	public Shape( int a, int b ) {
		x=a;
		y=b;
	}
	
	/**
	 * Gets the area of shape
	 * @return	the area
	 */
	public double getArea(){ return -1; }
	/**
	 * Draws shape
	 * @param g	  A graphic object
	 */
	public void draw( Graphics g ){}
	
	/**
	 * Gets x integer
	 * @return	an integer
	 */
	public int getX() { return x; }
	/**
	 * Gets y integer
	 * @return	an integer
	 */
	public int getY() { return y; }
	
	/**
	 * Sets x integer
	 * @param value	number to set to
	 */
	public void setX(int value) { x = value; }
	/**
	 * Sets y integer
	 * @param value  number to set to
	 */
	public void setY(int value) { y = value; }

	/**
	 * Clones a shape
	 * @return  A cloned shape
	 * @throws CloneNotSupportedException  thrown if Shape not cloneable
	 */
	public abstract Object clone() throws CloneNotSupportedException;
}