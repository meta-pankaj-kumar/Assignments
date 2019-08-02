/*
 * Main runner for bowlers
 */
package Problem3;
import java.util.Scanner;
public class mainRunner {
	/*
	 * @param null
	 * @return null
	 */
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Total Number of Bowlers");
		int numberOfBowlers=in.nextInt();
		BowlerSequencer sequence=new BowlerSequencer(numberOfBowlers);
		try {
			System.out.println("Enter name of Bowler and Balls left to bowl seperated by a Space");
			for(int indexFirst=0;indexFirst<numberOfBowlers;indexFirst++) {
				sequence.addBowler(new Bowler(in.next(),in.nextInt()));
			}
			System.out.println("Enter 1 for getting name of next Bowler to Bowl");
			while(in.nextInt()==1) {
				System.out.println(sequence.getNextBowler());
			}
			in.close();
		}
		//Exception Handling
		catch(Exception e)	{
			System.out.println(e);
		}	
	}
}