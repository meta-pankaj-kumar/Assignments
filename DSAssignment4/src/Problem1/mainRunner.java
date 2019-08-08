package Problem1;

import java.util.ArrayList;
import java.util.Scanner;

public class mainRunner {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		EmployeeOperations empObject=new EmployeeOperations();
		while(true){
			try{
				System.out.println("Enter 1 for Adding Employees to Collections");
				System.out.println("Enter 2 for Viewing All Employees");
				System.out.println("Enter 3 for Natural Order Sorting");
				System.out.println("Enter 4 for Sorting by Name");
				int choice=in.nextInt();
				in.nextLine();
				switch(choice){
					case 1:
						
						System.out.println("Enter employee Id of employee");
						String id=in.nextLine();
						System.out.println("Enter name employee");
						String name=in.nextLine();
						System.out.println("Enter address of employee");
						String address=in.nextLine();
						empObject.addEmployee(new Employee(id, name, address));
						System.out.println("Employee added to Collection");
						break;
					case 2:{
						ArrayList<Employee> list=empObject.display();
						if(list.size()==0){
							throw new Exception("No Employee added to Collections");
						}
						System.out.println("Emp Id \t\t Emp Name \t\t Emp Address");
						for(int index=0;index<list.size();index++){
							System.out.println(list.get(index).getEMPID()+" \t\t "+list.get(index).getName()+" \t\t\t "+list.get(index).getAddress());
						}
						break;
					}
					case 3:{
						ArrayList<Employee> list=empObject.employeeSortNaturalOrder();
						if(list.size()==0){
							throw new Exception("No Employee added to Collections");
						}
						System.out.println("List after sorting is");
						for(int index=0;index<list.size();index++){
							System.out.println(list.get(index).getEMPID()+" \t\t "+list.get(index).getName()+" \t\t "+list.get(index).getAddress());
						}
						break;
					}
					case 4:
					{
						ArrayList<Employee> list=empObject.employeeSortByName();
						if(list.size()==0){
							throw new Exception("No Employee added to Collections");
						}
						System.out.println("List after sorting is");
						for(int index=0;index<list.size();index++){
							System.out.println(list.get(index).getEMPID()+" \t\t "+list.get(index).getName()+" \t\t "+list.get(index).getAddress());
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