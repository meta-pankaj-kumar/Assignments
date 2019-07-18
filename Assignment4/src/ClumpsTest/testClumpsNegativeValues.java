/*
 * Test class operating under JUnit 4
 * This class tests for negative test cases of Function ClumpsCount of ArrOperations.java class based in ArrayOperations Package
 * Methods
 * 		testClumpsNegativeValues - tests for test case which could give out Assertion Error during Execution 
 */ 
package ClumpsTest;
import org.junit.Test;
import ArrayOperations.ArrOperations;
/*
 * @param Null
 * @return Null
 * Testing for neagtive test cases
 */
	public class testClumpsNegativeValues
	{
		ArrOperations arrOperations=new ArrOperations();
		
		@Test(expected = AssertionError.class)
		public void testB() {
			int input1[]={};
			arrOperations.clumpsCount(input1);
	}
}