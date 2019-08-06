/**
 * This class is data container for JSON String parsing
 */
package Problem1;
public class Data {
	public String[] keys;
	public String[] values;
	/**
	 * Parameterized constructor used to initialize keys values arrays
	 * @param keys String array of keys
	 * @param values String array of keys
	 */
	public Data(String[] keys,String[] values){
		this.keys = keys;
		this.values = values;
	}
	/**
	 * This method return the array of keys
	 * @return the keys
	 */
	public String[] getKeys() {
		return keys;
	}
	/**
	 * This method return the array of values
	 * @return the values
	 */
	public String[] getValues() {
		return values;
	}
}