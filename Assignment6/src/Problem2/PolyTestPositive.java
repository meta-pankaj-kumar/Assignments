/*
 * Test class operating under JUnit 4
 * This class tests for Positive test cases of Poly based in Poly.java in Problem2 Package
 */ 
package Problem2;
import static org.junit.Assert.*;
import org.junit.Test;
public class PolyTestPositive {	
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testGetPolynomial(){
	  try{
		//test case 1
		int array[]=new int[]{1,2,3,4,5};
		Poly pol=new Poly(array);
		int expected[]=new int[]{1,2,3,4,5};
		int actual[]=pol.getPolynomial();
		assertArrayEquals(expected,actual);
	    }
	  catch(Exception e){	  
	  }
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testEvaluate() {
	 try{
		 //test case 1
		int a[]=new int[]{1,2,3,4,5};
		Poly object1=new Poly(a);
		float number=5;
		float result=object1.evaluate(number);
		assertEquals(3711,result,0);
		//test case 2
		number=0;
		result=object1.evaluate(number);
		assertEquals(1,result,0);
	 }
	 catch(Exception e){
	 }
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testDegree() {
	 try{	
		//test case 1
		int a[]=new int[]{1,2,3,4,5};
		Poly object1=new Poly(a);
		assertEquals(4,object1.degree());
		//test case 2
		int c[]=new int[]{0};
		Poly object3=new Poly(c);
		assertEquals(0,object3.degree());
	 }
	 catch(Exception e){
	  }
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testAddPoly() {
	  try{
		//test case 1
		int arrayFirst[]=new int[]{1,2,3,4,5};
		int arraySecond[]=new int[]{1,3,5,7,9,11,13,15};
		Poly objectFirst=new Poly(arrayFirst);
		Poly objectSecond=new Poly(arraySecond);
		int actual[]=(objectFirst.addPoly(objectFirst, objectSecond)).getPolynomial();
		int expected[]=new int[]{2,5,8,11,14,11,13,15};
		assertArrayEquals(expected,actual);
		//test case 2
		int arrayThird[]=new int[]{1,3,5,7,9,11,13,15};
		int arrayFourth[]=new int[]{1,2,3,4,5};
		Poly objectThird=new Poly(arrayThird);
		Poly objectFourth=new Poly(arrayFourth);
		int actualSecond[]=(objectThird.addPoly(objectThird, objectFourth)).getPolynomial();
		int expectedSecond[]=new int[]{2,5,8,11,14,11,13,15};
		assertArrayEquals(expectedSecond,actualSecond);
	  }
	  catch(Exception e){
	  }
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testMultiplyPoly() {
	  try{
		//test case 1
		int arrayFirst[]=new int[]{1,2,3,4,5};
		int arraySecond[]=new int[]{1,3,5,7,9,11,13,15};
		Poly objectFirst=new Poly(arrayFirst);
		Poly objectSecond=new Poly(arraySecond);
		int actual[]=(objectFirst.multiplyPoly(objectFirst, objectSecond)).getPolynomial();
		int expected[]=new int[]{1 , 5 , 14 , 30 , 55 , 85 , 115 , 145 , 158 , 152 , 125 , 75};
		assertArrayEquals(expected,actual);
		//test case 2
		int arrayThird[]=new int[]{1,3,5,7,9,11,13,15};
		int arrayFourth[]=new int[]{1,2,3,4,5};
		Poly objectThird=new Poly(arrayThird);
		Poly objectFourth=new Poly(arrayFourth);
		int actualSecond[]=(objectThird.multiplyPoly(objectThird, objectFourth)).getPolynomial();
		int expectedSecond[]=new int[]{1 , 5 , 14 , 30 , 55 , 85 , 115 , 145 , 158 , 152 , 125 , 75};
		assertArrayEquals(expectedSecond,actualSecond);
	  }
	  catch(Exception e){
	  }
	}
}