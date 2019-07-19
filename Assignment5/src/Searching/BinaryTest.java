/*
 * Test class operating under JUnit 4
 * This class tests for positive test cases of Function SplitCount of ArrOperations.java class based in ArrayOperations Package
 */ 
package Searching;
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
public class BinaryTest{
	private static int expected;
	private static int[] array;
	private static int numberToBeSearhed;
	public BinaryTest(int expected,int[] array,int numberToBeSearhed)	{
		BinaryTest.expected=expected;
		BinaryTest.array=array;
		BinaryTest.numberToBeSearhed=numberToBeSearhed;
	}
	Searching.binarySearching search;
	@Before
	public void Setup()	{
		search=new Searching.binarySearching();
	}
	@Parameters
	public static Collection<Object[]> testData(){
		Object[][] data=new Object[][] 

				//   expected 	    		input 	  				no to
				//    Value		  			array	  				be searched
				{	{	 -1		,	new int[]{1,2,3,9,8,7}		,	10		},
					{	 -1		,	new int[]{0,0,0,0,0,0}		,	50		},
					{	 1		,	new int[]{1,2,3,4,5,6}		,	2		},
					{	 -1		,	new int[]{6,5,4,3,2,1}		,	2		}};
		return Arrays.asList(data);
	}
	@Test
	public void tester(){
		int actual=search.getElementIndexByBinarySearch(array, numberToBeSearhed);
		assertEquals(expected,actual);
	}
}