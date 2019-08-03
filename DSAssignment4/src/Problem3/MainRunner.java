/**
 * Main Class for calculating Chemical Formula
 */
package Problem3;
import java.util.Scanner;
public class MainRunner {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		try{
		Scanner in = new Scanner (System.in);
		System.out.println("Enter Formula to calculate its Mass");
		System.out.println("Formula can only contain elements of C , H and O ");
		String formula=in.next();
		MassCalculator mass=new MassCalculator();
		System.out.println(mass.calculateMass(formula));
		in.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}