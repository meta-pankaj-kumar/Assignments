/*
 * Interface for Queue 
 */
package Problem2;
public interface Queue {
	/*
	 * @param int value to be added to queue
	 * @return true if value is added else false
	 */
	public boolean enQueue(int value)throws Exception;
	/*
	 * @param null
	 * @return element which is removed
	 */
	public int deQueue()throws Exception;
	/*
	 * @param null
	 * @return true if queue is empty else false
	 */
	public boolean isEmpty();
	/*
	 * @param null
	 * @return true if queue is full else false
	 */
	public boolean isFull();
}