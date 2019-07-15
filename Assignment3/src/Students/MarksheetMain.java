/*
 * Marksheet Main is designed for performing several operations on grades of students
 * Operations that can be performed are
 * 		AVERAGE OF ALL GRADES
 * 		MAXIMUM OF ALL GRADES
 * 		MINIMUM OF ALL GRADES
 * 		PERCENTAGE OF STUDENTS PASSED
 */
package Students;
import java.util.*;
public class MarksheetMain {
	/*
	 * @param null
	 * @return null
	 * Assumption number of students are greater than zero
	 * Assumption grades entered are between 0 and 100 both inclusive
	 */
	public static void main(String args[]) {//throws IOException {
		Scanner in=new Scanner(System.in);
		try	{
		System.out.println("Enter no of students");
		int n=in.nextInt();
		int grades[]=new int[n];
		int userInput;
			for(int i=0;i<n;i++) {
				System.out.println("Enter Grades of Student "+(i+1));
				grades[i]=in.nextInt();
			}
			//loop runs until user terminates
			while(true){
				System.out.println();
				System.out.println("Input 1 for AVERAGE OF ALL GRADES");
				System.out.println("Input 2 for MAXIMUM OF ALL GRADES");
				System.out.println("Input 3 for MINIMUM OF ALL GRADES");
				System.out.println("Input 4 for PERCENTAGE OF STUDENTS PASSED");
				System.out.println("OR Input ANY OTHER KEY TO EXIT");
				userInput=in.nextInt();
				switch(userInput){
					case 1:
						System.out.println(MarksheetMethods.averageCalculator(grades));
						break;
					case 2:
						System.out.println(MarksheetMethods.maximumOfAllGrades(grades));
						break;
					case 3:	
						System.out.println(MarksheetMethods.minimumOfAllGrades(grades));
						break;
					case 4:
						System.out.println(MarksheetMethods.percentageOfStudentsPassed(grades));
						break;
					default:
						System.out.println("Your Input was "+userInput);
						System.out.println("MARKSHEET CALCULATIONS ABORTED!!!");
						System.exit(0);
					}
				}
			}
		//exception handling with proper statements
		catch (Exception exception) {
		System.out.println("Invalid Input");
		System.out.println("MARKSHEET CALCULATIONS ABORTED!!!");
		System.exit(0);
		}
		in.close();
	}
}

