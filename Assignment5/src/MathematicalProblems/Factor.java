/*
 * Class to implement HCF and LCM of two positive numbers
 * Methods are - 
 * 		hcf - returns the hcf of two numbers
 * 		lcm - returns the lcm of two numbers
 * Assumption - Numbers should be positive
 */
package MathematicalProblems;
public class Factor {
	/*
	 * @param - int number first
	 * @param - int number second
	 * @return - int hcf of both numbers
	 * Assumption - numbers must be positive 
	 */
	public int hcf(int numA,int numB)	{
		if(numA==0 ||numB==0)	{
			return 0;
		}
		return hcf1(numA,numB);
	}
	/*
	 * @param - int number first
	 * @param - int number second
	 * @return - int hcf of both numbers
	 * Assumption - numbers must be positive 
	 */
	private int hcf1(int numA,int numB)    {
        //if numbers are not 0 then call recursively
		if((numA!=0)&&(numB!=0))  {  
        	return hcf1(numB,(numA%numB));
		}
        else {
           	if(numA==0){
        		return numB;
           	}
        	else{
        		return numA;
        	}
        }
    }
	/*
	 * @param - int number first
	 * @param - int number second
	 * @return - int lcm of both numbers
	 * Assumption - numbers must be positive 
	 * Exception - throws AssertionError if any number in lcm is 0
	 */
	public int lcm(int firstNumber,int secondNumber)throws AssertionError	{
        //if numbers are not 0 then call recursively
		if((firstNumber==0)||(secondNumber==0)){
			throw new AssertionError();
		}
		return ((firstNumber*secondNumber)/hcf(firstNumber, secondNumber));
	}
}