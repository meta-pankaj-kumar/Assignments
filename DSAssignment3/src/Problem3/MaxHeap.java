/*
 * MaxHeap implementation
 * Methods 
 * 		MaxHeap - parameterized Constructor
 * 		insertNode - inserts node to max Heap
 * 		deleteHeapify - heapify for deletion
 * 		addHeapify - heapify for addition
 * 		deleteNode - deletes Root Node
 * 		swap - swaps two values   
 * 		checkIfAllElmentsAreZero - checks for all zero nodes	
 */
package Problem3;
public class MaxHeap {
	private int totalElements;
	private Object array[];
	private int counter;
	/*
	 * @param int type total elements
	 * @return null
	 */
	public MaxHeap(int totalElements){
		this.totalElements=totalElements;
		this.array=new Object[this.totalElements+1];
		this.counter=0;
	}
	/*
	 * @param Object type object
	 * @return true after addition of Node
	 */
	public boolean insertNode(Object object){
		this.counter++;
		this.array[this.counter]=object;
		addHeapify();
		return true;
	}
	/*
	 * @param null
	 * @return null
	 */
	private void addHeapify(){
		for(int indexFirst=this.counter;indexFirst>0;indexFirst--) {
			int indexOfParent=indexFirst/2;
			if(indexOfParent>=1) {
				if(this.array[indexFirst].getPriority()>this.array[indexOfParent].getPriority()) {
					swap(indexFirst,indexOfParent);
				}
			}			
		}
	}
	/*
	 * @param null
	 * @return Objects of deleted node
	 */
	public Object deleteNode(){
		int priority=this.array[1].getPriority();
		String name=(String) this.array[1].getValue();
		Object object=new Object(name, priority);
		this.array[1]=this.array[counter];
		counter--;
		deleteHeapify();
		return object;	
	}
	/*
	 * @param null
	 * @return null
	 */
	private void deleteHeapify(){
		for(int indexFirst=1;indexFirst<=counter;indexFirst++){
			int indexOfLeftChild = indexFirst*2;
			int indexOfRightChild = indexFirst*2+1;
			//if right child is present
			if(indexOfRightChild<=counter){
				//if left child has greater priority
				if(this.array[indexOfLeftChild].getPriority()>this.array[indexOfRightChild].getPriority()){
					//if left child's priority id greater than parent
					if(this.array[indexOfLeftChild].getPriority()>this.array[indexFirst].getPriority()){
						swap(indexOfLeftChild,indexFirst);
					}
				}
				//if right child is greater
				else{
					if(this.array[indexOfRightChild].getPriority()>this.array[indexFirst].getPriority()){
						swap(indexOfRightChild,indexFirst);
					}
				}
			}
			//if only first child is present
			else if(indexOfLeftChild<=counter){
				if(this.array[indexOfLeftChild].getPriority()>this.array[indexFirst].getPriority()){
					swap(indexOfLeftChild,indexFirst);
				}
			}
		}
	}
	/*
	 * @param int first index
	 * @param int second index
	 * @return null
	 */
	private void swap(int indexFirst,int indexSecond){
		Object object=this.array[indexFirst];
		this.array[indexFirst]=this.array[indexSecond];
		this.array[indexSecond]=object;
	}
	/*
	 * @param null
	 * @return boolean true if all priorities are zero
	 * @return boolean false if not so
	 */
	public boolean checkIfAllElmentsAreZero(){
		boolean flag=true;
		for(int indexValue=1;indexValue<=counter;indexValue++){
			if(this.array[indexValue].getPriority()!=0){
				flag=false;
			}
		}
		return flag;
	}
}