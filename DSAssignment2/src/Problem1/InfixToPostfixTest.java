/*
 * Test class operating Under J Unit 4
 */
package Problem1;
import static org.junit.Assert.*;
import org.junit.Test;
public class InfixToPostfixTest {

	@Test
	public void testInfixToPostfixConverter() throws Exception {
		InfixToPostfix infix=new InfixToPostfix("( 1 + ( 2 / ( 3 * ( 4 + 5 ) ) ) - 6 )");
		String result=infix.infixToPostfixConverter();
		
		assertEquals("1 2 3 4 5 + * / + 6 - ",result);
		
		String infixExpression1 = "1 + 2";
		String infixExpression2 = "( 5 * 6 ) / 5";
		String infixExpression3 = "3 && 4";
		String infixExpression4 = "7 || 9";
		String infixExpression5 = "( 5 - 2 ) * 3";
		String infixExpression6 = "( 3 < 6 ) * 6";
		String infixExpression7 = "( 7 > 9 )";
		String infixExpression8 = "7 >= 9";
		String infixExpression9 = "7 <= 9";
		String infixExpression10 = "! 6";
		String infixExpression11 = "5 == 5";

		assertEquals(3,new PostFixEvaluator(new InfixToPostfix(infixExpression1).infixToPostfixConverter()).evaluate());
		assertEquals(6,new PostFixEvaluator(new InfixToPostfix(infixExpression2).infixToPostfixConverter()).evaluate());
		assertEquals(1,new PostFixEvaluator(new InfixToPostfix(infixExpression3).infixToPostfixConverter()).evaluate());
		assertEquals(1,new PostFixEvaluator(new InfixToPostfix(infixExpression4).infixToPostfixConverter()).evaluate());
		assertEquals(9,new PostFixEvaluator(new InfixToPostfix(infixExpression5).infixToPostfixConverter()).evaluate());
		assertEquals(6,new PostFixEvaluator(new InfixToPostfix(infixExpression6).infixToPostfixConverter()).evaluate());
		assertEquals(0,new PostFixEvaluator(new InfixToPostfix(infixExpression7).infixToPostfixConverter()).evaluate());
		assertEquals(0,new PostFixEvaluator(new InfixToPostfix(infixExpression8).infixToPostfixConverter()).evaluate());
		assertEquals(1,new PostFixEvaluator(new InfixToPostfix(infixExpression9).infixToPostfixConverter()).evaluate());
		assertEquals(2353,new PostFixEvaluator(new InfixToPostfix(infixExpression10).infixToPostfixConverter()).evaluate());
		assertEquals(1,new PostFixEvaluator(new InfixToPostfix(infixExpression11).infixToPostfixConverter()).evaluate());
	}	
}