/*
 * Class for evluating final value of Postfix Expression
 * Methods
 * 		PostFixEvaluator - Parameterised Constructor
 * 		evaluate - evalute the value of Postfix Expression
 * 		operate - operates for ! operator
 * 		operate - operates for rest of all operator
 */
package Problem1;
public class PostFixEvaluator {
	private String postfix;
	private StackByLinkedList stack;
	/*
	 * @param String type postfix Expression
	 * @return null
	 */
	public PostFixEvaluator(String postfix){
		this.postfix=postfix;
		this.stack=new StackByLinkedList();
	}
	/*
	 * @param null
	 * @return int type evaluated result
	 */
	public int evaluate() throws Exception{
		String splitted[]=this.postfix.split(" ");
		for(int indexFirst=0;indexFirst<splitted.length;indexFirst++){
			String extracted=splitted[indexFirst];
			if(extracted.charAt(0)>='0' && extracted.charAt(0)<='9'){
				this.stack.push(extracted);
			}
			else{
				if(extracted.equals("!")){
					String operandFirst=this.stack.pop();
					this.stack.push(Integer.toString(operate(Integer.parseInt(operandFirst))));
				}
				else{
					String operandSecond=this.stack.pop();
					String operandFirst=this.stack.pop();
					this.stack.push(Integer.toString(operate(Integer.parseInt(operandFirst),Integer.parseInt(operandSecond), extracted)));
				}
			}
		}
		return Integer.parseInt(this.stack.pop()); 
	}
	/*
	 * @param String type operand
	 * @return String type final Result
	 */
	private int operate(int operandFirst){
		String binary="";
		int newNumber=0;
		while(operandFirst!=0){
			int remainder=operandFirst%2;
			if(remainder==0){
				remainder=1;
			}
			else{
				remainder=0;
			}
			binary=Integer.toString(remainder)+binary;
			operandFirst/=2;
		}
		int power=0;
		for(int indexFirst=binary.length()-1;indexFirst>=0;indexFirst--){
			char ch=binary.charAt(indexFirst);
			newNumber+=Math.pow(Integer.valueOf(ch),power);
			power++;
		}
		return newNumber;
	}
	/*
	 * @param String Operand First
	 * @param String Operand Second
	 * @param String Operator 
	 * @return String type final Result
	 */
	private int operate(int operandFirst, int operandSecond, String operator) {
		switch(operator){
		case "+":
			return (operandFirst+operandSecond);
		case "-":
			return (operandFirst-operandSecond);
		case "*":
			return (operandFirst*operandSecond);
		case "/":
			return (operandFirst/operandSecond);
		case "==":
			if(operandFirst==operandSecond){
				return 1;
			}
			return 0;		
		case "!=":
			if(operandFirst != operandSecond){
				return 1;
			}
			return 0;
		case "<":
			if(operandFirst < operandSecond){
				return 1;
			}
			return 0;	
		case ">":
			if(operandFirst > operandSecond){
				return 1;
			}
			return 0;
		case "<=":
			if(operandFirst <= operandSecond){
				return 1;
			}
			return 0;	
		case ">=":
			if(operandFirst >= operandSecond){
				return 1;
			}
			return 0;
		case "&&":
			if(operandFirst>0 && operandSecond>0){
				return 1;
			}
			return 0;
		case "||":
			if(operandFirst>0 || operandSecond>0){
				return 1;
			}
			return 0;
		}		
		return 0;
	}
}