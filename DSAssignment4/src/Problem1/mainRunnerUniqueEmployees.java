package Problem1;

import java.util.HashMap;
import java.util.Scanner;

public class mainRunnerUniqueEmployees {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		UniqueEmployees empObject=new UniqueEmployees();
		while(true){
			try{
				System.out.println("Enter 1 for Adding Employees to Collections");
				System.out.println("Enter 2 for Viewing All Employees");
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
						if(empObject.addEmployee(new Employee(id, name, address))){						
							System.out.println("Employee added to Collection");
						}
						else {
							throw new Exception("An Employee with same Emp Id is already present");
						}
						break;
					case 2:{
						HashMap<String,Employee> map=empObject.display();
						if(map.size()==0){
							throw new Exception("No Employee added to Collections");
						}
						System.out.println("Emp Id \t\t Emp Name \t\t Emp Address");
						Object[] array=map.keySet().toArray();
						for(int index=0;index<map.size();index++){
							System.out.println(map.get(array[index]).getEMPID()+" \t\t "+map.get(array[index]).getName()+" \t\t "+map.get(array[index]).getAddress());
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