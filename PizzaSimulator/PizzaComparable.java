/* 
 * CSS 162, Pizza Manager Project
 * 
 * This interface can do everything the Comparable interface can and more
 * 
 * Author: Rob Nash with minor edits by Johnny Lin
 */
public interface PizzaComparable extends Comparable {  
                                        //Example of interface inheritance
	/**
	 * Compares two Pizza objects by price. Returns 1, 0, or -1
	 * of this Pizza's cost is greater than, equals, or less than the other Pizza's cost
	 * @return   An integer 
	 */
	@Override
	public int compareTo(Object o);          //a.k.a compareToByPrice

	//non-overrides
	/**
	 * Compares two Pizza objects by area remaining. Returns 1, 0, or -1
	 * of this Pizza's remaining area is greater than, equals, or less than the other Pizza's remaining area
	 * @param o	The other pizza
	 * @return	An integer
	 */
	public int compareToBySize(Object o);    //a.k.a. compareToByAreaLeft
	/**
	 * Compares two Pizza objects by calorie count. Returns 1, 0, or -1
	 * of this Pizza's calorie count is greater than, equals, or less than the other Pizza's calories count
	 * @param o	The other pizza
	 * @return	An integer
	 */
	public int compareToByCalories(Object o);	
	
}
