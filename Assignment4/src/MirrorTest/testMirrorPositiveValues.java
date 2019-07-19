/*
 * Test class operating under JUnit 4
 * This class tests for positive test cases of Function MirrorCount of ArrOperations.java class based in ArrayOperations Package
 * Methods
 * 		testMirrorpositiveValues - tests for test case which could give out Assertion Error during Execution 
 */ 
package MirrorTest;
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
public class testMirrorPositiveValues {
	private static int expected;
	private static int array[];
	public testMirrorPositiveValues(int expected,int array[])	{
		testMirrorPositiveValues.expected=expected;
		testMirrorPositiveValues.array=array;
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
				{	{	6	,	new int[] {1,1,1,1,1,1}			},
					{	3	,	new int[] {1,2,3,4,5,3,2,1}		},
					{	3	,	new int[] {4,4,4}				},
					{	2	,	new int[] {1,2,4,5,2,1,4}		},
					{	3	,	new int[] {1,2,3,5,4,3,2,1,4,5}	}	};
		return Arrays.asList(data);
	}
	@Test
	public void tester() {
		int actual=arrayOperations.mirrorSection(array);
		assertEquals(expected,actual);
	}
}