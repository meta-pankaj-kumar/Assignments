/*
 * Class consists of several methods
 * Method Name			Input Parameters		ReturnType
 * removeInitialZeros	(String)				String
 * validityCheck		(String)				Integer
 * toDecimal			(String)				Integer
 * toHex				(integer)				String
 * addHexNo				(String,String)			String
 * subHexNo				(String,String)			String
 * mulHexNo				(String,String)			String
 * divHexNo				(String,String)			String
 * equalityCheck		(String,String)			Boolean
 * isFirstNoGreater		(String,String)			Boolean
 * isFirstNoSmaller		(String,String)			Boolean
 */
package HexadecimalConversion;
public class HexCalcMethods {
	/*
	 * Method to remove initial useless zeros from the paramater
	 * @param Number of any base in String type
	 * @return Number after removing Zeros
	 */
	public static String removeInitialZeros(String number){
		/*	Loop extracts character at all Index numbers of the number and thus checks for the presence of zeros
			if found then trims the string
			leaves the number as it as when there is only one character in it and that too is 0
			Raises the flag when all the zeros are ended to avoid further checking
		*/
		for(int indexNumber=0;indexNumber<number.length();indexNumber++){
			char ch1=number.charAt(indexNumber);
			if((ch1=='0')&&(indexNumber!=(number.length()-1))){
				number=number.substring(indexNumber+1);
			}
			else{
				break;
			}
		}
		return number;
	}
	/*
	 * Method to check Validity of the number according to its base
	 * @param Number of any base in String Type
	 * @return 1 if the Inputed Number is Valid
	 * @return -1 if the number is not valid
	 */
	public static int validityCheck(String Hex){
		//Removing Extra Zero's from starting of the number
		Hex=HexCalcMethods.removeInitialZeros(Hex);
		int charExtractCheckerLoop,lengthOfHexNo=Hex.length();
		//loop to extract every character according to there Index Number and thus checking the validity according to particular base
		for(charExtractCheckerLoop=0;charExtractCheckerLoop<lengthOfHexNo;charExtractCheckerLoop++){
			char extractedCharacter=Hex.charAt(charExtractCheckerLoop);
			if(HexCalcConstants.BASE==HexCalcConstants.HEXADECIMAL_BASE_VALUE){
				if(((extractedCharacter>='0')&&(extractedCharacter<='9'))||((extractedCharacter>='A')&&(extractedCharacter<='F'))){
					continue;
				}
				else{
					return -1;
				}
			}
			if(HexCalcConstants.BASE==HexCalcConstants.OCTAL_BASE_VALUE){
				if((extractedCharacter>='0')&&(extractedCharacter<='7')){
						continue;
				}
				else{
					return -1;
				}
			}
			if(HexCalcConstants.BASE==HexCalcConstants.DECIMAL_BASE_VALUE){
				if((extractedCharacter>='0')&&(extractedCharacter<='9')){
						continue;
				}
				else{
					return -1;
				}
			}
			if(HexCalcConstants.BASE==HexCalcConstants.DECIMAL_BASE_VALUE){
				if((extractedCharacter>='0')&&(extractedCharacter<='1')){
					continue;
				}
				else{
					return -1;
				}
			}
		}
		return 1;
	}
		
	/*
	 * Method to Convert Any base number to Decimal No.
	 * @param Number of any base in String Type
	 * @return decimal number in Integer format  
	 */
	public static int toDecimal(String Hex){
		//Removing Extra Zero's from starting of the number
		Hex=HexCalcMethods.removeInitialZeros(Hex);
		int revCharExtractLoop,decimalNo=0,power=0;
		int length=Hex.length();
		length--;
		//reverse loop to extract number(String format) from back and 
		//thus convert it to decimal by Math.pow(base,Power) where power starts from 0 and increases continuously
		for(revCharExtractLoop=length;revCharExtractLoop>=0;revCharExtractLoop--){
			char extractedCharacter=Hex.charAt(revCharExtractLoop);
			if((Character.getNumericValue(extractedCharacter)>=0)&&(Character.getNumericValue(extractedCharacter)<=HexCalcConstants.BASE-1)){
				decimalNo+=(Character.getNumericValue(extractedCharacter)*Math.pow(HexCalcConstants.BASE,power));
				power++;
			}
		}
		return decimalNo;
	}
	
	/*
	 * Method to Convert Decimal No. to any base number
	 * @param decimal number in Integer format 
	 * @return Number of desired base in String Type  
	 */
	public static String toHex(int decimalNumber){
		String hex=Integer.toString(decimalNumber);
		//Removing Extra Zero's from starting of the number
		hex=HexCalcMethods.removeInitialZeros(hex);
		//then first converting the number 
		decimalNumber=Integer.parseInt(hex);
		String hexaNo="";
		int remValueAboveDecimalNo=10;
		int diffOfValueOfAAndDecimalNo=55;
		//Check if the decimal Number is 0 then return 0
		if(decimalNumber==0){
			return "0";
		}
		//loop runs till the number cut shorts to 0
		//calculate remainder and then add remainder to the reverse string to get valid output
		while(decimalNumber!=0){
			int remainder=decimalNumber%HexCalcConstants.BASE;
			if(remainder>=remValueAboveDecimalNo){
				hexaNo=((char)(remainder+diffOfValueOfAAndDecimalNo))+hexaNo;
			}
			else{
				hexaNo=Integer.toString(remainder)+hexaNo;
			}
			decimalNumber/=HexCalcConstants.BASE;
		}			
		return hexaNo;
	}
	
