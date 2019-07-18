/*
 * Test class operating under JUnit 4
 * This class tests for negative test cases of Function FixXYCount of ArrOperations.java class based in ArrayOperations Package
 * Methods
 * 		testFixXYNegativeValues - tests for test case which could give out Assertion Error during Execution 
 */ 
package FixXYTest;
import org.junit.Test;
/*
 * @param Null
 * @return Null
 * Testing for neagtive test cases
 */
import ArrayOperations.ArrOperations;
public class testFixXYNegativeValuesBlankArray
{
	ArrOperations arrayOperations = new ArrOperations();
	
	@Test(expected = AssertionError.class)
	public void testF() {
		System.out.println("I am in fix xy assertion 1");
		int input1[]={};
		arrayOperations.fixXY(input1, 4, 5);
	}

}