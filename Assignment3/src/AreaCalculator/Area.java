/*
 * Area Calculator of different geometrical figures
 * consists of main method for display of desired calculated output
 * calculations that can be performed are  
 * 		CALCULATING AREA OF TRIANGLE
 * 		CALCULATING AREA OF RECTANGLE
 * 		CALCULATING AREA OF CIRCLE
 * 		CALCULATING AREA OF SQUARE
 */
package AreaCalculator;
import java.util.Scanner;
public class Area {
	/*
	 * @param null
	 * @return null
	 * Assumption width is greater than zero
	 * Assumption height is greater than zero
	 * Assumption radius is greater than zero
	 */
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		int userInput;
		double width,height,radius;
		try	{
			//runs until user terminates the module
			while(true){
				System.out.println();
				System.out.println("Input 1 for AREA OF TRIANGLE");
				System.out.println("Input 2 for AREA OF RECTANGLE");
				System.out.println("Input 3 for AREA OF A SQUARE");
				System.out.println("Input 4 for AREA OF A CIRCLE");
				System.out.println("OR Input ANY OTHER KEY TO EXIT");
				userInput=in.nextInt();
				switch(userInput){
					case 1:
						//First input width, height and then print area with a proper message
						System.out.println("ENTER WIDTH OF TRIANGLE");
						width=in.nextDouble();
						System.out.println("ENTER HEIGHT OF TRIANGLE");
						height=in.nextDouble();
						System.out.println("AREA OF TRIANGLE WITH WIDTH = "+width+" AND HEIGHT = "+height+" IS "+AreaMethods.areaOfTriangle(width,height)+" sq. Units");
						break;
					case 2:
						//First input width, height and then print area with a proper message
						System.out.println("ENTER WIDTH OF RECTANGLE");
						width=in.nextDouble();
						System.out.println("ENTER HEIGHT OF RECTANGLE");
						height=in.nextDouble();
						System.out.println("AREA OF RECTANGLE WITH WIDTH = "+width+" AND HEIGHT = "+height+" IS "+AreaMethods.areaOfRectangle(width,height)+" sq. Units");
						break;
					case 3:	
						//First input width and then print area with a proper message
						System.out.println("ENTER WIDTH OF SQUARE");
						width=in.nextDouble();
						System.out.println("AREA OF SQUARE WITH WIDTH = "+width+" IS "+AreaMethods.areaOfSquare(width)+" sq. Units");
						break;
					case 4:
						//First input radius and then print area with a proper message
						System.out.println("ENTER RADIUS OF CIRCLE");
						radius=in.nextDouble();
						System.out.println("AREA OF CIRCLE WITH RADIUS = "+radius+" IS "+AreaMethods.areaOfCircle(radius)+" sq. Units");
						break;
					default:
						System.out.println("Your Input was "+userInput);
						System.out.println("AREA CALCULATOR ABORTED!!!");
						System.exit(0);
				}
			}
		}
		catch (Exception exception) {
				//exception caught print the message accordingly
			System.out.println("Invalid Input");
			System.out.println("AREA CALCULATOR ABORTED!!!");
			System.exit(0);
		}
		in.close();
	}
}
