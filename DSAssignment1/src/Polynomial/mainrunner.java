/*
 * Main class for Polynomial Degree
 */
package Polynomial;
import java.util.Scanner;
public class mainrunner {
	/*
	 * @param null
	 * @return null
	 */
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		try{
			System.out.println("Enter 1 for getting degree of polynomial");
			if(in.nextInt()==1){
				System.out.println("Enter Expression in Proper format");
				System.out.println("One Example expression has been displayed to you");
				System.out.println();
				System.out.println("4x3y+3xy-5vgh+4yu-89y-96g2fr");
				System.out.println("OR");
				System.out.println("-4x3y+3xy-5vgh+4yu-89y-96g2fr");
				System.out.println();
				in.nextLine();
				System.out.println("Enter your Expression");
				String poly=in.nextLine();
				Polynomial polynomial=new Polynomial(poly);
				System.out.println("Degree of "+poly+" = "+polynomial.degree());
			}
			else{
				System.out.println("Wrong Choice");
			}
			in.close();
		}
		//exception Handling
		catch(Exception e){
			System.out.println("Wrong Choice !!!!!!");
		}
	}
}