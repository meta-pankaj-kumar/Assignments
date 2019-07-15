/*
 * Simulator of FCFS Scheduling Algorithm 
 * consists of main method for display of desired calculated output
 * calculations that can be performed are  
 * 		CALCULATING COMPLETION TIME FOR EACH PROCESS
 * 		CALCULATING WAITING TIME FOR EACH PROCESS
 * 		CALCULATING TURN AROUND TIME FOR EACH PROCESS
 * 		AVERAGE WAITING TIME OF PROCESSES
 * 		MAXIMUM WAITING TIME PERIOD FOR A PROCESS IN QUEUE 
 */
package FCFSSimulator;
import java.util.Scanner;
public class JobScheduler 
{
	/*
	 * @param null
	 * @return null
	 * Assumption process array is entered in a sorted manner with respect to their arrival time 
	 * and if not system will sort it and give the result accordingly
	 */
	public static void main(String args[]){
		int userInput,numberOfProcesses;
		String actionPerformed="";
		double averageOrMaximumTime=0;
		Scanner in=new Scanner(System.in);
		try{
			System.out.println("Enter Total Number of Processes");
			numberOfProcesses=in.nextInt();
			int [][]process=new int[numberOfProcesses][2];
			int []a=new int[numberOfProcesses];
			//Input Arrival Time and Burst Time of each process
			for(int inputLoopingVariableFirst=0;inputLoopingVariableFirst<numberOfProcesses;inputLoopingVariableFirst++){
				for(int inputLoopingVariableSecond=0;inputLoopingVariableSecond<2;inputLoopingVariableSecond++){
					//check for if column value is 0 then it is arrival time save it accordingly
					if(inputLoopingVariableSecond==0){
						System.out.println("Enter Arrival Timeof Process "+(inputLoopingVariableFirst+1));
						process[inputLoopingVariableFirst][inputLoopingVariableSecond]=in.nextInt();
					}
					//if not then it is burst time so save it accordingly
					else{
						System.out.println("Enter Burst Timeof Process "+(inputLoopingVariableFirst+1));
						process[inputLoopingVariableFirst][inputLoopingVariableSecond]=in.nextInt();
					}
				}
			}
			//first sort the process according to their arrival time 
			process=JobSchedulerMethods.sortProcessesByArrivalTime(process);
			//runs until user wants to terminate the execution
			while(true){
				System.out.println();
				System.out.println("Input 1 for CALCULATING COMPLETION TIME FOR EACH PROCESS");
				System.out.println("Input 2 for CALCULATING WAITING TIME FOR EACH PROCESS");
				System.out.println("Input 3 for CALCULATING TURN AROUND TIME FOR EACH PROCESS");
				System.out.println("Input 4 for AVERAGE WAITING TIME OF PROCESSES");
				System.out.println("Input 5 to MAXIMUM WAITING TIME PERIOD FOR A PROCESS IN QUEUE");
				System.out.println("Input ANY OTHER KEY TO EXIT");
				userInput=in.nextInt();
				//generalized approach is used in switch to avoid again and again printing 
				//thus clubbing up similar types of cases together for similar printing pattern
				switch(userInput){
					case 1:
						a=JobSchedulerMethods.comletionTime(process);
						actionPerformed="Completion Time";
						break;
					case 2:
						a=JobSchedulerMethods.waitingTimeforEachProcess(process);
						actionPerformed="Waiting time";
						break;
					case 3:	
						a=JobSchedulerMethods.turnAroundTimeforEachProcess(process);
						actionPerformed="Turn Around Time";
						break;
					case 4:
						averageOrMaximumTime=JobSchedulerMethods.averageWaitingTimeOfProcesses(process);
						actionPerformed="Average Waiting Time = ";
						break;
					case 5:	
						averageOrMaximumTime=JobSchedulerMethods.maximumWaitingTimePeriod(process);
						actionPerformed="Maximum Waiting Time = ";
						break;
					default:
						System.out.println("Your Input was "+userInput);
						System.out.println("Simulator Exitted!");
						System.exit(0);
				}
				
				if((userInput>=1)&&(userInput<=3)){
					System.out.println("Process \t Arrival Time \t Burst Time \t "+actionPerformed);
					for(int processNumber=0;processNumber<numberOfProcesses;processNumber++){
						//printing in a tabular format
						System.out.println(processNumber+"\t\t\t"+process[processNumber][0]+"   \t\t"+process[processNumber][1]+"   \t\t"+a[processNumber]);
					}
				}
				else if((userInput==4)||(userInput==5)){
					System.out.println("Process \t Arrival Time \t Burst Time");
					for(int processNumber=0;processNumber<numberOfProcesses;processNumber++){
						//printing in a tabular format
						System.out.println(processNumber+"\t\t\t"+process[processNumber][0]+"   \t\t"+process[processNumber][1]);
					}
					System.out.println();
					System.out.println(actionPerformed+" "+averageOrMaximumTime);
				}
			}
		}
		//catch exception and handle it accordingly
		catch (Exception exception) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
	}
}