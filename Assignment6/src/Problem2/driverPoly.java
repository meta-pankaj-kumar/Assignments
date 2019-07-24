/*
 * Main Class for checking working of Poly class
 * Methods 
 * 		main - Main Method
 * 		polynomialInput - For inputting Polynomial Array
 */
package Problem2;
import java.util.Scanner;
public class driverPoly{
	
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		try {
			//runs until user exits
			while(true) {
				System.out.println("Enter 1 for Evaluating Value of Polynomial");
				System.out.println("Enter 2 for Degree of Polynomial");
				System.out.println("Enter 3 for Adding up two Polynomials");
				System.out.println("Enter 4 for Multiplying two Polynomials");
				int userInput=in.nextInt();
				//switch according to users choice
				switch(userInput) {
					case 1:
						int polynomial[]=driverPoly.polynomialInput(in);
						Poly poly=new Poly(polynomial);
						System.out.println("Your Input is---------");
						display(polynomial);
						System.out.println("Enter value for which you want to calculate polynomial");
						float number=in.nextFloat();
						System.out.println("Value obtained after solving is = "+poly.evaluate(number));
						break;
					case 2:
						int polynomialDegree[]=driverPoly.polynomialInput(in);
						Poly polyDegree=new Poly(polynomialDegree);
						System.out.println("Your Input is---------");
						display(polynomialDegree);
						System.out.println("Degree of Polynomial is = "+polyDegree.degree());
						break;
					case 3:	
						//Inputting First Poly
						System.out.println("Input Contents of First Polynomial");
						int polynomialFirstAdd[]=driverPoly.polynomialInput(in);
						Poly polyFirstAdd=new Poly(polynomialFirstAdd);
						//Inputting Second Poly
						System.out.println("Input Contents of Second Polynomial");
						int polynomialSecondAdd[]=driverPoly.polynomialInput(in);
						Poly polySecondAdd=new Poly(polynomialSecondAdd);
						Poly resultAdd=polyFirstAdd.addPoly(polyFirstAdd, polySecondAdd);
						System.out.println("Your First Input is---------");
						display(polynomialFirstAdd);
						System.out.println("Your Second Input is---------");
						display(polynomialSecondAdd);
						System.out.println("Result after addition is --- ");
						display(resultAdd.getPolynomial());
						break;
					case 4:
						//Inputting First Poly
						System.out.println("Input Contents of First Polynomial");
						int polynomialFirstMul[]=driverPoly.polynomialInput(in);
						Poly polyFirstMul=new Poly(polynomialFirstMul);
						//Inputting Second Poly
						System.out.println("Input Contents of Second Polynomial");
						int polynomialSecondMul[]=driverPoly.polynomialInput(in);
						Poly polySecondMul=new Poly(polynomialSecondMul);
						Poly resultMul=polyFirstMul.multiplyPoly(polyFirstMul, polySecondMul);
						System.out.println("Your First Input is---------");
						display(polynomialFirstMul);
						System.out.println("Your Second Input is---------");
						display(polynomialSecondMul);
						System.out.println("Result after addition is --- ");
						display(resultMul.getPolynomial());
						break;
					default:
						System.out.println("Your Input was "+userInput);
						System.out.println("POLYNIOMIAL OPERATIONS ABORTED!!!");
						System.exit(0);
					}
				}
			}
			catch(Exception e)	{
				System.out.println("Invalid Input");
				System.out.println("POLYNIOMIAL OPERATIONS ABORTED!!!");
				System.exit(0);
			}
		}
		/*
		 * @param Null
		 * @return int array after inputting set from user
		 */
		public static int[] polynomialInput(Scanner in){
			System.out.println("Enter number of Coefficients Equation Contain");
			int polynomialSize[]=new int[in.nextInt()];
			System.out.println("Remember First Coefficient will be of Constant then second will be of X then of X^2 and so on");
			System.out.println("For any missing Value in the scenario of polynomial input its coefff as 0");
			for(int indexValue=0;indexValue<polynomialSize.length;indexValue++) {
				System.out.println("Enter Value of "+(indexValue+1)+" Coefficient");
				polynomialSize[indexValue]=in.nextInt();
			}
			
			return polynomialSize;
		}
		public static void display(int[] polynomial) {
			for(int indexFirst=polynomial.length-1;indexFirst>=0;indexFirst--) {
				if(indexFirst !=0) {
					System.out.print(polynomial[indexFirst]+"X^"+indexFirst);
					if(polynomial[indexFirst-1]>=0) {
						System.out.print(" + ");
					}
					else {
						System.out.print(" ");
					}
				}
				else
					System.out.print(polynomial[indexFirst]);
			}
			System.out.println();
		}
}