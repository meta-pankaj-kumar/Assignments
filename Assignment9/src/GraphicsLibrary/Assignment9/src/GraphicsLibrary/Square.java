/*
 * Class to implement several properties of Square
 * Methods - 
 * 		Square - Parameterized Constructor
 * 		getArea - returns the area of figure
 * 		getOrigin - returns the nearest point of Square with origin
 * 		getPerimeter - returns the perimeter of Square
 * 		isPointEnclosed - returns true if given point is enclosed within the Square
 */
package GraphicsLibrary;
import java.util.ArrayList;
public class Square implements Shapes{
	public Point start;
	public double side;
	/*
	 * @param Point type starting point
	 * @param double type ArrayList containing values  
	 */
	public Square(Point point,ArrayList<Double> list){
		this.start=point;
		this.side=(double)list.get(0);
	}
	/*
	 * @param Null
	 * @return double type area  
	 */
	@Override
	public double getArea() {
		return side*side;
	}
	/*
	 * @param Null
	 * @return double type Perimeter  
	 */
	@Override
	public double getPerimeter() {
		return 4*side;
	}
	/*
	 * @param Null
	 * @return Point type point near origin  
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
		if(point.getxCoordinate()>=this.start.getxCoordinate() && ((this.start.getxCoordinate()+side)>=point.getxCoordinate()) && point.getyCoordinate()>=this.start.getyCoordinate() && ((this.start.getyCoordinate()+side)>=point.getyCoordinate()) ){
			return true;
		}
		return false;
	}
}
