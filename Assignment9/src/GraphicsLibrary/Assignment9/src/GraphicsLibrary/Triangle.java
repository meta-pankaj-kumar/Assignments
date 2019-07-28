/*
 * Class to implement several properties of Triangle
 * Methods - 
 * 		Triangle - Parameterized Constructor
 * 		getArea - returns the area of figure
 * 		getOrigin - returns the nearest point of Triangle with origin
 * 		getPerimeter - returns the perimeter of Triangle
 * 		isPointEnclosed - returns true if given point is enclosed within the Triangle
 */
package GraphicsLibrary;
import java.util.ArrayList;
public class Triangle implements Shapes{
	public double base;
	public double perpendicular;	
	public double hypotnuse;
	public Point P1;
	public Point P2;
	public Point P3;
	/*
	 * @param Point type starting point
	 * @param double type ArrayList containing values  
	 */
	public Triangle(Point start,ArrayList<Double> list){
		this.P1=start;
		this.base=(double)list.get(0);
		this.perpendicular=(double)list.get(1);
		this.hypotnuse=Math.sqrt(perpendicular*perpendicular+base*base);
		initialisePoints();
	}
	/*
	 * @param Null
	 * @return Null  
	 */
	private void initialisePoints() {
		Point pointSecond = new Point(this.P1.getxCoordinate(),this.P1.getyCoordinate()+perpendicular);
		P2=pointSecond;
		Point pointThird = new Point(this.P1.getxCoordinate()+base,this.P1.getyCoordinate());
		P2=pointThird;
	}
	/*
	 * @param Point type point1
	 * @param Point type point2
	 * @param Point type point3
	 * @return double type area  
	 */
	private double calculateArea(Point P1,Point P2,Point P3){
		double area=P1.getxCoordinate()*(P2.getyCoordinate()-P3.getyCoordinate())+P2.getxCoordinate()*(P1.getyCoordinate()-P3.getyCoordinate())+P3.getxCoordinate()*(P2.getyCoordinate()-P1.getyCoordinate());
		area=area/2;
		if(area<0){
			area*=-1;
		}
		return area;
	}
	/*
	 * @param Null
	 * @return double type area  
	 */
	@Override
	public double getArea() {
		return base*perpendicular/2;
	}
	/*
	 * @param Null
	 * @return double type Perimeter  
	 */
	@Override
	public double getPerimeter() {
		return (base+hypotnuse+perpendicular);
	}
	/*
	 * @param Null
	 * @return boolean true if point is enclosed
	 * @return boolean false if point is not enclosed  
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		if((calculateArea(point, this.P1 , this.P2)+calculateArea(point, this.P1 , this.P3)+calculateArea(point, this.P3 , this.P2))==calculateArea(this.P1, this.P2,this.P3)){
			return true;
		}
		return false;
	}
	/*
	 * @param Null
	 * @return double type nearest point to Origin  
	 */
	@Override
	public Point getOrigin() {
		return this.P1;
	}
}