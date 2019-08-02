/*
 * Class for Element of Priority Queue
 * Methods
 * 		Object - Parameterized Constructor
 * 		getPriority - returns priority
 * 		setPriority - sets priority
 * 		getValue - returns value
 */
package Problem2;

public class Element {
	private int priority;
	private final String value;
	/*
	 * @param int value
	 * @param int type priority
	 * @return null
	 */
	public Element(int value,int priority){
		this.value=Integer.toString(value);
		this.priority=priority;
	}
	/*
	 * @param null
	 * @return int type priority
	 */
	public int getPriority() {
		return priority;
	}
	/*
	 * @param int type priority
	 * @return null
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/*
	 * @param null
	 * @return String type value
	 */
	public int getValue() {
		return Integer.parseInt(value);
	}
}