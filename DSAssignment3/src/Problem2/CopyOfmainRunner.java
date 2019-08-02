/*
 * Main class for Priority Queue Implementation
 */
package Problem2;
import java.util.Scanner;
public class CopyOfmainRunner {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		System.out.println("Enter size of Queue");
		PriorityQueue queue=new PriorityQueue(in.nextInt());
		//runs until user terminates
		while(true) {
			try {
				System.out.println("Enter 1 for Adding an element to Queue");
				System.out.println("Enter 2 for Deleting an Element from Queue");
				System.out.println("Enter 3 for Checking if Queue is Empty");
				System.out.println("Enter 4 for Checking if Queue is Full");
				int userInput=in.nextInt();
				switch(userInput) {
					case 1:
						System.out.println("Enter an element");
						int element=in.nextInt();
						System.out.println("Enter its Priority");
						int priority=in.nextInt();
						if(queue.enQueue(element,priority)){
							System.out.println("Element Added to Queue");
						}
						break;
					case 2:
						System.out.println("To confirm delete press 1 else press any other numeric key to terminate delete");
						if(in.nextInt()==1){
							System.out.println("Element "+queue.deQueue()+" Deleted");
						}
						break;
					case 3:
						System.out.println("Is Queue Empty = "+queue.isQueueEmpty());
						break;
					case 4:	
						System.out.println("Is Queue Full = "+queue.isQueueFull());
						break;
					default:
						System.out.println("Your Input was "+userInput);
						System.out.println("QUEUE OPERATIONS ABORTED!!!");
						System.exit(0);
				}
			}
			//Exception Handling
			catch(Exception e)	{
				System.out.println(e);
			}	
		}
	}
}