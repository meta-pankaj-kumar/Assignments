/**
 * Class for natural Order Sorting
 * Methods 
 * 		sort - returns Sorted List
 */
package Problem1;
import java.util.ArrayList;
import java.util.Collections;
public class EmployeeSortNaturalOrder {
	private ArrayList<Employee> list;
	public EmployeeSortNaturalOrder(ArrayList<Employee> list){
		this.list=list;
	}
	/**
	 * @param null
	 * @return ArrayList aster Sorting
	 */
	public ArrayList<Employee> sort(){
		Collections.sort(this.list);
		return this.list;
	}
}