/*
 * Class for converting Infix to Postfix
 * Methods 
 * 		InfixToPostfix - Parameterised Constructor
 * 		infixToPostfixConverter - Converts infix to Postfix
 * 		prioritySetter - Sets Priority of different Operators
 * 		isFristOperatorPriorityGreater - Checks for if Frist Operator Priority Greater
 * 		isPriorityEqual - Checks for if Priorities are Equal
 */
package Problem1;
import java.util.HashMap;
public class InfixToPostfix {
	private String expression;
	private String[] expressionArray;
	private String postfix;
	private HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
	private StackByLinkedList stack=new StackByLinkedList();
	/*
	 * @param String type infix Expression
	 * @return null
	 */
	public InfixToPostfix(String expression) {
		this.expression=expression;
		this.postfix="";
		prioritySetter();
		expressionChanger();
		this.expressionArray=this.expression.split(" ");
	}
	/*
	 * @param null
	 * @return null
	 */
	private void expressionChanger() {
		this.expression="( "+this.expression;
		this.expression=this.expression+" )";
	}
	/*
	 * @param null
	 * @return String type postfix expression after conversion 
	 */
	public String infixToPostfixConverter() throws Exception {
		for(int indexFirst=0;indexFirst<expressionArray.length;indexFirst++) {
			if(expressionArray[indexFirst].charAt(0)>='0' && expressionArray[indexFirst].charAt(0)<='9') {
				this.postfix=this.postfix+this.expressionArray[indexFirst]+" ";
			}
			else {
				//first operator comes in stack
				if(stack.topOfStack==-1){
					stack.push(this.expressionArray[indexFirst]);
				}
				//if operator comes and top of stack has '('
				else if(this.stack.peek().equals("(") && (!this.expressionArray[indexFirst].equals(")"))){
					stack.push(this.expressionArray[indexFirst]);
				}
				//if greter priority operator comes 
				else if((!this.expressionArray[indexFirst].equals(")"))  && (!this.expressionArray[indexFirst].equals("(")) && isFristOperatorPriorityGreater(this.expressionArray[indexFirst],this.stack.peek())) {
					stack.push(this.expressionArray[indexFirst]);
				}
				//if same priority operator comes
				else if((!this.expressionArray[indexFirst].equals(")"))  && (!this.expressionArray[indexFirst].equals("(")) && (isPriorityEqual(this.expressionArray[indexFirst],this.stack.peek()))) {
					this.postfix=this.postfix+this.stack.pop()+" ";
					--indexFirst;
				}
				//if ')' comes
				else if(this.expressionArray[indexFirst].equals(")")) {
					while(!this.stack.peek().equals("(")) {
						this.postfix=this.postfix+this.stack.pop()+" ";
					}
					stack.pop();
					if(this.stack.isEmpty()){
						break;
					}
				}
				//if '(' comes
				else if(this.expressionArray[indexFirst].equals("(")) {
					this.stack.push(expressionArray[indexFirst]);
				}
				//if lesser priority operator comes
				else {
					this.postfix=this.postfix+this.stack.pop()+" ";
					indexFirst--;
				}
			}
		} 		
		return postfix;
	}
	/*
	 * @param null
	 * @return null
	 */
	private void prioritySetter() {
		this.hashmap.put("+",11);
		this.hashmap.put("-",11);
		this.hashmap.put("*",12);
		this.hashmap.put("/",12);
		this.hashmap.put("==",8);
		this.hashmap.put("!=",8);
		this.hashmap.put("<",9);
		this.hashmap.put(">",9);
		this.hashmap.put("<=",9);
		this.hashmap.put(">=",9);
		this.hashmap.put("&&",4);
		this.hashmap.put("||",3);
		this.hashmap.put("!",14);
	}
	/*
	 * @param String type operator First
	 * @param String type operator Second
	 * @return boolean true if First Operator Priority is Greater
	 * @return boolean false if First Operator Priority is Smaller
	 */
	private boolean isFristOperatorPriorityGreater(String firstOperstor,String secondOperator) {
		if(this.hashmap.get(firstOperstor)>this.hashmap.get(secondOperator)) {
			return true;
		}
		else {
			return false;
		}
	}
	/*
	 * @param String type operator First
	 * @param String type operator Second
	 * @return boolean true if First Operator Priority is Equal to Second Operators Priority
	 * @return boolean false if First Operator Priority is not Equal to Second Operators Priority
	 */
	private boolean isPriorityEqual(String firstOperstor,String secondOperator) {
		if(this.hashmap.get(firstOperstor)==this.hashmap.get(secondOperator)) {
			return true;
		}
		else {
			return false;
		}
	}
}