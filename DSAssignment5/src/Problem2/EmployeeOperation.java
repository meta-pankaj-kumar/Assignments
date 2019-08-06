/**
 * This class contain method to perform operation on employees
 */
package Problem2;
import java.util.LinkedList;
public class EmployeeOperation {
	LinkedList<Employee> employeeList = new LinkedList<Employee>();
	/**
	 * This method is use to add employee to employee list
	 * @param employeeobject of Employee class containing details of employee to be added
	 * @return true if added successfully else false
	 */
	public boolean addEmployee(Employee employee) {
		try {
			this.employeeList.add(employee);
			return true;
		} 
		catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
	/**
	 * This method is use to sort employee according to their salary in descending order
	 * @return LinkedList<Employee> containing all employee details
	 * @throws Exception when employee list is empty
	 */
	public LinkedList<Employee> getSortedEmployeeList() throws Exception {
		try {
			if (this.employeeList.size() == 0) {
				throw new Exception("Employee list is empty");
			}
			for (int currentEmployeeIndex = 1; currentEmployeeIndex < this.employeeList.size(); currentEmployeeIndex++) {
				int firstEmployeeIndex = 0;
				while (firstEmployeeIndex <= currentEmployeeIndex) {
					if (this.employeeList.get(firstEmployeeIndex).getEmpSalary() < this.employeeList.get(currentEmployeeIndex).getEmpSalary()) {
						arrangeEmployee(firstEmployeeIndex, currentEmployeeIndex);
					} 
					else if (this.employeeList.get(firstEmployeeIndex).getEmpSalary() == this.employeeList.get(currentEmployeeIndex).getEmpSalary()) {
						if (this.employeeList.get(firstEmployeeIndex).getEmpAge() > this.employeeList.get(currentEmployeeIndex).getEmpAge()) {
							arrangeEmployee(firstEmployeeIndex, currentEmployeeIndex);
						}
					}
					firstEmployeeIndex++;
				}
			}
			return this.employeeList;
		} 
		catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
	/**
	 * This method is used to rearrange two employee position in list
	 * @param firstEmployeeIndexindex of first employee
	 * @param secondEmployeeIndexindex of second employee
	 */
	private void arrangeEmployee(int firstEmployeeIndex, int secondEmployeeIndex) {
		try {
			Employee employee = this.employeeList.get(secondEmployeeIndex);
			this.employeeList.remove(secondEmployeeIndex);
			this.employeeList.add(firstEmployeeIndex, employee);
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
}