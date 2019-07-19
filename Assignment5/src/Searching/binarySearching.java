package Searching;

/**
 * This class contain method to perform binary search on integer array
 */
public class binarySearching {
	/*
	 * @param inputArray array of elements
	 * @param elementToSearch element to be searched
	 * @return index of element if found otherwise -1
	 * Search element in an array using binary search
	 * Assuming array is in ascending order
	 */
	public int getElementIndexByBinarySearch(int inputArray[],int elementToSearch){
		int elementIndex = binarySearch(inputArray,elementToSearch,0,(inputArray.length-1));
		return elementIndex;
	}
	/*
	 * @param inputArray array of element
	 * @param elementToSearch element to be searched
	 * @param startIndex start index of sub array
	 * @param endIndex end index of sub array
	 * @return index of element otherwise -1
	 * This is recursive method for used in getElementByBinarySearch method
	 */
	private int binarySearch(int inputArray[], int elementToSearch, int startIndex , int endIndex){
		if(startIndex > endIndex){ 
			return -1; 
			}
		int middleIndex = (startIndex + endIndex) / 2;
		if(inputArray[middleIndex] == elementToSearch){ 
			return middleIndex; 
			}
		if(elementToSearch > inputArray[middleIndex]){
			return binarySearch(inputArray,elementToSearch,middleIndex+1,endIndex);
		}

		return binarySearch(inputArray,elementToSearch,startIndex,middleIndex-1);
	}
}