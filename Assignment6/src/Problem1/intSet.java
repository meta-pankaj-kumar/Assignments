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
public class intSet {
	private final int[] set;
	
	/* Parameterised Constructor of class
	 * @param int array universal Set
	 * @return null 
	 */
	public intSet(int set[]){
		this.set=set;
	}
	
	/*
	 * Getter Method for Universal Set
	 * @param Null
	 * @return int array of universal Set
	 */
	public int[] getSet() {
		return set;
	}
	
	/*
	 *@param int value for checking in the universal set
	 *@return true if element found
	 *@return false if not found 
	 */
	public boolean isMember(int x) {
		//linear Search occurring
		for(int indexValue=0;indexValue<set.length;indexValue++) {
			if(set[indexValue]==x) {
				return true;
			}
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
		boolean flag=false;
		for(int indexValue=0;indexValue<s.set.length;indexValue++) {
			for(int indexValueSecond=0;indexValueSecond<set.length;indexValueSecond++) {
				if(set[indexValueSecond]==s.set[indexValue]) {
					//if true for any value raise the flag and break out of loop
					flag=true;
					break;
				}
			}
		}
		return flag;
	}
	
	/*
	 * @param Null
	 * @return intSet of compliment Set
	 */
	public intSet getCompliment() {
		//List for adding up compliments directly
		ArrayList<Integer> list=new ArrayList<Integer>();
		int flag=0;
		for(int indexFirst=1;indexFirst<=1000;indexFirst++){
			for(int indexSecond=0;indexSecond<this.set.length;indexSecond++){
				if(this.set[indexSecond]==indexFirst){
					flag=1;
				}
			}
			if(flag==0){
				list.add(indexFirst);
			}
			flag=0;
		}
		int complimentArray[]=new int[list.size()];
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
		int flag=0;
		for(int indexFirst=0;indexFirst<s1.set.length;indexFirst++) {
			list.add(s1.set[indexFirst]);
		}
		for(int indexFirst=0;indexFirst<s2.set.length;indexFirst++) {
			for(int indexSecond=0;indexSecond<list.size();indexSecond++) {
				if(s2.set[indexFirst]==list.get(indexSecond)) {
					flag=1;
				}
			}
			if(flag==0) {
				list.add(s2.set[indexFirst]);
			}
			flag=0;
		}
		int array[]=new int[list.size()];
		for(int indexFirst=0;indexFirst<list.size();indexFirst++) {
			array[indexFirst]=list.get(indexFirst);
		}
		return new intSet(array);		
	}
}
