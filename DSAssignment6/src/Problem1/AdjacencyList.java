package Problem1;
/**
 * This class represents Adjacency List
 */
public class AdjacencyList {
	private int vertex;
	private int weight;
	/**
	 * @param vertex
	 * @param weight
	 */
	public AdjacencyList(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	/**
	 * @return
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @return
	 */
	public int getVertex() {
		return vertex;
	}
}