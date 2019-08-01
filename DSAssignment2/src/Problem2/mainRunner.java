/*
 * Main class implementing Queue
 */
package Problem2;
import java.util.Scanner;
public class mainRunner {
	/*
	 * @param null
	 * @return null
	 */
	public static void main(String[] args) {
		Queue queue=new CircularQueue();
		Scanner in=new Scanner(System.in);
		
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
						if(queue.enQueue(in.nextInt())){
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
						System.out.println("Is Queue Empty = "+queue.isEmpty());
						break;
					case 4:	
						System.out.println("Is Queue Empty = "+queue.isFull());
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