	/*
	 * Method to Add two numbers of same base
	 * @param Two same base numbers in String type
	 * @return Summation of Inputted Number in String Format
	 */
	public static String addHexNo(String firstHexNo, String secondHexNo){
		//calculate sum by first converting both the numbers to decimal numbers and thus reconverting back it to the base as it was.
		return toHex(toDecimal(firstHexNo)+toDecimal(secondHexNo));
	}
	/*
	 * Method to Subtract two numbers of same base
	 * @param Two same base numbers in String type
	 * @return Subtraction of Inputted Number in String Format i.e. (Number 1-Number 2)
	 * Assumption First Number is greater than second number  
	 */
	public static String subHexNo(String firstHexNo, String secondHexNo){
		//calculate difference by first converting both the numbers to decimal numbers and then reconverting back it to the base as it was.
		//and printing Error Message if First Number is Smaller than Second Number and both the numbers are not equal
		//for checking if the first number is smaller, method isFirstNoSmaller is used 
		if((isFirstNoSmaller(firstHexNo, secondHexNo)==true)&&(equalityCheck(firstHexNo, secondHexNo)==false)){
			return "Substraction of Bigger Number from Smaller Number will result in a negative answer so Operation is Aborted";
		}
		else{
			return toHex(toDecimal(firstHexNo)-toDecimal(secondHexNo));
		}
	}
	
	/*
	 * Method to Multiply two numbers of same base
	 * @param Two same base numbers in String type
	 * @return Multiplication of Inputted Number in String Format i.e. (Number 1*Number 2)
	 */	
	public static String mulHexNo(String firstHexNo, String secondHexNo){
		//calculate Multiplication result by first converting both the numbers to decimal numbers and thus reconverting back it to the base as it was.
		return toHex(toDecimal(firstHexNo)*toDecimal(secondHexNo));
	}
	/*
	 * Method to Divide two numbers of same base
	 * @param Two same base numbers in String type
	 * @return Division of Inputted Number in String Format i.e. (Number 1-Number 2)
	 * Assumption Second Number is not 0
	 * Assumption Division is performed completely no remainder is left back  
	 */
	public static String divHexNo(String firstHexNo, String secondHexNo){
		//Handle Division By Zero by checking and then printing required Message
		if(toDecimal(secondHexNo)==0){
			return "Division by Zero is not Allowed";
		}
		else{
			return toHex(toDecimal(firstHexNo)/toDecimal(secondHexNo));
		}
	}
	/*
	 * Method for Equality Check of two numbers of same base
	 * @param Two same base numbers in String type
	 * @return true if length is equal otherwise false 
	 * Assumption Second Number is not 0
	 * Assumption Division is performed completely no remainder is left back  
	 */
	public static boolean equalityCheck(String firstHexNo, String secondHexNo){
		//if length of both the numbers are equal then extract every character of both numbers 
		//check for equality and return false as soon as any of the number mismatches
		//and if it completely matches then return true
		if(firstHexNo.length()==secondHexNo.length()){
			for(int charExtractLoop=0;charExtractLoop<firstHexNo.length();charExtractLoop++){
				char firstNoExtraxtedCharacter=firstHexNo.charAt(charExtractLoop);
				char secondNoExtraxtedCharacter=secondHexNo.charAt(charExtractLoop);	
				if(firstNoExtraxtedCharacter!=secondNoExtraxtedCharacter){
					return false;
				}
			}
			return true;
		}
		else{
			return false;
		}
	}
	/*
	 * Method for Checking that if first inputed number is greater than second or not 
	 * @param Two same base numbers in String type
	 * @return true if first number is greater and false if second number is greater
	 */
	public static boolean isFirstNoGreater(String firstHexNo, String secondHexNo){
		//if length of first number is greater then return true
		if(firstHexNo.length()>secondHexNo.length()){
			return true;
		}
		//if length of first number is smaller then return false
		else if(firstHexNo.length()<secondHexNo.length()){
			return false;
		}
		//if both lengths are equal then extract every character of both numbers and proceed to check until you get any value of first number smaller
		//as soon as you get it return false else after completion of condition and loop return true as first number is greater
		else{
			for(int i=0;i<firstHexNo.length();i++){
				char ch1=firstHexNo.charAt(i);
				char ch2=secondHexNo.charAt(i);	
				if(Character.getNumericValue(ch1)<Character.getNumericValue(ch2)){
					return false;
				}
				else if(Character.getNumericValue(ch1)>Character.getNumericValue(ch2)){
					return true;
				}
			}
			return false;
		}
	}
	/*
	 * Method for Checking that if first inputed number is smaller than second or not 
	 * @param Two same base numbers in String type
	 * @return true if first number is smaller and false if second number is smaller
	 */
	public static boolean isFirstNoSmaller(String firstHexNo, String secondHexNo){
		//send both of the numbers to a previously made method IsFirstNoGreater
		//it will return true if first number is greater then correspondingly return false
		//it will return false if first number is greater then correspondingly return true
		if(isFirstNoGreater(firstHexNo, secondHexNo)==true){
			return false;
		}
		else{
			return true;
		}
	}	

}
