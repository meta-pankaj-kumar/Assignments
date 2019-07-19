/*
 * Test class operating under JUnit 4
 * This class tests for positive test cases of LCM
 * 
 */ 
package MathematicalProblems;
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
public class LCMTest{
	private static int expected;
	private static int numberFirst;
	private static int numberSecond;
	public LCMTest(int expected,int numberFirst,int numberSecond)	{
		LCMTest.expected=expected;
		LCMTest.numberFirst=numberFirst;
		LCMTest.numberSecond=numberSecond;
	}
	MathematicalProblems.Factor factor;
	@Before
	public void Setup()	{
		factor=new MathematicalProblems.Factor();
	}
	@Parameters
	public static Collection<Object[]> testData(){
		Object[][] data=new Object[][] 

				//   expected 	    input 	  input				
				//    Value		   Value1	  Value2				
				{	{	 70		,	14		,	10		},
					{	 70		,	10		,	14		}	};
		return Arrays.asList(data);
	}
	@Test
	public void tester(){
		int actual=factor.lcm(numberFirst, numberSecond);
		assertEquals(expected,actual);
	}
}