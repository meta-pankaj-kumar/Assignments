/*
 * Test class operating under JUnit 4
 * This class tests for positive test cases of Function HCF
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
public class HCFTest{
	private static int expected;
	private static int numberFirst;
	private static int numberSecond;
	public HCFTest(int expected,int numberFirst,int numberSecond)	{
		HCFTest.expected=expected;
		HCFTest.numberFirst=numberFirst;
		HCFTest.numberSecond=numberSecond;
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
				{	{	 2		,	14		,	10		},
					{	 0		,	 0		,	0		},
					{	 2		,	10		,	14		},	
					{	14		,	14		,	14		} 	};
		return Arrays.asList(data);
	}
	@Test
	public void tester(){
		int actual=factor.hcf(numberFirst, numberSecond);
		assertEquals(expected,actual);
	}
}