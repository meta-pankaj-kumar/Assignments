package Problem1;
import java.util.List;
public interface UndrectedWeightedGraph {

	/**
	 * Returns true is the Graph is a Connected Graph
	 * @return
	 */
	public boolean isConnected();

	/**
	 * Returns all the Nodes that are Reachable from node
	 * @param node
	 * @return
	 * @throws Exception 
	 */
	public List<Integer> reachable(int node) throws Exception;
	/**
	 * Return the Minimum Spanning Tree for the Graph
	 * 
	 * @return
	 */
	public int[][] minimumSpanningTree();

	/**
	 * Returns the Shortest Path from node1 to node2 using Dijkstra’s Algorithm
	 * @param node1
	 * @param node2
	 * @return
	 * @throws Exception 
	 */
	public int shortestPath(int node1, int node2) throws Exception;
}