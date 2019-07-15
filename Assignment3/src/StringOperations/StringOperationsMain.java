/*
 * StringOperationMain is a class to perform certain String Operations
 * consists of main method for display of desired calculated output
 * operation that can be performed are
 * 		COMPARING TWO STRINGS
 * 		CALCULATING REVERSE OF THE STRING
 * 		CASE REVERSING
 * 		GETTING THE LARGEST WORD OF THE STRING
 */
package StringOperations;
import java.util.*;
public class StringOperationsMain {
	/*
	 * @param null
	 * @return null
	 */
	public static void main(String args[]) {
		int userInput;
		String stringFirst,stringSecond;
		Scanner inputString=new Scanner(System.in);
		Scanner inputInteger=new Scanner(System.in);
		try{
			//loop runs till user terminates the program
			while(true){
			System.out.println();
			System.out.println("Input 1 for COMPARING TWO STRINGS");
			System.out.println("Input 2 for CALCULATING REVERSE OF THE STRING");
			System.out.println("Input 3 for CASE REVERSING");
			System.out.println("Input 4 for GETTING THE LARGEST WORD OF THE STRING");
			System.out.println("OR Input ANY OTHER KEY TO EXIT");
			userInput=inputInteger.nextInt();
			switch(userInput){
				case 1:
					System.out.println("Enter First String");
					stringFirst=inputString.nextLine();
					System.out.println("Enter Second String");
					stringSecond=inputString.nextLine();
					//printing the result obtained after comparing two strings
					System.out.println(StringOperationsModules.compareTwoString(stringFirst, stringSecond));
					break;
				case 2:
					System.out.println("Enter a String");
					stringFirst=inputString.nextLine();
					//printing the result obtained after reversing the string
					System.out.println(StringOperationsModules.reverse(stringFirst));
					break;
				case 3:	
					System.out.println("Enter a String");
					stringFirst=inputString.nextLine();
					//printing the result obtained after reversing the case
					System.out.println(StringOperationsModules.caseReverse(stringFirst));
					break;
				case 4:
					System.out.println("Enter a String");
					stringFirst=inputString.nextLine();
					//printing the last largest word of the string
					System.out.println(StringOperationsModules.largestWord(stringFirst));
					break;
				default:
					System.out.println("Your Input was "+userInput);
					System.out.println("String Operations Terminated!");
					System.exit(0);
				}
			}
		}
		//catching the exception and printing the result accordingly
		catch (Exception exception) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		inputInteger.close();
		inputString.close();
	}
}
