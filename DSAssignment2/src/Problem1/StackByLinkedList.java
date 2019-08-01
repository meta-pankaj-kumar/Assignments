/*
 * Class implementing stack operations on Linked List
 * Methods
 * 		push - pushes an element into stack
 * 		pop - deletes an element from stack
 * 		isEmpty - checks for is stack is empty
 * 		peek - returns the value of top Of stack
 */
package Problem1;
import java.util.LinkedList;
import java.util.List;
public class StackByLinkedList {
	public List<String> stack=new LinkedList<String>();
	public int topOfStack=-1;
	public int Max_Size_Of_LinkedList=1000;
	/*
	 * @param null
	 * @return true if element is added to stack
	 */
	public boolean push(String element)throws Exception {
		boolean flag=false;
		if(topOfStack+1==Max_Size_Of_LinkedList) {
			throw new Exception("Stack Overflow");
		}
		else {
			topOfStack++;
			stack.add(element);
			flag=true;
		}
		return flag;
	}
	/*
	 * @param null
	 * @return true if element is deleted from stack
	 */
	public String pop()throws Exception {
		String element;
		if(topOfStack==-1) {
			throw new Exception("Stack Underflow");
		}
		else {
			element=stack.get(topOfStack);
			stack.remove(topOfStack);
			topOfStack--;
		}
		return element;
	}
	/*
	 * @param null
	 * @return true if stack is empty
	 * @return false if stack is not empty
	 */
	public boolean isEmpty() {
		boolean flag=false;
		if(topOfStack==-1) {
			flag=true;
		}
		return flag;
	}
	/*
	 * @param null
	 * @return int value of top of stack
	 */
	public String peek()throws Exception {
		if(topOfStack==-1) {
			throw new Exception("Stack Underflow");
		}
		return stack.get(topOfStack);
	}
}