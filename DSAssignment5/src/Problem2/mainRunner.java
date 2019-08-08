package Problem2;

import java.util.LinkedList;
import java.io.*;

public class mainRunner {

	public static void main(String[] args) throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		EmployeeOperation empObject=new EmployeeOperation();
		while(true){
			try{
				System.out.println("Enter 1 for Adding Employees to Collections");
				System.out.println("Enter 2 for Sorted Employee List");
				int choice=Integer.parseInt(in.readLine());
				switch(choice){
					case 1:
						System.out.println("Enter employee Id of employee");
						int id=Integer.parseInt(in.readLine());
						System.out.println("Enter name employee");
						String name=in.readLine();
						System.out.println("Enter address of employee");
						String address=in.readLine();
						System.out.println("Enter salary of employee");
						double salary=Double.parseDouble(in.readLine());
						System.out.println("Enter age of employee");
						double age=Double.parseDouble(in.readLine());
						empObject.addEmployee(new Employee(id, name, address,salary,age));
						System.out.println("Employee added to Collection");
						break;
					case 2:{
						LinkedList<Employee> list=empObject.getSortedEmployeeList();
						if(list.size()==0){
							throw new Exception("No Employee added to Collections");
						}
						System.out.println("List after sorting is");
						System.out.println("EMP ID \t\t Name \t\t Address \t\t Salary \t\t Age");
						for(int index=0;index<list.size();index++){
							System.out.println(list.get(index).getEmpId()+" \t\t "+list.get(index).getEmpName()+" \t\t "+list.get(index).getEmpAdress()+" \t\t "+list.get(index).getEmpSalary()+" \t\t "+list.get(index).getEmpAge());
						}
						break;
					}
					default:
						throw new Exception("Invalid Input");
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
}