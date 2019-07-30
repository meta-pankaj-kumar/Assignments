/*
 * Main Class for implementing Rotation
 */
package Rotation;
import java.util.LinkedList;
import java.util.Scanner;
public class MainRunner {
	/*
	 * @param null
	 * @return null
	 */
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		try{
			System.out.println("Enter 1 for Rotation of List");
			if(in.nextInt()==1){
				LinkedList<Integer> list=new LinkedList<Integer>();
				System.out.println("Enter Number of Elements in List");
				int numberOfElemnts=in.nextInt();
				System.out.println("Enter elements of list seperated by space");
				for(int indexFirst=0;indexFirst<numberOfElemnts;indexFirst++){
					list.add(in.nextInt());
				}
				
				System.out.println("Enter Left Index");
				int leftIndex=in.nextInt();
				if(leftIndex<0){
					System.out.println("Left Index cannot be less than 0");
					System.exit(0);
				}
				
				System.out.println("Enter Right Index");
				int rightIndex=in.nextInt();
				if(rightIndex<0){
					System.out.println("Right Index cannot be less than 0");
					System.exit(0);
				}
				if(rightIndex==leftIndex){
					System.out.println("Right and Left Index cannot be equal");
					System.exit(0);
				}
				
				System.out.println("Enter Number of Rotations");
				int rotations=in.nextInt();
				if(rotations<0){
					System.out.println("Rotations Index cannot be less than 0");
					System.exit(0);
				}
				
				System.out.println();
				Rotation rotate=new Rotation();
				LinkedList<Integer> result=rotate.rotateClockWise(list, leftIndex, rightIndex, rotations);
				System.out.println("List after Rotation is -------");
				for(int i=0;i<result.size();i++){
					System.out.print(result.get(i)+" ");
				}
			}
			else{
				System.out.println("Wrong Choice");
			}
			in.close();
		}
		//exception Handling
		catch(Exception e){
			System.out.println("Wrong Choice !!!!!!");
		}
	}
}