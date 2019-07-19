/*
 * Test class operating under JUnit 4
 * This class tests for test cases of nQueen Problem's Solution based in queen.java in Queen Package
 */ 
package Queen;
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
 public class testqueen{
	 private static boolean expected;
	 private static int array[][];
	 private static int rowValue;
	 private static int dimensionOfMatrix;
	 public testqueen(boolean expected,int array[][],int rowValue,int dimensionOfMatrix)	{
		  testqueen.expected=expected;
          testqueen.array=array;
          testqueen.rowValue=rowValue;
          testqueen.dimensionOfMatrix=dimensionOfMatrix;
	 }
	 Queen.queen queenObject;
	 @Before
	 public void Setup()	{
		 queenObject=new Queen.queen();
	 }
	 @Parameters
	 public static Collection<Object[]> testData(){
		 Object[][] data=new Object[][] 
				 {	{	true	,	new int[][] {	{0,0,0,0},
						 							{0,0,0,0},
						 							{0,0,0,0},
						 							{0,0,0,0}	} , 0 , 4},
						 							
				 	{	false	,	new	int[][]	{	{0,0,0},
				 									{0,0,0},
				 									{0,0,0}		} ,	0 , 3},
				 									
				 	{	true	,	new int[][] {	{0,0,0,0,0,0,0,0},
				 								 	{0,0,0,0,0,0,0,0},
				 								 	{0,0,0,0,0,0,0,0},
				 								 	{0,0,0,0,0,0,0,0},
				 								 	{0,0,0,0,0,0,0,0},
				 								 	{0,0,0,0,0,0,0,0},
				 								 	{0,0,0,0,0,0,0,0},
				 								 	{0,0,0,0,0,0,0,0}	} , 0 , 4}};	
				return Arrays.asList(data);
	 }
	 @Test
	 public void tester(){
		boolean result=queenObject.nQueen(array, rowValue, dimensionOfMatrix);
				assertEquals(expected,result);
	}
}

