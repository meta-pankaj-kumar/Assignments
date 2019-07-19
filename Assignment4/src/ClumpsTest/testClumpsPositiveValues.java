/*
 * Test class operating under JUnit 4
 * This class tests for positive test cases of Function ClumpsCount of ArrOperations.java class based in ArrayOperations Package
 * Methods
 * 		testClumpspositiveValues - tests for test case which could give out Assertion Error during Execution 
 */ 
package ClumpsTest;
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
public class testClumpsPositiveValues{
	private static int expected;
	private static int array[];
	public testClumpsPositiveValues(int expected,int array[])	{
		testClumpsPositiveValues.expected=expected;
		testClumpsPositiveValues.array=array;
	}
	ArrayOperations.ArrOperations arrayOperations;
	@Before
	public void Setup()	{
		arrayOperations=new ArrayOperations.ArrOperations();
	}
	@Parameters
	public static Collection<Object[]> testData()	{
		Object[][] data=new Object[][]
				//   expected 		   input array						
				//    Value										
				{	{	0	,	new int[] {1}	},
					{	0	,	new int[] {1,2,3,4,5,3,2,1}	},
					{	1	,	new int[] {4,4,4}	},
					{	2	,	new int[] {9,1,1,1,2,1,4,4}	}	};
		return Arrays.asList(data);
	}
	@Test
	public void tester()	{
		int actual=arrayOperations.clumpsCount(array);
		assertEquals(expected,actual);
	}
}