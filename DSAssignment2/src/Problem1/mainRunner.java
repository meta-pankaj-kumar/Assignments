/*
 * Main Runner for Infix Evaluation
 */
package Problem1;
import java.util.*;
public class mainRunner {
	/*
	 * @param null
	 * @return null
	 */
	public static void main(String[] args) throws Exception {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter an Expression seperated with an space");
		System.out.println("An example has been provided to you");
		System.out.println();
		System.out.println("Enter your expression");
		String expression=in.nextLine();
		InfixToPostfix infix=new InfixToPostfix(expression);
		String result=infix.infixToPostfixConverter();
		System.out.println("Evaluated Postfix of "+expression);
		System.out.println("Is "+result);
		PostFixEvaluator postfix=new PostFixEvaluator(result);
		System.out.println("After evaluating Postfix answer is "+postfix.evaluate());
		in.close();
	}
}