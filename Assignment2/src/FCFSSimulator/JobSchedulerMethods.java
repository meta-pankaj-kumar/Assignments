/*
 * JobSchedulerMethods consist of following methods
 * sortProcessByArrivalTime - for sorting processes according to their arrival time
 * competionTime - for calculating completion time of each process
 * waitingTimeforEachProces - for calculating waiting time of each process
 * turnAroundTimeforEachProcess - for calculating turn around time for each process
 * averageWaitingTimeOfProcesses - for calculating average waiting time of all processes
 * maximumWaitingTimePeriod - for calculating maximum waiting time of all processes
 */
package FCFSSimulator;
public class JobSchedulerMethods{
	/*
	 * @param Integer type double dimensional array comprising of arrival time and burst time for each process
	 * @return Integer type double dimensional array after sorting processes with respect to there arrival time
	 * Assumption sorted Process array by arrival time
	 */
	public static int[][] sortProcessesByArrivalTime(int process[][]){
		//simple technique of bubble sorting according to arrival time of the process
		//if the arrival time of next process in the array is smaller than the current process then they both are swapped 
		//after swapping same happens till last of the loop and 
		//thus after first iteration of inner loop the process with minimum arrival time comes on first Index number
		//and every time second loop is made to start form next position that contains minimum value   
		for(int loopingValueFirst=0;loopingValueFirst<process.length;loopingValueFirst++){
			for(int loopingValueSecond=loopingValueFirst+1;loopingValueSecond<process.length;loopingValueSecond++){
				if(process[loopingValueSecond][0]<=process[loopingValueFirst][0]){
					//for swapping first save current value of first process to a temporary variable
					//two variables are used here for storing both arrival time and burst time differently
					int tempArrivalTime=process[loopingValueFirst][0];
					int tempBurstTime=process[loopingValueFirst][1];
					//then overwrite the values of first process by values of second process
					process[loopingValueFirst][0]=process[loopingValueSecond][0];
					process[loopingValueFirst][1]=process[loopingValueSecond][1];
					//then overwrite the value of second process by values of temporary variables
					process[loopingValueSecond][0]=tempArrivalTime;
					process[loopingValueSecond][1]=tempBurstTime;
				}
			}
		}
		//finally returning sorted process array
		return process;
	}
	/*
	 * @param Integer type double dimensional array comprising of arrival time and burst time for each process
	 * @return Integer type single dimensional array comprising of completion time for each process in a sorted manner
	 * Assumption sorted Process array by arrival time
	 */
	public static int[] comletionTime(int process[][]){
		//first sort the process according to their arrival time 
		process=JobSchedulerMethods.sortProcessesByArrivalTime(process);
		int completionTime[]=new int[process.length];
		//making a current time counter
		int currentTime=0;
		for(int loopingVariable=0;loopingVariable<process.length;loopingVariable++){
			//if process has arrived earlier than current time then completion time = current time + burst time of that process  
			if(process[loopingVariable][0]<=currentTime){
				completionTime[loopingVariable]=currentTime+process[loopingVariable][1];
			}
			else {
				//if not so then completion time = arrival time of that process + completion time of that process
				completionTime[loopingVariable]=process[loopingVariable][0]+process[loopingVariable][1];
			}
			//increase current timer by completion time of current process
			currentTime=completionTime[loopingVariable];
		}
		//finally returning array of completion time
		return completionTime;
	}
	/*
	 * @param Integer type double dimensional array comprising of arrival time and burst time for each process
	 * @return Integer type single dimensional array comprising of waiting time for each process in a sorted manner
	 * Assumption sorted Process array by arrival time
	 */
	public static int[] waitingTimeforEachProcess(int process[][]){
		//first sort the process according to their arrival time 
		process=JobSchedulerMethods.sortProcessesByArrivalTime(process);
		int completionTimeArray[]=comletionTime(process);
		int waitingTimeArray[]=new int[process.length];
		for(int loopingVariable=0;loopingVariable<process.length;loopingVariable++){
			//waiting time of first process which will execute will always be zero
			if(loopingVariable==0){
				waitingTimeArray[loopingVariable]=0;
			}
			else{
				//if completion time of last process is either equal or greater than the arrival time of current process 
				//then waiting time would be difference of completion time of last process and arrival time of current process
				if(completionTimeArray[loopingVariable-1]>=process[loopingVariable][0]){
					waitingTimeArray[loopingVariable]=completionTimeArray[loopingVariable-1]-process[loopingVariable][0];
				}
				else{
					//if not so which means that the current process will arrive after completion of previous process so its waiting time is zero  
					waitingTimeArray[loopingVariable]=0;
				}
			}
		}
		//returning array of waiting time in sorted manner
		return waitingTimeArray;
	}
	/*
	 * @param Integer type double dimensional array comprising of arrival time and burst time for each process
	 * @return Integer type single dimensional array comprising of turn around time for each process in a sorted manner
	 * Assumption sorted Process array by arrival time
	 */
	public static int[] turnAroundTimeforEachProcess(int process[][]){
		//first sort the process according to their arrival time 
		process=JobSchedulerMethods.sortProcessesByArrivalTime(process);
		int completionTimeArray[]=comletionTime(process);
		int turnAroundTimeArray[]=new int[process.length];
		for(int loopingVariable=0;loopingVariable<process.length;loopingVariable++){
			//turn around time = completion time of current process - arrival time of current process 
			turnAroundTimeArray[loopingVariable]=completionTimeArray[loopingVariable]-process[loopingVariable][0];
		}
		//returning array of turn around time in sorted manner
		return turnAroundTimeArray;
	}
	/*
	 * @param Integer type double dimensional array comprising of arrival time and burst time for each process
	 * @return average waiting type for each process in double type
	 * Assumption sorted Process array by arrival time
	 */
	public static double averageWaitingTimeOfProcesses(int process[][]){
		//first sort the process according to their arrival time 
		process=JobSchedulerMethods.sortProcessesByArrivalTime(process);
		int waitingTimeForEachProcess[]=waitingTimeforEachProcess(process);
		int totalWaitingTime=0;
		for(int loopingVariable=0;loopingVariable<process.length;loopingVariable++){
			//add waiting time of each process
			totalWaitingTime+=waitingTimeForEachProcess[loopingVariable];
		}
		//Calculate average waiting time 
		return (totalWaitingTime/process.length);
	}
	/*
	 * @param Integer type double dimensional array comprising of arrival time and burst time for each process
	 * @return Integer type value of maximum waiting time of a process amongst all processes
	 * Assumption sorted Process array by arrival time
	 */
	public static int maximumWaitingTimePeriod(int process[][]){
		//first sort the process according to their arrival time 
		process=JobSchedulerMethods.sortProcessesByArrivalTime(process);
		int waitingTimeForEachProcess[]=waitingTimeforEachProcess(process);
		//take max waiting time to be zero by default as it is the least possible value
		int maxWaitingTime=0;
		for(int loopingVariable=0;loopingVariable<process.length;loopingVariable++){
			//if waiting time for a process is more than till now encountered value of maxWaitingTime 
			//then change the value of maxWaitingTime to the waiting time of current process
			if(maxWaitingTime<waitingTimeForEachProcess[loopingVariable]){
				maxWaitingTime=waitingTimeForEachProcess[loopingVariable];
			}
		}
		//return maximum waiting time thus calculated
		return (maxWaitingTime);
	}	
}