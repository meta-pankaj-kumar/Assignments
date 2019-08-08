/**
 * This class represent node in binary search tree
 */
package Problem1;
public class Node {
	public Node leftChildNode;
	public Node rightChildNode;
	private final String key;
	private final String value;
	/**
	 * Parameterized constructor used to initializing key and value
	 */
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
	}
	/**
	 * This method return left child node
	 * @return the leftChildNode
	 */
	public Node getLeftChildNode() {
		return this.leftChildNode;
	}
	/**
	 * This method set the right child node
	 * @param leftChildNode the leftChildNode to set
	 */
	public void setLeftChildNode(Node leftChildNode) {
		this.leftChildNode = leftChildNode;
	}
	/**
	 * This method return the right child node
	 * @return the rightChildNode
	 */
	public Node getRightChildNode() {
		return this.rightChildNode;
	}
	/**
	 * This method set the right child node
	 * @param rightChildNode the rightChildNode to set
	 */
	public void setRightChildNode(Node rightChildNode) {
		this.rightChildNode = rightChildNode;
	}
	/**
	 * This method return the key 
	 * @return the key
	 */
	public String getKey() {
		return this.key;
	}
	/**
	 * This method return the value
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}
}