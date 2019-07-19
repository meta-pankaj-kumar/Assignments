/*
 * Class to implement Linear Search on an Array
 * Methods are - 
 * 		linearSearch - returns the index at which number is found
 */
package Searching;
public class LinearSearch{
	/*
	 * @param int array in which element is to be searched
	 * @param int number to be searched
	 * @return index if element found
	 * @return -1 if not found 
	 */
	public int linearSearch(int []array,int numberToBeSearched)	{
		return searchLinear(array,0,numberToBeSearched);
	}
	/*
	 * @param int array in which element is to be searched
	 * @param int Index Value from where searching is to be started
	 * @param int number to be searched
	 * @return index if element found
	 * @return -1 if not found 
	 */
	private int searchLinear(int array[],int currentIndexValue,int noToBeSearched)	{
		if(currentIndexValue<array.length)		{
			if(array[currentIndexValue]==noToBeSearched)	{
				return currentIndexValue;
			}
			else	{
				currentIndexValue++;
				return searchLinear(array, currentIndexValue++, noToBeSearched);
			}
		}
		else	{
			return -1;
		}
	}
}