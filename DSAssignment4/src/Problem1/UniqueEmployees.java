/**
 * Class for Unique Employees
 * Methods 
 * 		addEmployee - Adds Unique Employee to Existing Collection
 */
package Problem1;
import java.util.HashMap;
public class UniqueEmployees {
	private HashMap<String,Employee> employeeMap;
	public UniqueEmployees(){
		this.employeeMap=new HashMap<String,Employee>();
	}
	/**
	 * @param Employee type employee
	 * @return true after Addition of Employee
	 */
	public boolean addEmployee(Employee employee){
		boolean flag=false;
		if(!this.employeeMap.containsKey(employee.getEMPID())){
			this.employeeMap.put(employee.getEMPID(),employee);
			flag=true;
		}
		return flag;
	}
	/**
	 * @return ArrayList of employees
	 */
	public HashMap<String,Employee> display(){
		return this.employeeMap;
	}
}