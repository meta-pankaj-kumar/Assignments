/*
 * Test class operating under JUnit 4
 * This class tests for positive test cases of Function SplitCount of ArrOperations.java class based in ArrayOperations Package
 * Methods
 * 		testSplitpositiveValues - tests for test case which could give out Assertion Error during Execution 
 */ 
package SplitTest;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*
* @param Null
* @return Null
* Testing for positive test cases
*/
@RunWith(Parameterized.class)
public class testSplitPositiveValues
{
	private static int expected;
	private static int array[];
	
	public testSplitPositiveValues(int expected,int array[])	{
		testSplitPositiveValues.expected=expected;
		testSplitPositiveValues.array=array;
	}
	ArrayOperations.ArrOperations arrayOperations;
	
	@Before
	public void Setup()	{
		arrayOperations=new ArrayOperations.ArrOperations();
	}
	static int i;
	@Parameters
	public static Collection<Object[]> testData()
	{
		Object[][] data=new Object[][] {{6,new int[] {1,1,1,1,1,1}},{3,new int[] {1,2,3,4,5,3,2,1}},{3,new int[] {4,4,4}},{2,new int[] {1,2,4,5,2,1,4}},{3,new int[] {1,2,3,5,4,3,2,1,4,5}}};
		return Arrays.asList(data);
	}
	@Test
	public void tester()
	{
		int actual=arrayOperations.mirrorSection(array);
		assertEquals(expected,actual);
	}
}