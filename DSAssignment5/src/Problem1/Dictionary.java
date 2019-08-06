/**
 * This class represent dictionary data structure
 */
package Problem1;
import com.google.gson.Gson;
public class Dictionary implements IDictionary {
	private BST bst;
	/**
	 * Parameterized constructor use to initialize dictionary object with initial key value pair provided by JSON string
	 * @param initialKeysValues JSON string containing starting key value pairs for dictionary
	 * @throws Exception if JSON is empty or if keys and values are not equal
	 */
	public Dictionary(String initialKeysValues) throws Exception{
		if(initialKeysValues.length() == 0){
			throw new Exception("Invalid JSON String");
		}
		Gson gson = new Gson();
		this.bst = new BST();
		Data data = gson.fromJson(initialKeysValues, Data.class);
		fillDictionary(data);
	}
	/**
	 * This method fill initial key value pairs in dictionary
	 * @param data object of Data class containing the key value String arrays
	 * @throws Exception if number of keys and values is not equal
	 */
	private void fillDictionary(Data data) throws Exception{
		if(data.getKeys().length == data.getValues().length){
			String[] keys = data.getKeys();
			String[] values = data.getValues();
			for(int keyValueIndex =0; keyValueIndex < keys.length; keyValueIndex++){
				this.add(keys[keyValueIndex],values[keyValueIndex]);
			}
		}
		else{
			throw new Exception("Missing key value pairs");
		}
	}
	/**
	 * This method add key value pair to dictionary
	 * @param key String type key of element
	 * @param value String type value of element
	 * @return true if key value pair is added else false
	 * @throws Exception if key is already present
	 */
	@Override
	public boolean add(String key, String value) throws Exception{
		try {
			Node node = new Node(key,value);
			return this.bst.add(node);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Key already present");
		}
	}
	/**
	 * This method delete key value pair for given key
	 * @param key String type key for which data need to be deleted
	 * @return true if key value pair is deleted else false
	 * @throws Exception if dictionary is empty or key not found
	 */
	@Override
	public boolean delete(String key) throws Exception {
		try {
			return this.bst.delete(key);
		} 
		catch (Exception e) {
			e.printStackTrace();
			if(e.getMessage().equalsIgnoreCase("BST is empty")){
				throw new Exception("Dictionary is empty");
			}
			else{
				throw e;
			}
		}
	}
	/**
	 * This method return value for given key
	 * @param key String type key for which value need to be find
	 * @return String type value for the given key
	 * @throws Exception if key not found
	 */
	@Override
	public String get(String key) throws Exception{
		try{
			return this.bst.get(key).getValue();
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("Key not found");
		}
	}
	/**
	 * This method return sorted list of key value pairs in dictionary
	 * @return sorted 2 dimension array containing key and values 
	 * @throws Exception if dictionary is empty
	 */
	@Override
	public String[][] getSortedKeyValuePairs() throws Exception{
		try{
			Node[]  sortedNodes = this.bst.getSortedNode();
			String[][] sortedKeyValuePairs = new String[sortedNodes.length][2];
			int keyIndex =0;
			for(Node node : sortedNodes){
				sortedKeyValuePairs[keyIndex][0] = node.getKey();
				sortedKeyValuePairs[keyIndex][1] = node.getValue();
				keyIndex++;
			}
			return sortedKeyValuePairs;
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("Dictionary is empty");
		}
	}
	/**
	 * This method return sorted list of key value pairs in dictionary between given two keys
	 * @param firstKey String type key from which all key should be greater or equal
	 * @param secondKey String type key form which all key should be smaller or equal
	 * @return sorted 2 dimension array containing key and values 
	 * @throws Exception if dictionary is empty
	 */
	@Override
	public String[][] getSortedKeyValuePairs(String firstKey, String secondKey) throws Exception {
		try{
			Node[]  sortedNodes = this.bst.getSortedNode(firstKey,secondKey);
			String[][] sortedKeyValuePairs = new String[sortedNodes.length][2];
			int keyIndex =0;
			for(Node node : sortedNodes){
				sortedKeyValuePairs[keyIndex][0] = node.getKey();
				sortedKeyValuePairs[keyIndex][1] = node.getValue();
				keyIndex++;
			}
			return sortedKeyValuePairs;
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("Dictionary is empty");
		}
	}
}