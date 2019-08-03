/**
 * Sorting Class for employee by name
 */
package Problem1;
import java.util.Comparator;
public class EmployeeSortByName implements Comparator<Employee>{
	/**
	 * @param Employee Object1
	 * @param Employee Object2
	 * @return Compared result
	 */
	@Override
	public int compare(Employee object1, Employee object2) {
		return object1.getName().compareTo(object2.getName());
	}
}