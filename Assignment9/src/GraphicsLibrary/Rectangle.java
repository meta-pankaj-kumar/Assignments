/*
 * Rectangle to implement several properties of Rectangle
 * Methods - 
 * 		Rectangle - Parameterized Constructor
 * 		getArea - returns the area of figure
 * 		getOrigin - returns the centre of Rectangle
 * 		getPerimeter - returns the perimeter of Rectangle
 * 		isPointEnclosed - returns true if given point is enclosed within the Rectangle
 */
package GraphicsLibrary;
import java.util.ArrayList;
public class Rectangle implements Shapes{
	public double length;
	public double breadth;
	public Point start;
	/*
	 * @param Point type starting point
	 * @param double type ArrayList containing values  
	 * @return double type area
	 */
	public Rectangle (Point point,ArrayList<Double> list){
		this.start=point;
		this.length=(double)list.get(0);
		this.breadth=(double)list.get(1);
	}
	/*
	 * @param null
	 * @return double type area
	 */
	@Override
	public double getArea() {
		return length*breadth;
	}
	/*
	 * @param null
	 * @return double type Perimeter
	 */
	@Override
	public double getPerimeter() {
		return 2*(length+breadth);
	}
	/*
	 * @param Point type point 
	 * @return boolean true if point is enclosed in figure
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		if(point.getxCoordinate()>=this.start.getxCoordinate() && (this.start.getxCoordinate()+length)>=point.getyCoordinate() && point.getyCoordinate()>=this.start.getyCoordinate() && (this.start.getyCoordinate()+breadth)>=point.getyCoordinate()){
			return true;
		}
		return false;
	}
	/*
	 * @param null
	 * @return origin of figure
	 */
	@Override
	public Point getOrigin() {
		Point point=new Point(this.start.getxCoordinate(),this.start.getyCoordinate());
		return point;
	}
}