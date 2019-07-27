/*
 * Class to implement several properties of Circle
 * Methods - 
 * 		Circle - Parameterized Constructor
 * 		getArea - returns the area of figure
 * 		getOrigin - returns the centre of circle
 * 		getPerimeter - returns the perimeter of Circle
 * 		isPointEnclosed - returns true if given point is enclosed within the circle
 */
package GraphicsLibrary;
import java.util.ArrayList;
public class Circle implements Shapes{
	public Point start;
	public double radius;
	/*
	 * @param Point type starting point
	 * @param double type ArrayList containing values  
	 */
	public Circle(Point start,ArrayList<Double> list){
		this.start=start;
		this.radius=(double)list.get(0);
	}
	/*
	 * @param Null
	 * @return double type area  
	 */
	@Override
	public double getArea() {
		return (float) (Math.PI*radius*radius);
	}
	/*
	 * @param Null
	 * @return double type perimeter  
	 */
	@Override
	public double getPerimeter() {
		return (float)(2*Math.PI*radius);
	}
	/*
	 * @param Null
	 * @return Point type point of origin  
	 */
	@Override
	public Point getOrigin() {
		Point point=new Point(this.start.getxCoordinate(),this.start.getyCoordinate());
		return point;
	}
	/*
	 * @param Null
	 * @return boolean true if point is enclosed
	 * @return boolean false if point is not enclosed  
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		if(Math.sqrt((Math.pow((point.getxCoordinate()-this.start.getxCoordinate()),2))+(Math.pow((point.getyCoordinate()-this.start.getyCoordinate()),2)))<=radius){
			return true;
		}
		return false;
	}
}