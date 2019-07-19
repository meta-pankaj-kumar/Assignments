/*
 * Test class operating under JUnit 4
 * This class tests for negative test cases of Function FixXYCount of ArrOperations.java class based in ArrayOperations Package
 * Methods
 * 		testFixXYnegativeValues - tests for test case which could give out Assertion Error during Execution 
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
* Testing for negative test cases
*/
@RunWith(Parameterized.class)
public class testFixXYNegativeValues{
	private static int expected;
	private static int array[];
	private static int xValue;
	private static int yValue;
	public testFixXYNegativeValues(int expected,int array[],int xValue,int yValue)	{
		testFixXYNegativeValues.expected=expected;
		testFixXYNegativeValues.array=array;
		testFixXYNegativeValues.xValue=xValue;
		testFixXYNegativeValues.yValue=yValue;
	}
	ArrayOperations.ArrOperations arrayOperations;
	@Before
	public void Setup()	{
		arrayOperations=new ArrayOperations.ArrOperations();
	}
	@Parameters
	public static Collection<Object[]> testData() {
		Object[][] data=new Object[][]
				//   expected 		input array						X		Y
				//    Value										  Value	  Value
				{	{	0	,	new int[] {1,4,4}				,	4	,	5	},
					{	0	,	new int[] {1,4,4}				,	4	,	4	},
					{	0	,	new int[] {1,4,9,8,5,4,6,5,8,5}	,	4	,	5	},
					{	0	,	new int[] {1,5,4}				,	4	,	5	}};
		return Arrays.asList(data);
	}
	@Test(expected=AssertionError.class)
	public void tester(){
		int actual[]=arrayOperations.fixXY(array, xValue, yValue);
		assertEquals(expected,actual);
	}
}