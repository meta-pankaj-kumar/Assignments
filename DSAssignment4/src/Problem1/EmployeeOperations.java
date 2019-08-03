/**
 * Employee Operations for Non Unique Employees
 * Methods
 * 		addEmployee - add Employee to list
 * 		employeeSortNaturalOrder - sort by natural order
 * 		employeeSortByName - sort employee by name
 */
package Problem1;
import java.util.ArrayList;
import java.util.Collections;
public class EmployeeOperations {
	private ArrayList<Employee> employeeList;
	public EmployeeOperations(){
		this.employeeList=new ArrayList<Employee>();
	}
	/**
	 * @param Employee type employee
	 * @return boolean true after addition
	 */
	public boolean addEmployee(Employee employee){
		employeeList.add(employee);
		return true;
	}
	/**
	 * @param null
	 * @return ArrayList of Employees
	 */
	public ArrayList<Employee> employeeSortNaturalOrder(){
		EmployeeSortNaturalOrder sort=new EmployeeSortNaturalOrder(employeeList);
		return sort.sort();
	}
	/**
	 * @param null
	 * @return ArrayList of Employees
	 */
	public ArrayList<Employee> employeeSortByName(){
		EmployeeSortByName sort=new EmployeeSortByName();
		Collections.sort(this.employeeList,sort);
		return this.employeeList;
	}
}