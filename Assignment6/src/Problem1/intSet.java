/*
 * Immutable class for Set Operations
 * Methods inbuilt are 
 * 		intSet - parametrised constructor
 * 		getSet - converts intSet to int array
 * 		isMember - checks for if a particular value is present in universal set or not
 * 		size - returns the size of universal set
 * 		isSubSet - checks whether the inputed set is a subset of universal set or not
 * 		getCompliment - returns the compliment set of inputed subset
 * 		union - returns the union of two inputed sets
 */		
package Problem1;
import java.util.ArrayList;
import java.util.Arrays;
public class intSet {
	private final Integer[] set;
	
	/* Parameterised Constructor of class
	 * @param int array universal Set
	 * @return null 
	 */
	public intSet(Integer set[]){
		this.set=set;
	}
	
	/*
	 * Getter Method for Universal Set
	 * @param Null
	 * @return int array of universal Set
	 */
	public Integer[] getSet() {
		return set;
	}
	
	/*
	 *@param int value for checking in the universal set
	 *@return true if element found
	 *@return false if not found 
	 */
	public boolean isMember(int x) {
		//linear Search occurring
		if(Arrays.asList(set).contains(x)){
			return true;
		}
		return false;
	}		
	
	/*
	 * @param Null
	 * @return size of universal Set
	 */
	public int size() {
		return set.length;
	}
	
	/*
	 * @param object of intSet
	 * @return true if set is a proper subset of universal set
	 * @return false if not a proper subset
	 */
	public boolean isSubSet(intSet s) {
		for(int indexFirst=0;indexFirst<s.set.length;indexFirst++){
			if(!Arrays.asList(set).contains(s.set[indexFirst])){
				return false;
			}
		}
		return true;
	}
	
	/*
	 * @param Null
	 * @return intSet of compliment Set
	 */
	public intSet getCompliment() {
		//List for adding up compliments directly
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int indexFirst=1;indexFirst<=1000;indexFirst++){
			if(!Arrays.asList(set).contains(indexFirst)){
					list.add(indexFirst);
			}
		}
		Integer complimentArray[]=new Integer[list.size()];
		for(int indexFirst=0;indexFirst<complimentArray.length;indexFirst++){
			complimentArray[indexFirst]=list.get(indexFirst);
		}
		return new intSet(complimentArray);
	}
	
	/*
	 * @param object of intSet
	 * @param object of intSet
	 * @return int array union of both sets
	 */
	public intSet union(intSet s1, intSet s2) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int indexFirst=0;indexFirst<s1.set.length;indexFirst++) {
			list.add(s1.set[indexFirst]);
		}
		for(int indexFirst=0;indexFirst<s2.set.length;indexFirst++) {
			if(!list.contains(s2.set[indexFirst])){
				list.add(s2.set[indexFirst]);
			}
		}
		Integer array[]=new Integer[list.size()];
		for(int indexFirst=0;indexFirst<list.size();indexFirst++) {
			array[indexFirst]=list.get(indexFirst);
		}
		return new intSet(array);		
	}
}
