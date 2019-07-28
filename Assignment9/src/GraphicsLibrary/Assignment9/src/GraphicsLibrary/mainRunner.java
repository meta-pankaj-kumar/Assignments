/*
 * Main Class for checking working of Screen class
 * Methods 
 * 		main - Main Method
 * 		display - displays result
 * 		inputShape - inputs shape
 */
package GraphicsLibrary;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class mainRunner {
	/*
	 * @param Null
	 * @return Null
	 */
	public static void main(String args[])throws Exception{
		Scanner in=new Scanner(System.in);
		Screen screen=new Screen();
		try {
			//runs until user terminates
			while(true) {
				System.out.println("Enter 1 for Adding a shape to screen");
				System.out.println("Enter 2 for Deleting a Shape from Screen's Front");
				System.out.println("Enter 3 for Deleting All Shapes of a particular type from Screen");
				System.out.println("Enter 4 to Delete all Shapes from Screen");
				System.out.println("Enter 5 for displaying shapes on Screen");
				System.out.println("Enter 6 for Sorting Shapes");
				System.out.println("Enter 7 for checking a point encloses how many shapes");
				int userInput=in.nextInt();
				switch(userInput) {
					case 1:
						int choice=inputShape(in);
						String shape="";
						if(choice<1 && choice>4) {
							System.out.println("Invalid Shape Selection");
						}
						else {
							System.out.println("Choice Inputted Succesfully");
							System.out.println("Enter nearest Point of Shape with Origin and in case of Circle enter coordinates of Centre");
							ArrayList<Double> list=new ArrayList<Double>(); 
							System.out.println("Enter X cordinate of Point");
							double x=in.nextDouble();
							System.out.println("Enter y cordinate of Point");
							double y=in.nextDouble();
							Point point=new Point(x,y);
							if(choice==1) {
								shape="Rectangle";
								System.out.println("Enter Length of Rectangle");
								list.add(in.nextDouble());
								System.out.println("Enter Breadth of Rectangle");
								list.add(in.nextDouble());
							}
							else if(choice==2) {
								shape="Square";
								System.out.println("Enter Side of Square");
								list.add(in.nextDouble());
							}
							else if(choice==3) {
								shape="Triangle";
								System.out.println("Enter Base of Triangle");
								list.add(in.nextDouble());
								System.out.println("Enter Perpendicular");
								list.add(in.nextDouble());
							}
							else if(choice==4) {
								shape="Circle";
								System.out.println("Enter radius of Circle");
								list.add(in.nextDouble());
							}
							if(screen.addShape(shape, point, list)) {
								System.out.println("Shape Successfully Added To Screen");
							}
						}
						break;
					case 2:
						System.out.println("Displaying Screen");
						if(display(screen)) {
							System.out.println("Elements will be deleted from Front of Screen First");
							int choiceOfUser=inputShape(in);
							String shapeToBeDeleted="";
							if(true) {
								if(choiceOfUser==1) {
									shapeToBeDeleted="Rectangle";
								}
								else if(choiceOfUser==2) {
									shapeToBeDeleted="Square";
								}
								else if(choiceOfUser==3) {
									shapeToBeDeleted="Triangle";
								}
								else if(choiceOfUser==4) {
									shapeToBeDeleted="Circle";
								}
							}
							if(shapeToBeDeleted==""){
									System.out.println("Shape Not in Library");
							}
							if(screen.deleteShape(shapeToBeDeleted)) {
								System.out.println("Shape Deleted");
							}
							else{
								System.out.println("Shape Not Found on Screen");
							}
						}
						break;
					case 3:
						System.out.println("Displaying Screen");
						if(display(screen)) {
							System.out.println("All Elements of a Particular type will be deleted from Screen");
							int choiceOfUser=inputShape(in);
							String shapeToBeDeleted="";
							if(true) {
								if(choiceOfUser==1) {
									shapeToBeDeleted="Rectangle";
								}
								else if(choiceOfUser==2) {
									shapeToBeDeleted="Square";
								}
								else if(choiceOfUser==3) {
									shapeToBeDeleted="Triangle";
								}
								else if(choiceOfUser==4) {
									shapeToBeDeleted="Circle";
								}
							}
							if(shapeToBeDeleted==""){
									System.out.println("Shape Not in Library");
								}
							if(screen.deleteAllShapesOfParticularType(shapeToBeDeleted)) {
								System.out.println("All Occurences of Shape Deleted");
							}
							else{
								System.out.println("Shape Not Found on Screen");
							}
						}
						break;
					case 4:	
						System.out.println("Are you Sure to delete all shapes if so respond with 1");
						int response=in.nextInt();
						if(response==1){
							screen.deleteAll();
							System.out.println("All Shapes Deleted");
						}
						break;
					case 5:
						display(screen);
						break;
					case 6:
						System.out.println("S.No.\t\tSorting Style");
						System.out.println("1.\t\tArea");
						System.out.println("2.\t\tPerimeter");
						System.out.println("3.\t\tOrigin");
						System.out.println("4.\t\tTimestamp");
						System.out.println("Enter the s.no of of sorting style");
						int style=in.nextInt();
						List<String> sorted;
						if(style==1){
							sorted=screen.sort("Area");
							if(display(sorted)){
								System.out.println();
							}
							else{
								System.out.println("Issue Traced");
							}
						}
						if(style==2){
							sorted=screen.sort("Perimeter");
							if(display(sorted)){
								System.out.println();
							}
							else{
								System.out.println("Issue Traced");
							}
						}
						if(style==3){
							sorted=screen.sort("Origin");
							if(display(sorted)){
								System.out.println();
							}
							else{
								System.out.println("Issue Traced");
							}
						}
						if(style==4){
							sorted=screen.sort("Timestamp");
							if(display(sorted)){
								System.out.println();
							}
							else{
								System.out.println("Issue Traced");
							}
						}
						break;
					case 7:
						System.out.println("Enter coordinates of Point to be checked");
						System.out.println("Enter X Coordinate");
						double xCoordinate=in.nextDouble();
						System.out.println("Enter Y Coordinate");
						double yCoordinate=in.nextDouble();
						Point point=new Point(xCoordinate,yCoordinate);
						if(!display(screen.isEnclosed(point))){
							System.out.println("No Shape Encloses Your Point");
						}
						break;
					default:
						System.out.println("Your Input was "+userInput);
						System.out.println("SCREEN OPERATIONS ABORTED!!!");
						System.exit(0);
				}
			}
		}
		//Exception Handling
		catch(Exception e)	{
			System.out.println("Invalid Input");
			System.out.println("Screen Closed !!!!");
			System.exit(0);
		}
	}
	/*
	 * @param Screen type screen
	 * @return boolean true if screen is displayed
	 * @return boolean false if screen is not displayed 
	 */
	public static boolean display(Screen screen) {
		String screenContents[]=screen.displayScreen();
		if(screenContents.length!=0) {
			System.out.println("Last element of the list will be displayed on front of screen");
			for(int indexFirst=0;indexFirst<screenContents.length;indexFirst++) {
				System.out.println((indexFirst+1)+".\t"+screenContents[indexFirst]);
			}
			return true;
		}
		else {
			System.out.println("Screen Empty");
			return false;
		}
	}
	/*
	 * @param String type List
	 * @return boolean true if screen is displayed
	 * @return boolean false if screen is not displayed 
	 */
	public static boolean display(List<String> sorted) {
		if(sorted.size()!=0) {
			System.out.println("Last element of the list will be displayed on front of screen");
			for(int indexFirst=0;indexFirst<sorted.size();indexFirst++) {
				System.out.println((indexFirst+1)+".\t"+sorted.get(indexFirst));
			}
			return true;
		}
		else {
			System.out.println("Screen Empty");
			return false;
		}
	}
	/*
	 * @param Scanner object
	 * @return int type user input 
	 */
	public static int inputShape(Scanner in) {
		System.out.println("Select Shape from Shapes Given below");
		System.out.println("S.No.\t\tShape");
		System.out.println("1\t\tRectangle");
		System.out.println("2\t\tSquare");
		System.out.println("3\t\tTriangle");
		System.out.println("4\t\tCircle");
		System.out.println("Enter your choice according to serial numbers");
		int choice=in.nextInt();
		return choice;
	}
}