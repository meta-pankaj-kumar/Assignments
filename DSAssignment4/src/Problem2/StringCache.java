/**
 * Class for String Cache
 * Methods - 
 * 		getLengthOfUniqueCharacters - returns length of Unique Characters of String
 */
package Problem2;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class StringCache {
	private HashMap<String,Set<Character>> hashMap;
	/**
	 * @param null
	 * @return null
	 */
	public StringCache(){
		hashMap=new HashMap<String,Set<Character>>();
	}
	/**
	 * @param String type string for number of unique characters
	 * @return int type length of number of unique characters
	 */
	public int getLengthOfUniqueCharacters(String string){
		int length=0;
		if(hashMap.containsKey(string)){
			length = hashMap.get(string).size();
		}
		else{
			Set<Character> set=new HashSet<Character>();
			for(int indexFirst=0;indexFirst<string.length();indexFirst++){
				set.add(string.charAt(indexFirst));
			}
			hashMap.put(string, set);
			length = set.size();
		}
		return length;
	}
}