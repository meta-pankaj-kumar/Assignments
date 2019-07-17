/*
 * Class to perform certain operations on inputed Array
 * Methods
 * 		mirrorSection - To compute and return the largest mirror section's size found in the input array
 * 		clumpsCount - To compute and return the total number of clumps found in the inputed array
 * 		fixXY - To swap the values of Y such that every X is followed by a Y in the inputed array
 * 		splitArray - To compute and return the position from where array can be divided into two equal halves 
 * 						i.e. sum of left sub array is equal to sum of right sub array from the inputed array
 * Assumption Input Array will contain only positive Integers
 */
package ArrayOperations;
import java.util.ArrayList;
public class ArrOperations {
	/*
	 * @param Integer array 
	 * @return int value i.e. size of the largest mirror section found in the input array
	 * Assumption Input Array will contain only positive Integers
	 */
	public int mirrorSection(int array[])throws AssertionError	{
		int firstIndex,secondIndex,flag=0,increasingIndex,decreasingIndex,count=0,mirrorCount=0;;
		if(array.length==0) {
			throw new AssertionError("Null Array Caught in mirror section"); 
		}
		for(firstIndex=0;firstIndex<array.length;firstIndex++)	{
			for(secondIndex=firstIndex+1;secondIndex<array.length;secondIndex++)	{
				//check until compiler get two identical values
				if(array[firstIndex]==array[secondIndex])	{
					//temporary copy of both first index and second index
					increasingIndex=firstIndex;decreasingIndex=secondIndex;
					//loop until flag is raised
					while(flag==0)	{
						//check until compiler get two identical values on increasing index and decreasing index and will run 
						//till increasing index reaches its peak value i.e. array.length and for decreasing index peak value is 0
						if((increasingIndex<array.length)&&(decreasingIndex>=0)&&(array[increasingIndex]==array[decreasingIndex])){
							//if so increase count by 1 
							count++;
							//and update the values of increasing and decreasing index by 1
							increasingIndex++;decreasingIndex--;
						}
						else {
							//raise the flag to exit the checking
							flag=1;
						}
					}
					//store the max value of count and max count to max count for largest mirror
					mirrorCount=Math.max(count, mirrorCount);
					//reset count and flag to unraised
					count=0;
					flag=0;
				}
			}
		}
		return(mirrorCount);
	}
	/*
	 * @param Integer array 
	 * @return int value of total number of clumps in the input array.
	 * Assumption Input Array will contain only positive Integers
	 */
	public int clumpsCount(int array[])throws AssertionError{
		int flag=0,count=0;
		if(array.length==0) {
			throw new AssertionError("Null Array Caught in clumps count"); 
		}
		//loop till length -2 because last element cannot form a clump alone
		for(int firstIndex=0;firstIndex<array.length-1;firstIndex++){
			//initialising flag to un-raised
			flag=0;
			//check within length limit that if current value is equal to next value 
			while((firstIndex<array.length-1)&&(array[firstIndex]==array[firstIndex+1])){
				//if so increase first index to avoid double checking and set flag to raised
				firstIndex++;
				flag=1;
			}
			if(flag==1)	{
				//if flag is raised increase count by 1
				count++;
			}
		}
		/*for(int firstIndex=0;firstIndex<array.length-1;firstIndex++){
			if(array[firstIndex]==array[firstIndex+1])
			{
				flag1=1;
				flag2++;
				if(flag2==1){
					count++;flag1=0;}
			}
			else if((flag1==1)&&(flag2!=1))
			{
				flag1=0;
				count++;
			}
		}*/
		return count;
	}
	/*
	 * @param Integer array
	 * @param int value of X
	 * @param int value of Y
	 * @return Integer array after fixing XY problem
	 * Assumption Input Array will contain only positive Integers
	 */
	public int[] fixXY(int array[],int x,int y) throws AssertionError{
		if(array.length==0) {
			throw new AssertionError("Null array Caught in fix xy");
		}
		if(x==y){
			throw new AssertionError("X and Y cannot be equal");
		}
		if(array[array.length-1]==x){
			throw new AssertionError("X cannot be at last position of array");
		}
		int occurenceOfX=0,indexOfY=0;
		//array-list to store indexes of y
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int firstIndex=0;firstIndex<array.length;firstIndex++){
			//storing indexes of y
			if(array[firstIndex]==y) {
				list.add(firstIndex);
			}
			if(array[firstIndex]==x){
				occurenceOfX++;
			}
		}
		if(occurenceOfX!=list.size()) {
			throw new AssertionError("Number of X and Y are not equal");
		}
		for(int firstIndex=0;firstIndex<array.length;firstIndex++){
			//as soon as x matches
			if(array[firstIndex]==x){
				//swap values of next index of x and indexes of y stored in arraylist
				array[list.get(indexOfY)]=array[firstIndex+1];
				array[firstIndex+1]=y;
				//then increase the current arraylist pointer
				indexOfY++;
			}
		}
		return array;
	}
	/*
	 * @param Integer array
	 * @return int value from where the array can be splitted
	 * @return -1 if it could not be splitted
	 * Assumption Input Array will contain only positive Integers
	 */
	public int splitArray(int array[])throws AssertionError{
		int summationOfLeftSubArray=0,summationOfRightSubArray=0;
		if(array.length==0) {
				throw new AssertionError();
		}
		for(int indexFirst=0;indexFirst<array.length;indexFirst++)	{
			//summing up left sub array which runs from 0 to firstIndex-1
			for(int secondIndex=0;secondIndex<indexFirst;secondIndex++)		{
				summationOfLeftSubArray+=array[secondIndex];
			}
			//summing up right sub array which runs from firstIndex to length
			for(int secondIndex=indexFirst;secondIndex<array.length;secondIndex++){
				summationOfRightSubArray+=array[secondIndex];
			}
			//if left sub array summation and right sub array are equal then return current Index
			if(summationOfLeftSubArray==summationOfRightSubArray) {
				return indexFirst;	
			}
			//if not re initialise the sub arrays by 0
			summationOfLeftSubArray=0;
			summationOfRightSubArray=0;
		}
		//compiler will reach here only if no such index is there for dividing then return -1
		return -1;
	}
}
