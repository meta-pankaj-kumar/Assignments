/*
 * Factory Class for generating Objects of Shapes on Rumtime
 * Methods - 
 * 		getShape - returns object of shape type
 */
package GraphicsLibrary;
import java.util.ArrayList;
public class FactoryShapes{
	/*
	 * @param String type shape of String
	 * @param Point type start point
	 * @param Double type ArrayList of values to be passed
	 * @return Objects of Shapes Class
	 * @exception throws exception if shape not found
	 */
	public Shapes getShape(String shape,Point start,ArrayList<Double> list) throws Exception{
		if(shape.equalsIgnoreCase("Rectangle")){
			return new Rectangle(start,list);
		}
		else if(shape.equalsIgnoreCase("Square")){
				return new Square(start,list);	
		}
		else if(shape.equalsIgnoreCase("Triangle")){
			return new Triangle(start,list);	
		}
		else if(shape.equalsIgnoreCase("Circle")){
			return new Circle(start,list);	
		}
		else {
			throw new Exception("Shape Not Found");
		}
	}
}