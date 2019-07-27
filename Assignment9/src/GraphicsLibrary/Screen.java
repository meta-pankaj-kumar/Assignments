/*
 * Screen method for Virtual Implementation of Screen
 * methods-
 * 		addShape - adds shape to screen
 * 		deleteAll - deletes all shape from screen
 * 		deleteAllShapesOfParticularType - deletes shapes of a particular type
 * 		deleteShape - deletes shape from screen
 * 		displayScreen - displays screen
 * 		isEnclosed - checks on whole screen which point are enclosed
 * 		sort - sorts screen according to input type
 */
package GraphicsLibrary;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
public class Screen{
	public List<String> shapeListString=new LinkedList<String>();
	public List<Shapes> shapeList=new LinkedList<Shapes>();
	public List<Double> timeStamp=new LinkedList<Double>();
	public double currentTimeStamp=0;
	FactoryShapes factory;
	/*
	 * @param String type of shape name
	 * @param Point type start
	 * @param ArrayList of Double type consisting of initial Inputs
	 * @return boolean true if shape is added
	 */
	public boolean addShape(String shape,Point start,ArrayList<Double> list) throws Exception{
		factory=new FactoryShapes();
		this.shapeList.add(factory.getShape(shape, start, list));
		this.shapeListString.add(shape);
		this.timeStamp.add(currentTimeStamp++);
		return true;
	}
	/*
	 * @param null
	 * @return String Array of all shapes
	 */
	public String[] displayScreen(){
		String shapeArray[]=new String[shapeListString.size()];
		for(int indexFirst=0;indexFirst<shapeListString.size();indexFirst++) {
			shapeArray[indexFirst]=shapeListString.get(indexFirst);
		}
		return shapeArray;
	}
	/*
	 * @param String type of Shape
	 * @return boolean true if shape is deleted
	 * @return boolean false if shape is not deleted
	 */
	public boolean deleteShape(String shape){
		int indexFirst;
		boolean flag=false;
		for(indexFirst=shapeListString.size()-1;indexFirst>=0;indexFirst--){
			if(shapeListString.get(indexFirst).equals(shape)){
				flag=true;
				break;
			}
		}
		if(flag){
			this.shapeList.remove(indexFirst);
			this.timeStamp.remove(indexFirst);
			this.shapeListString.remove(indexFirst);
			return true;
		}
			return flag;
	}
	/*
	 * @param null
	 * @return boolean true when all are deleted
	 */
	public boolean deleteAll(){
		this.shapeList.removeAll(shapeList);
		this.timeStamp.removeAll(timeStamp);
		this.shapeListString.removeAll(shapeListString);
		return true;
	}
	/*
	 * @param String type of shape
	 * @return boolean true after all shapes of a particular type are deleted
	 */
	public boolean deleteAllShapesOfParticularType(String shape) {
		boolean flagFirst=false;
		boolean flagSecond=false;
		int counter=0;
		while(true){
			flagFirst=deleteShape(shape);
			if(counter==0){
				flagSecond=flagFirst;
				counter++;
			}
			if(!flagFirst){
				break;
			}			
		}
		return flagSecond;
	}
	/*
	 * @param Point type point to be checked
	 * @return List of String type containing all shapes that encloses Point
	 */
	public List<String> isEnclosed(Point point){
		List<String> list=new LinkedList<String>();
		for(int index=0;index<shapeList.size();index++){
			if(shapeList.get(index).isPointEnclosed(point)){
				list.add(shapeListString.get(index));
			}
		}
		return list;
	}
	/*
	 * @param List of shapes names
	 * @param List of Sorted Type
	 * @return List of string type 
	 */
	private List<String> sortByType(List<Double> methodList,List<String> listOfStringShapes){
		for(int indexFirst=0;indexFirst<methodList.size();indexFirst++){
			for(int indexSecond=indexFirst+1;indexSecond<methodList.size();indexSecond++){
				if(methodList.get(indexSecond)<methodList.get(indexFirst)){
					Double temp=methodList.get(indexSecond);
					methodList.set(indexSecond,methodList.get(indexFirst));
					methodList.set(indexFirst, temp);
					String shapeString=listOfStringShapes.get(indexSecond);
					listOfStringShapes.set(indexSecond,listOfStringShapes.get(indexFirst));
					listOfStringShapes.set(indexFirst,shapeString);
				}
			}
		}
		return listOfStringShapes;
	}
	/*
	 * @param String type of Shape
	 * @return List of String
	 */
	public List<String> sort(String type) throws Exception{
		if(type.equalsIgnoreCase("Area")){
			List<Double> area=new ArrayList<Double>();
			for(int indexFirst=0;indexFirst<shapeList.size();indexFirst++){
				area.add(shapeList.get(indexFirst).getArea());
			}
			return sortByType(area,shapeListString);
		}
		if(type.equalsIgnoreCase("Perimeter")){
			List<Double> perimeter=new ArrayList<Double>();
			for(int indexFirst=0;indexFirst<shapeList.size();indexFirst++){
				perimeter.add(shapeList.get(indexFirst).getPerimeter());
			}
			return sortByType(perimeter,shapeListString);
		}
		if(type.equalsIgnoreCase("Origin")){
			List<Double> origin=new ArrayList<Double>();
			for(int indexFirst=0;indexFirst<shapeList.size();indexFirst++){
				origin.add(Math.sqrt(Math.pow((shapeList.get(indexFirst).getOrigin()).getxCoordinate(),2)+Math.pow((shapeList.get(indexFirst).getOrigin()).getyCoordinate(),2)));
			}
			return sortByType(origin,shapeListString);
		}
		if(type.equalsIgnoreCase("Timestamp")){
			return shapeListString;
		}
		throw new Exception("Not a valid Parameter");	
	}
}
