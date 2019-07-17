/*
 * Test class operating under JUnit 4
 * This class tests for the certain positive and negative inputs of Method class Question4.java based in ArrayOperations Package
 * Methods
 * 		testMirrorSection - contains all test cases executing without any exception or error 
 * 		testMirrorSectionAssertion - contains test cases executing with exceptions under them 	
 * 		testClumpsCount - contains all test cases executing without any exception or error 
 * 		testClumpsCountAssertion - contains test cases executing with exceptions under them 
 * 		testtestFixXY - contains all test cases executing without any exception or error 
 * 		testtestFixXYAssertion1 - contain test case executing with exceptions under them 	
 *  	testtestFixXYAssertion2 - contain test case executing with exceptions under them 	
 *  	testtestFixXYAssertion3 - contain test case executing with exceptions under them
 *  	testtestFixXYAssertion4 - contain test case executing with exceptions under them 	
 *  	testtestFixXYAssertion5 - contain test case executing with exceptions under them 	 	
 * 		testSplit - contains all test cases executing without any exception or error 
 * 		testSplitAssertion - contains test cases executing with exceptions under them 
 */ 
package ArrayOperationsTest;
import static org.junit.Assert.*;
import org.junit.Test;
public class ArrOperationsTest {
	ArrayOperations.ArrOperations arrayOperations=new ArrayOperations.ArrOperations();
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testMirrorSection()	{
		System.out.println("I am in test mirror");
		int input1[]= {1,1,1,1,1,1};
		assertEquals(6,arrayOperations.mirrorSection(input1));
		int input2[]= {1,2,3,4,5,3,2,1};
		assertEquals(3,arrayOperations.mirrorSection(input2));
		int input3[]= {4,4,4};
		assertEquals(3,arrayOperations.mirrorSection(input3));
		int input4[]= {1,2,4,5,2,1,4};
		assertEquals(2,arrayOperations.mirrorSection(input4));
		int input5[]= {1,2,3,5,4,3,2,1,4,5};
		assertEquals(3,arrayOperations.mirrorSection(input5));			
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for test case executing with exceptions under them
	 */
	@Test(expected = AssertionError.class)
	public void testMirrorSectionAssertion() {
		System.out.println("I am in test mirror Assertion");
		int input1[]={};
		arrayOperations.mirrorSection(input1);
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testClumpsCount() {
		System.out.println("I am in clumps count");
		int input1[]= {1};
		assertEquals(0,arrayOperations.clumpsCount(input1));
		int input2[]= {1,2,3,4,5,3,2,1};
		assertEquals(0,arrayOperations.clumpsCount(input2));
		int input3[]= {4,4,4};
		assertEquals(1,arrayOperations.clumpsCount(input3));
		int input4[]= {9,1,1,1,2,1,4,4};
		assertEquals(2,arrayOperations.clumpsCount(input4));
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for test case executing with exceptions under them
	 */
	@Test(expected = AssertionError.class)
	public void testClumpsCountAssertion() {
		System.out.println("I am in test clumps Assertion");
		int input1[]={};
		arrayOperations.clumpsCount(input1);
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testFixXY() {
		System.out.println("I am in fix xy");
		int input1[]= {1,2,3};
		assertArrayEquals(input1,arrayOperations.fixXY(input1, 4, 5));
		int input2[]= {1,2,4,7,6,5,7,5,3,4,9};
		int input2Output[]= {1,2,4,5,6,7,7,9,3,4,5};
		assertArrayEquals(input2Output,arrayOperations.fixXY(input2, 4, 5));
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for test case executing with exceptions under them
	 */
	@Test(expected = AssertionError.class)
	public void testFixXYAssertion1() {
		System.out.println("I am in fix xy assertion 1");
		int input1[]={};
		arrayOperations.fixXY(input1, 4, 5);
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for test case executing with exceptions under them
	 */
	@Test(expected = AssertionError.class)
	public void testFixXYAssertion2() {
		System.out.println("I am in fix xy assertion 2");
		int input1[]= {1,4,4};
		arrayOperations.fixXY(input1, 4, 5);
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for test case executing with exceptions under them
	 */
	@Test(expected = AssertionError.class)
	public void testFixXYAssertion3() {
		System.out.println("I am in fix xy assertion 3");
		int input1[]= {1,4,4};
		arrayOperations.fixXY(input1, 4, 4);
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for test case executing with exceptions under them
	 */
	@Test(expected = AssertionError.class)
	public void testFixXYAssertion4() {
		System.out.println("I am in fix xy assertion 4");
		int input1[]= {1,4,9,8,5,4,6,5,8,5};
		arrayOperations.fixXY(input1, 4, 5);
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for test case executing with exceptions under them
	 */
	@Test(expected = AssertionError.class)
	public void testFixXYAssertion5() {
		System.out.println("I am in fix xy assertion 5");
		int input1[]= {1,5,4};
		arrayOperations.fixXY(input1, 4, 5);
	}
	
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testSplit() {
		System.out.println("I am in Split");
		int input1[]= {1,2,3};
		assertEquals(2,arrayOperations.splitArray(input1));
		int input2[]= {1,1,1,1,1};
		assertEquals(-1,arrayOperations.splitArray(input2));
		int input3[]= {0,0,0};
		assertEquals(0,arrayOperations.splitArray(input3));
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for test case executing with exceptions under them
	 */
	@Test(expected = AssertionError.class)
	public void testSplitAssertion() {
		System.out.println("I am in split assertion ");
		int input1[]={};
		arrayOperations.splitArray(input1);
	}
}
