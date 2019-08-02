/*
 * Class controlling Max heap
 * Methods
 * 		Object - Parameterized Constructor
 * 		getPriority - returns priority
 * 		setPriority - sets priority
 * 		getValue - returns value
 */
package Problem3;
public class Object {
	private final String value;
	private int priority;
	/*
	 * @param String value
	 * @param int type priority
	 * @return null
	 */
	public Object(String value,int priority) {
		this.value=value;
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
	public String getValue() {
		return value;
	}
}