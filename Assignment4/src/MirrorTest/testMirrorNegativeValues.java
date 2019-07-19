/*
 * Test class operating under JUnit 4
 * This class tests for negative test cases of Function MirrorCount of ArrOperations.java class based in ArrayOperations Package
 * Methods
 * 		testMirrorNegativeValues - tests for test case which could give out Assertion Error during Execution 
 */ 
package MirrorTest;
import org.junit.Test;
import ArrayOperations.ArrOperations;
/*
 * @param Null
 * @return Null
 * Testing for neagtive test cases
 */
public class testMirrorNegativeValues {
	ArrOperations arrOperations=new ArrOperations();
	@Test(expected = AssertionError.class)
	public void testB() {
		int input1[]={};
		arrOperations.mirrorSection(input1);
	}
}