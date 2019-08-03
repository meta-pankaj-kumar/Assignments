/**
 * Class Employee
 * Methods
 * 		getEMPID - returns employee id
 * 		getName - returns name
 * 		getAddress - returns address
 * 		compareTo - overrided method for Comparable
 */
package Problem1;
public class Employee implements Comparable<Employee>{
	private final String EMPID;
	private final String name;
	private final String address;
	/**
	 * @param EMPID String type employee id
	 * @param name String type employee name
	 * @param address String type employee address
	 */
	public Employee(String EMPID,String name,String address){
		this.EMPID=EMPID;
		this.name=name;
		this.address=address;
	}
	/**
	 * @return String type Employee Id
	 */
	public String getEMPID() {
		return EMPID;
	}
	/**
	 * @return String type employee name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return String type employee address
	 */
	public String getAddress() {
		return address;
	}
	
	@Override
	public int compareTo(Employee object) {
		return this.getEMPID().compareTo(object.getEMPID());
	}
}