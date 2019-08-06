/**
 * This class represent binary search tree data structure
 */
package Problem1;
import java.util.ArrayList;
import java.util.Arrays;
public class BST {
	public Node rootNode;

	/**
	 * Default constructor use to initialize rootNode
	 */
	public BST() {
		this.rootNode = null;
	}
	/**
	 * This method add key value pair to binary search tree it calls add(Node,Node) method
	 * @param Node object of node class which need to be added
	 * @return true if node is added else false
	 * @throws Exception if node key is already present
	 */
	public boolean add(Node node) throws Exception {
			this.rootNode = add(this.rootNode, node);
			return true;
	}
	/**
	 * This method add key value pair to binary search tree
	 * @param rootNode root node of binary search tree
	 * @param node object of Node class which need to be added
	 * @return rootNode after addition
	 * @throws Exception if node is already present
	 */
	private Node add(Node rootNode, Node node) throws Exception {
		if (rootNode == null) {
			rootNode = node;
			return rootNode;
		}
		if (node.getKey().compareTo(rootNode.getKey()) < 0) {
			rootNode.leftChildNode = this.add(rootNode.leftChildNode, node);
		} 
		else if (node.getKey().compareTo(rootNode.getKey()) > 0) {
			rootNode.rightChildNode = this.add(rootNode.rightChildNode, node);
		} 
		else {
			throw new Exception("Node already Present");
		}
		return rootNode;
	}
	/**
	 * This method delete node for given key it calls delete(Node,String) method 
	 * @param key String type key for which node need to be deleted
	 * @return true if node is deleted else false
	 * @throws Exception if binary search tree is empty or key not found
	 */
	public boolean delete(String key)throws Exception {
		if(this.rootNode == null){
			throw new Exception("BST is empty");
		}
		this.rootNode = delete(this.rootNode,key);
		return true;
	}
	/**
	 * This method delete node for given key 
	 * @param rootNode root node of binary search tree
	 * @param key String type key for which node need to be deleted
	 * @return rootNode of binary search tree
	 * @throws Exception if binary search tree is empty or key not found
	 */
	private Node delete(Node rootNode,String key) throws Exception{
        if (rootNode == null){
        	throw new Exception("Key not found");
        }
        if (rootNode.getKey().compareTo(key) > 0){
        	rootNode.leftChildNode = delete(rootNode.leftChildNode, key); 
        }
        else if (rootNode.getKey().compareTo(key) < 0){ 
        	rootNode.rightChildNode = delete(rootNode.rightChildNode, key); 
        }
        else
        { 
            if (rootNode.leftChildNode == null){  return rootNode.rightChildNode; }  
            else if (rootNode.rightChildNode == null){ return rootNode.leftChildNode; }
               
  
            //node with two children get the inorder successor (smallest in the right subtree) 
            Node minNode = getMinimumNode(rootNode.rightChildNode); 
  
            //Delete the inorder successor 
            rootNode.rightChildNode = delete(rootNode.rightChildNode, minNode.getKey()); 
            //changing left and right node references 
            minNode.leftChildNode = rootNode.leftChildNode;
            minNode.rightChildNode = rootNode.rightChildNode;
            rootNode = minNode;
        } 
        return rootNode; 
	}
	/**
	 * This method return the node with minimum key value
	 * @param node starting node in binary search tree
	 * @return the node with minimum key value
	 */
	private Node getMinimumNode(Node node){
		Node minNode = node;
        while (minNode.leftChildNode != null) 
        { 
            minNode = minNode.leftChildNode; 
        } 
        return minNode; 
	}
	/**
	 * This method return node for given key it calls get(Node,String) method
	 * @param key String type key for which node need to be find
	 * @return node for the given key
	 * @throws Exception if key not found
	 */
	public Node get(String key) throws Exception {
		return get(this.rootNode, key);
	}
	/**
	 * This method return node for given key
	 * @param key String type key for which node need to be find
	 * @return node for the given key
	 * @throws Exception if key not found
	 */
	private Node get(Node rootNode, String key) throws Exception {
		if (rootNode == null) {
			throw new Exception("Node not available");
		}
		if (rootNode.getKey().compareTo(key) > 0) {
			return this.get(rootNode.getLeftChildNode(), key);
		} 
		else if (rootNode.getKey().compareTo(key) < 0) {
			return this.get(rootNode.getRightChildNode(), key);
		}
		return rootNode;
	}
	/**
	 * This method return sorted list of nodes in binary search tree it calls getSortedNode(Node,ArrayList<Node>) method
	 * @return sorted array containing nodes
	 * @throws Exception if binary search tree is empty
	 */
	public Node[] getSortedNode() throws Exception{
		if(this.rootNode == null){
			throw new Exception("Empty BST");
		}
		ArrayList<Node> sortedNodesList = new ArrayList<Node>();
		sortedNodesList = getSortedNode(this.rootNode, sortedNodesList);
		Object objArr[] = sortedNodesList.toArray();
		Node[] sortedNodes = Arrays.copyOf(objArr, objArr.length, Node[].class);
		return sortedNodes;
	}
	/**
	 * This method return sorted list of nodes in binary search tree
	 * @return sorted ArrayList<Node> containing node
	 */
	private ArrayList<Node> getSortedNode(Node rootNode, ArrayList<Node> sortedNodesList) {
		if (rootNode.leftChildNode == null && rootNode.rightChildNode == null) {
			sortedNodesList.add(rootNode);
		} 
		else if(rootNode.leftChildNode != null && rootNode.rightChildNode == null){
			getSortedNode(rootNode.leftChildNode, sortedNodesList);
			sortedNodesList.add(rootNode);
		}
		else if(rootNode.rightChildNode != null && rootNode.leftChildNode == null){
			sortedNodesList.add(rootNode);
			getSortedNode(rootNode.rightChildNode, sortedNodesList);
		}
		else{
			getSortedNode(rootNode.leftChildNode, sortedNodesList);
			sortedNodesList.add(rootNode);
			getSortedNode(rootNode.rightChildNode, sortedNodesList);
		}
		return sortedNodesList;
	}
	/**
	 * This method return sorted list of nodes in binary search tree between given two keys it calls getSortedNode(Node,String,String,ArrayList<Node>) method
	 * @param firstKey String type key from which all key should be greater or equal
	 * @param secondKey String type key form which all key should be smaller or equal
	 * @return sorted array containing nodes
	 * @throws Exception if binary search tree is empty
	 */
	public Node[] getSortedNode(String firstKey, String secondKey) throws Exception{
		if(this.rootNode == null){
			throw new Exception("Empty BST");
		}
		ArrayList<Node> sortedNodesList = new ArrayList<Node>();
		sortedNodesList = getSortedNode(this.rootNode, firstKey, secondKey, sortedNodesList);
		Object objArr[] = sortedNodesList.toArray();
		Node[] sortedNodes = Arrays.copyOf(objArr, objArr.length, Node[].class);
		return sortedNodes;
	}
	/**
	 * This method return sorted list of nodes in binary search tree between given two keys
	 * @param firstKey String type key from which all key should be greater or equal
	 * @param secondKey String type key form which all key should be smaller or equal
	 * @return sorted ArrayList<Node> containing nodes
	 * @throws Exception if binary search tree is empty
	 */
	private ArrayList<Node> getSortedNode(Node rootNode, String firstKey, String secondKey,
			ArrayList<Node> sortedNodesList) {
		if (rootNode.leftChildNode == null && rootNode.rightChildNode == null) {
			if ((rootNode.getKey().compareTo(firstKey) >= 0) && (rootNode.getKey().compareTo(secondKey) <= 0)) {
				sortedNodesList.add(rootNode);
			}
		} 
		else if(rootNode.leftChildNode != null && rootNode.rightChildNode == null){
			getSortedNode(rootNode.leftChildNode, firstKey, secondKey, sortedNodesList);
			if ((rootNode.getKey().compareTo(firstKey) >= 0) && (rootNode.getKey().compareTo(secondKey) <= 0)) {
				sortedNodesList.add(rootNode);
			}
		}
		else if(rootNode.rightChildNode != null && rootNode.leftChildNode == null){
			if ((rootNode.getKey().compareTo(firstKey) >= 0) && (rootNode.getKey().compareTo(secondKey) <= 0)) {
				sortedNodesList.add(rootNode);
			}
			getSortedNode(rootNode.rightChildNode, firstKey, secondKey, sortedNodesList);
		} 
		else {
			getSortedNode(rootNode.leftChildNode, firstKey, secondKey, sortedNodesList);
			if ((rootNode.getKey().compareTo(firstKey) >= 0) && (rootNode.getKey().compareTo(secondKey) <= 0)) {
				sortedNodesList.add(rootNode);
			}
			getSortedNode(rootNode.rightChildNode, firstKey, secondKey, sortedNodesList);
		}
		return sortedNodesList;
	}
}