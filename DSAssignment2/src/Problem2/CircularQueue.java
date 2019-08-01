/*
 * This class represent Queue
 * Methods 
 * 		enQueue - adds up the value to queue
 * 		deQueue - deletes up the front value
 */
package Problem2;
public class CircularQueue implements Queue {
	
	private int QUEUE_SIZE = 5;
	private int front = -1;
	private int rear = -1;
	private int queue[];
	
	public CircularQueue(){	
		this.queue=new int[this.QUEUE_SIZE];
	}
	public CircularQueue(int size){
		this.QUEUE_SIZE=size;
		this.queue=new int[this.QUEUE_SIZE];
	}
	/*
	 * @param int value to be added to queue
	 * @return true if value is added 
	 */
	public boolean enQueue(int element) throws Exception{

		if (this.isFull()) {
			throw new Exception("Queue is full");
		}
		else {
			if (front == -1 && rear == -1) {
				front = 0;
				rear = 0;
				queue[rear] = element;
				return true;
			}
			if (front > 0 && (rear + 1) == queue.length) {
				rear = 0;
				queue[rear] = element;
				return true;
			}
			rear++;
			queue[rear] = element;
			return true;
		}
	}

	/*
	 * @param null
	 * @return element which is removed
	 */
	public int deQueue() throws Exception{

		if (this.isEmpty()) {
			throw new Exception("Queue is empty");
		}
		else{
			if (front == rear) {
				int value = queue[front];
				front = -1;
				rear = -1;
				return value;
			}
			if ((front + 1) == queue.length) {
				int value = queue[front];
				front = 0;
				return value;
			}
			int value = queue[front];
			front++;
			return value;
		}
	}
		
	/*
	 * @param null
	 * @return first element in the queue
	 */
	public int getFirst() throws Exception{

		if (this.isEmpty()) {
			throw new Exception("Queue is empty");
		}
		return queue[front];
	}

	/*
	 * @param null
	 * @return last element in the queue
	 */
	public int getLast() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Queue is empty");
		}
		return queue[rear];
	}

	/*
	 * @param null
	 * @return true if queue is empty else false
	 */
	public boolean isEmpty() {
		if (front == -1 && rear == -1) {
			return true;
		}
		return false;
	}

	/*
	 * @param null
	 * @return true if queue is full else false
	 */
	public boolean isFull() {
		if (((rear + 1) == queue.length && front == 0) || (rear + 1) == front) {
			return true;
		}
		return false;
	}
}