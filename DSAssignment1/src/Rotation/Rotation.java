/*
 * Class for linked list Rotation
 * Methods - 
 * 		rotateClockWise - rotates list clockwise
 */
package Rotation;
import java.util.*;
public class Rotation {
	/*
	 * @param Linked List of Integer type
	 * @param int type left index
	 * @param int type right index
	 * @param int type number of rotations
	 * @return Linked List of Integer type
	 */
	public LinkedList<Integer> rotateClockWise(LinkedList<Integer> list,int leftIndex,int rightIndex, int numberOfRotation){		
		LinkedList<Integer> cloneList = new LinkedList<Integer>();
		cloneList =(LinkedList<Integer>) list.clone();
		leftIndex--;
		rightIndex--;
		while(numberOfRotation >0){
			int valueAtLeftIndex = cloneList.get(leftIndex);
			cloneList.remove(leftIndex);
			cloneList.add(rightIndex, valueAtLeftIndex);
			numberOfRotation--;
		}
		return cloneList;
	}
}