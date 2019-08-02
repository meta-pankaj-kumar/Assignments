/*
 * Method class for implementation of Priority Queue
 * Methods
 * 		enQueue - enter a value with priority to queue
 * 		deQueue - removes element with maximum priority
 * 		isQueueEmpty - boolean result of queue state
 * 		isQueueFull - boolean result of queue state
 */
package Problem2;
import Problem3.MaxHeap;
import Problem3.Object;
public class PriorityQueue {
	private MaxHeap heap;
	private int totalNumberOfElements;
	private int counter;
	/*
	 * @param int type total number of elements of queue
	 * @return null
	 */
	public PriorityQueue(int totalNumberOfElements) {
		this.totalNumberOfElements=totalNumberOfElements;
		this.counter=this.totalNumberOfElements;
		heap = new MaxHeap(this.totalNumberOfElements);
	}
	/*
	 * @param int type value
	 * @param int type priority
	 * @return boolean true after addition of element to queue
	 * @exception throws exception if queue is full
	 */
	public boolean enQueue(int value, int priority) throws Exception{
		if(this.totalNumberOfElements>0){
			Element element=new Element(value,priority);
			Object object=new Object(Integer.toString(element.getValue()),element.getPriority());
			heap.insertNode(object);
			this.totalNumberOfElements--;
			return true;
		}
		else{
			throw new Exception("Elements Queue is already Full");
		}
	}
	/*
	 * @param null
	 * @return int type deleted element
	 * @exception throws exception is queue is empty
	 */
	public int deQueue() throws Exception{
		if(this.totalNumberOfElements>=0){
			if(heap.checkIfAllElmentsAreZero()){
				totalNumberOfElements=this.counter;
				throw new Exception("No Element Left to Pop Out");
			}
			Object object=heap.deleteNode();
			Element element=new Element(Integer.parseInt(object.getValue()),object.getPriority());
			return element.getValue();
		}
		else {
			throw new Exception("Complete Addition Of Numbers First");
		}
	}
	/*
	 * @param null
	 * @return boolean true if queue is empty
	 * @return boolean false if queue is not empty
	 */
	public boolean isQueueEmpty(){
		boolean flag=false;
		if(heap.checkIfAllElmentsAreZero())
			flag=true;
		return flag;
	}
	/*
	 * @param null
	 * @return boolean true if queue is full
	 * @return boolean false if queue is not full
	 */
	public boolean isQueueFull(){
		boolean flag=false;
		if(this.totalNumberOfElements==0){
			flag=true;
		}
		return flag;
	}
}