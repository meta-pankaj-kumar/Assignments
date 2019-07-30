/*
 * Main class implementing Circular Linked List
 */
package CircularList;
import java.util.Scanner;
public class mainRunner {
	/*
	 * @param null
	 * @return null
	 */
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		Scanner in=new Scanner(System.in);
		try {
			//runs until user terminates
			while(true) {
				System.out.println("Enter 1 for Adding an element to list");
				System.out.println("Enter 2 for Displaying List");
				System.out.println("Enter 3 for Adding an element with its pointing reference");
				System.out.println("Enter 4 to check if circular loop is present or not");
				int userInput=in.nextInt();
				switch(userInput) {
					case 1:
						System.out.println("Warning All Elements should be Unique");
						System.out.println("Enter an element");
						list.insert(in.nextInt());						
						break;
					case 2:
						System.out.println("If you have made a circular list it is suggested to not print it as it is an endless printing ");
						System.out.println("And you have to terminate it manually");
						System.out.println("To confirm show press 1 else press any other numeric key to terminate show");
						if(in.nextInt()==1){
							list.show();
						}
						break;
					case 3:
						System.out.println("Warning All Elements should be Unique");
						System.out.println("Enter data of element");
						int data=in.nextInt();
						System.out.println("Enter its pointing Index");
						int index=in.nextInt();
						if(index<0){
							System.out.println("Index cannot be less than 0");
						}
						else{
							list.insertCircular(data, index);
						}
						break;
					case 4:	
						System.out.println("Presence of circular Loop in inputted list is "+list.isLoopPresent());
						break;
					default:
						System.out.println("Your Input was "+userInput);
						System.out.println("LINKED LIST OPERATIONS ABORTED!!!");
						System.exit(0);
				}
			}
		}
		//Exception Handling
		catch(Exception e)	{
			System.out.println("Invalid Input");
			System.out.println("LINKED LIST OPERATIONS Closed !!!!");
			System.exit(0);
		}
	}
}