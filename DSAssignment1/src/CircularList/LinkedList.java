/*
 * Class Implementing Linked List
 * Methods 
 * 		insert - insert a node at the end of Linked List
 * 		insertCircular - insert a node at the end and points to your preferred Index
 * Assumption All Nodes are unique
 */
package CircularList;
public class LinkedList{
	private Node head;
	/*
	 * @param int type data of node
	 * @return boolean true after adding element
	 */
	public boolean insert(int data){
		Node node=new Node();
		node.data=data;
		node.next=null;
		
		if(head==null){
			head=node;
		}
		else{
			Node n=head;
			while(n.next!=null){
				n=n.next;
			}
			n.next=node;
		}
		return true;
	}
	/*
	 * @param null
	 * @return null
	 */
	public void show(){
		Node n=head;
		while(n.next!=null){
			System.out.println(n.data);
			n=n.next;
		}
		System.out.println(n.data);
	}
	/*
	 * @param int type data of node
	 * @param int type index of to be pointed node
	 * @return true after circular addition
	 */
	public boolean insertCircular(int data,int index){
		boolean flag=false;
		Node node=new Node();
		node.data=data;
		node.next=null;
		
		if(head==null){
			head=node;
			node.next=head;
			flag=true;
		}
		else{
			Node n=head;
			while(n.next!=null){
				n=n.next;
			}
			n.next=node;
			n=n.next;
			Node next=head;
			for(int i=0;i<index-1;i++){
				next=next.next;
				flag=true;
			}
			n.next=next.next;
		}
		return flag;
	}
	/*
	 * @param null
	 * @return boolean true if loop is found
	 * @return boolean false if loop is not found
	 */
	public boolean isLoopPresent(){
		LinkedList list=new LinkedList();
		Node n=head;
		while(n.next!=null){
			if(!find(list,n.data)){
				list.insert(n.data);
				n=n.next;
			}
			else{
				return true;
			}
		}
		return false;		
	}
	/*
	 * @param Linked List 
	 * @param int type data
	 * @return boolean true if loop is found
	 * @return boolean false if loop is not found
	 */
	private boolean find(LinkedList list,int data){
		Node n=list.head;
		if(n!=null){
			while(n.next!=null){
				if(n.data==data){
					return true;
				}
				n=n.next;
			}
			if(n.data==data){
				return true;
			}
		}
		return false;
	}
}