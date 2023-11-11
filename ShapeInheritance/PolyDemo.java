import javax.swing.*;
import java.awt.*;

/**
 * Class PolyDemo (is a JFrame) and PolyDemoPanel (is a JPanel)
 * @author Rob Nash
 */
class PolyDemo extends JFrame {
	
	/**
	 * JFrame to add components to
	 */
	public PolyDemo() {
		getContentPane().add( new PolyDemoPanel() ); //adds JPanel
		//just some windowing stuff that must happen for all Frames
		setSize( 300,300 ); //Sets panel size
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	/**
	 * Main Method
	 * @param args	Strings of arguments
	 */
	public static void main( String args[] ) {
		PolyDemo myApp = new PolyDemo(); //new PolyDemo object
	}
	
	/**
	 * A JPanel class that supports the JFrame class above
	 */
	public class PolyDemoPanel extends JPanel {		
		Shape[] myShapes= new Shape[20]; //Array of shapes
		
		/**
		 * JPanel constructor
		 */
		public PolyDemoPanel() {
			//Populates myShapes with created shapes
			for( int i = 0; i < 20; i++ ) {
				myShapes[i] =  getRandShape(); //<== returns random shape from list
			}
		}
		
		/*********************************************************************************************************************
		 * Code for drawing our shapes doesn't change at all! Since we intended to take advantage of polymorphism, we coded 
		 * this "in general" with respect to the superclass, and not specific to any subclass.
		 *********************************************************************************************************************/
		
		 /**
		 * This method draws a general shape, not specific to any subclass.
		 */
		 public void paint( Graphics g ) {
			super.paint(g);  //don't remove - required for GUI widgets to draw correctly
			/************************
			 * Late Binding Demo
			 ************************/
			//Goes through every shape and draws each one
			for( int i = 0; i < myShapes.length; i++ ){
				//which draw method is invoked here? There are many forms of the method (polymorphic), so which is chosen?
				//Java has RTTI about every object, and it uses this info to choose the correct method to invoke!
				myShapes[i].draw( g ); //The draw method specific to the subclass will be invoked
			}	
		}
			
		/**
		 * Get a random number between 0-200
		 * @return
		 */
		public int getRandInt() {
			return ( (int) ( Math.random() * 200 ) );	
		}
		
		/**
		 * Get a random shape from the provided list of shapes
		 * @return	A shape
		 */
		public Shape getRandShape() {
			Shape retVal = null;
			final int x = getRandInt();
			final int y = getRandInt();
			
			/********************************
			 * Polymorphic extensibility demo
			 *
			 *******************************/
			switch( ( int )(Math.random() * 4) ) {
				case 0: 	retVal = new Circle(150, 350, Color.yellow, 140); //A Circle
							break;
				case 1: 	retVal = new Cube(800, 250, 200, 50, Color.red); //A Cube
							break;
				case 2: 	retVal = new Cylinder(2700, 650, 200, 300, Color.pink); //A Cylinder
							break;
				case 3: 	retVal = new Rectangle(440, 250, 150, 250, Color.cyan); //A Rectangle
							break;				
			}
		
			return retVal;
		}
	}	
}











