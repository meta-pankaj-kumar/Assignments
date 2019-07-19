/*
 * Test class operating under JUnit 4
 * This class tests for positive test cases of Function FixXYCount of ArrOperations.java class based in ArrayOperations Package
 * Methods
 * 		testFixXYpositiveValues - tests for test case which could give out Assertion Error during Execution 
 */ 
package FixXYTest;
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
public class testFixXYPositiveValues {
	private static int expected[];
	private static int array[];
	private static int xValue;
	private static int yValue;
	public testFixXYPositiveValues(int expected[],int array[],int xValue,int yValue)	{
		testFixXYPositiveValues.expected=expected;
		testFixXYPositiveValues.array=array;
		testFixXYPositiveValues.xValue=xValue;
		testFixXYPositiveValues.yValue=yValue;
	}
	ArrayOperations.ArrOperations arrayOperations;
	@Before
	public void Setup()	{
		arrayOperations=new ArrayOperations.ArrOperations();
	}
	@Parameters
	public static Collection<Object[]> testData(){
		Object[][] data=new Object[][]
				//   		expected 		   						input array							X		Y
				//    		 Value																	  Value	  Value
				{	{	new int[]{1,2,3}					,	new int[] {1,2,3}					,	4	,	5	},
					{	new int[]{1,2,4,5,6,7,7,9,3,4,5}	,	new int[] {1,2,4,7,6,5,7,5,3,4,9}	,	4	,	5	}	};
		return Arrays.asList(data);
	}
	@Test
	public void tester(){
		int actual[]=arrayOperations.fixXY(array, xValue, yValue);
		assertArrayEquals(expected,actual);
	}
}