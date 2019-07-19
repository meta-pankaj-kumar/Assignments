/*
 * Test class operating under JUnit 4
 * This class tests for negative test cases of Function SplitCount of ArrOperations.java class based in ArrayOperations Package
 * Methods
 * 		testSplitNegativeValues - tests for test case which could give out Assertion Error during Execution 
 */ 
package SplitTest;
import org.junit.Test;
import ArrayOperations.ArrOperations;
/*
 * @param Null
 * @return Null
 * Testing for negative test cases
 */
public class testSplitNegativeValues{
	ArrOperations arrOperations=new ArrOperations();
	@Test(expected = AssertionError.class)
	public void testB() {
		int input1[]={};
		arrOperations.splitArray(input1);
	}
}