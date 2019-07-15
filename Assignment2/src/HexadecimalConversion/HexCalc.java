/**
 * Code is able to perform several Operations on any of the following Base Values either be binary Octal Decimal or Hexadecimal
 * Arithmetic Operations Allowed are Addition Subtraction Multiplication and Division
 * Logical Operation Allowed are Equality Check Is Greater check and Is Smaller Check
 * Conversions allowed are Any base to decimal and vice versa
 */
package HexadecimalConversion;
import java.util.*;
public class HexCalc{
		
	/* Main Method for Console Implementation
	 * @param null
	 * @returns null
	 */
	public static void main(String args[]){
		int exitHexCalc=0;
		String firstHexNumber,secondHexNumber;
		Scanner in=new Scanner(System.in);
		//Providing User with all Possible options of Operations that can be performed	
		try {
		while(exitHexCalc==0){
			System.out.println();
			System.out.println("By default Base Value = "+HexCalcConstants.BASE);
			System.out.println();
			System.out.println("Input 1 for ADDING TWO NUMBERS");
			System.out.println("Input 2 for SUBSTRACTING TWO NUMBERS");
			System.out.println("Input 3 for DIVIDING TWO NUMBERS");
			System.out.println("Input 4 for MULTIPLYING TWO NUMBERS");
			System.out.println("Input 5 to CHECK EQUALITY OF TWO NUMBERS");
			System.out.println("Input 6 to CHECK IF FIRST NUMBER IS GREATER");
			System.out.println("Input 7 to CHECK IF SECOND NUMBER IS GREATER");
			System.out.println("Input 8 to CONVERT YOUR PREFFERED BASE NUMBER TO DECIMAL NUMBER");
			System.out.println("Input 9 to CONVERT DECIMAL NUMBER TO YOUR PREFFERED BASE NUMBER");
			System.out.println("Input ANY OTHER KEY TO EXIT");
			String userInput=in.nextLine();
			//Checking for the validity of users choice and thus provides the value of exitHexCalc accordingly for further implementation
			if(userInput.length()<1){
				exitHexCalc=1;
				System.out.println("No Input");
			}
			else if(Integer.parseInt(userInput)>9){
					System.out.println("Your Input was "+userInput);
					System.out.println("Calculator Exitted!");
					exitHexCalc=1;
			}
			//Checks for if the users Input is between 1 to 7 because these are the only operations that need two numbers for Calculation
			if((Integer.parseInt(userInput)>=1)&&(Integer.parseInt(userInput)<=7)){
				System.out.println("Enter two numbers of same base");
				firstHexNumber=in.nextLine();
				secondHexNumber=in.nextLine();
				//Converting both the values to uppercase to avoid any conflict during Execution and Validity Checking
				firstHexNumber=firstHexNumber.toUpperCase();
				secondHexNumber=secondHexNumber.toUpperCase();
				//Checking for the validity of the two inputted numbers
				if((HexCalcMethods.validityCheck(firstHexNumber)==1)&&(HexCalcMethods.validityCheck(secondHexNumber)==1)){
					//Removing Extra Zero's from starting of the number
					firstHexNumber=HexCalcMethods.removeInitialZeros(firstHexNumber);
					secondHexNumber=HexCalcMethods.removeInitialZeros(secondHexNumber);
					//Performing operations according to the users input 
					if(Character.getNumericValue(userInput.charAt(0))==1){
						System.out.println(HexCalcMethods.addHexNo(firstHexNumber,secondHexNumber));
					}
					if(Character.getNumericValue(userInput.charAt(0))==2){
						System.out.println(HexCalcMethods.subHexNo(firstHexNumber,secondHexNumber));
					}
					if(Character.getNumericValue(userInput.charAt(0))==3){
						System.out.println(HexCalcMethods.divHexNo(firstHexNumber,secondHexNumber));
					}
					if(Character.getNumericValue(userInput.charAt(0))==4){
						System.out.println(HexCalcMethods.mulHexNo(firstHexNumber,secondHexNumber));
					}
					if(Character.getNumericValue(userInput.charAt(0))==5){
						System.out.println(HexCalcMethods.equalityCheck(firstHexNumber,secondHexNumber));
					}
					if(Character.getNumericValue(userInput.charAt(0))==6){
						System.out.println(HexCalcMethods.isFirstNoGreater(firstHexNumber,secondHexNumber));
					}
					if(Character.getNumericValue(userInput.charAt(0))==7){
						System.out.println(HexCalcMethods.isFirstNoSmaller(firstHexNumber,secondHexNumber));
					}
				}
				else{
					System.out.println("Invalid Input");
				}
			}
			//Checks for if the users Input is 8 or 9 because these are the only operations that need one numbers for Calculation
			if((Integer.parseInt(userInput)==8)||(Integer.parseInt(userInput)==9)){
				System.out.println("Enter a number");
				firstHexNumber=in.nextLine();
				//Converting inputted number to uppercase to avoid any further hassle
				firstHexNumber=firstHexNumber.toUpperCase();
				//Checking for the validity of the input according to its base
				if(HexCalcMethods.validityCheck(firstHexNumber)==1){
					//removing initial zeros from the inputted number
					firstHexNumber=HexCalcMethods.removeInitialZeros(firstHexNumber);
					//Performing operations according to the users input
					if(Character.getNumericValue(userInput.charAt(0))==8){
						System.out.println(HexCalcMethods.toDecimal(firstHexNumber));
					}
					if(Character.getNumericValue(userInput.charAt(0))==9){
						System.out.println(HexCalcMethods.toHex(Integer.valueOf(firstHexNumber)));
					}
				}
			}
		}

		} catch (Exception e) {
			System.out.println("Invalid Input");
			System.out.println("Calculator Exitted!!!");
		}
	}
}
	

