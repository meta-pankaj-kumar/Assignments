package Problem1;
/**
 * This interface represent dictionary data structure
 */
public interface IDictionary {
	/**
	 * This method add key value pair to dictionary
	 * @param key String type key of element
	 * @param value String type value of element
	 * @return true if key value pair is added else false
	 * @throws Exception if key is already present
	 */
	public boolean add(String key, String value) throws Exception;
	/**
	 * This method delete key value pair for given key
	 * @param key String type key for which data need to be deleted
	 * @return true if key value pair is deleted else false
	 * @throws Exception if dictionary is empty or key not found
	 */
	public boolean delete(String key) throws Exception;
	/**
	 * This method return value for given key
	 * @param key String type key for which value need to be find
	 * @return String type value for the given key
	 * @throws Exception if key not found
	 */
	public String get(String key) throws Exception;
	/**
	 * This method return sorted list of key value pairs in dictionary
	 * @return sorted 2 dimension array containing key and values 
	 * @throws Exception if dictionary is empty
	 */
	public String[][] getSortedKeyValuePairs() throws Exception;
	/**
	 * This method return sorted list of key value pairs in dictionary between given two keys
	 * @param firstKey String type key from which all key should be greater or equal
	 * @param secondKey String type key form which all key should be smaller or equal
	 * @return sorted 2 dimension array containing key and values 
	 * @throws Exception if dictionary is empty
	 */
	public String[][] getSortedKeyValuePairs(String firstKey, String secondKey) throws Exception;
}