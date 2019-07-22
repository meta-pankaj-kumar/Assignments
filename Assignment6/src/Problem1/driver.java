/*
 * Main Class for checking working of intSet class
 * Methods 
 * 		main - Main Method
 * 		subSetInput - For inputting Subset
 * 		inputSet - For inputting Set
 */
package Problem1;
import java.util.Scanner;
import Problem1.intSet;
public class driver {
	static Scanner in=new Scanner(System.in);
	/*
	 * @param Null
	 * @return Null
	 */
	public static void main(String args[]) {
		try {
			//runs until user terminates
			while(true) {
				System.out.println("Enter 1 for Checking if a particular Number is a part of  set or not");
				System.out.println("Enter 2 for Size of Set");
				System.out.println("Enter 3 for Checking whether a set is a proper Subset of  Set or Not");
				System.out.println("Enter 4 for Getting Compliment Set of a Set");
				System.out.println("Enter 5 for Union of two sets");
				int userInput=in.nextInt();
				switch(userInput) {
					case 1:
						int set[]=driver.inputSet();
						System.out.println("Enter number to be checked result will be in either True or False");
						int number=in.nextInt();
						intSet setObject=new intSet(set);
						System.out.println(setObject.isMember(number));
						break;
					case 2:
						int setSecond[]=driver.inputSet();
						intSet setObjectSize=new intSet(setSecond);
						System.out.println("Size of  Set = "+setObjectSize.size());
						break;
					case 3:	
						System.out.println("Enter Universal Set");
						intSet setObjectUnivSet=new intSet(driver.inputSet());
						intSet subSet=new intSet(driver.subSetInput());
						System.out.println("System will print True is it is a proper subset otherwise false");
						System.out.println(setObjectUnivSet.isSubSet(subSet));
						break;
					case 4:
						int a[]=driver.inputSet();
						intSet setObjectCompliment=new intSet(a);
						intSet result=setObjectCompliment.getCompliment();
						System.out.println("Compliment Set is ---");
						int resultant[]=result.getSet();
						System.out.print(resultant[0]);
						for(int indexValue=1;indexValue<resultant.length;indexValue++) {
							System.out.print(" , "+resultant[indexValue]);
						}
						System.out.println();
						break;
					case 5:
						System.out.println("Input Contents of Set 1");
						intSet setFirstUnion=new intSet(driver.subSetInput());
						System.out.println("Input Contents of Set 2");
						intSet setSecondUnion=new intSet(driver.subSetInput());
						intSet resultUnion=setFirstUnion.union(setFirstUnion, setSecondUnion);
						System.out.print(resultUnion.getSet()[0]);
						for(int indexValue=1;indexValue<resultUnion.size();indexValue++) {
							System.out.print(" , "+resultUnion.getSet()[indexValue]);
						}
						System.out.println();
						break;
					default:
						System.out.println("Your Input was "+userInput);
						System.out.println("SET OPERATIONS ABORTED!!!");
						System.exit(0);
				}
			}
		}
		//Exception Handling
		catch(Exception e)	{
			System.out.println(e);
			System.out.println("SET OPERATIONS ABORTED!!!");
			System.exit(0);
		}
	}
	/*
	 * @param null
	 * @return int array of inputed set
	 */
	public static int[] inputSet()	{
		System.out.println("Enter Range of Set i.e. number of values set contains");
		int set[]=new int[in.nextInt()];
		for(int indexValue=0;indexValue<set.length;indexValue++) {
			System.out.println("Enter Value "+(indexValue+1)+" of Set");
			set[indexValue]=in.nextInt();
		}
		return set;
	}
	/*
	 * @param null
	 * @return int array of inputed subset
	 */
	public static int[] subSetInput()	{
		System.out.println("Enter number of elements set Contains");
		int set[]=new int[in.nextInt()];
		for(int indexValue=0;indexValue<set.length;indexValue++) {
			System.out.println("Enter Value "+(indexValue+1)+" of Subset");
			set[indexValue]=in.nextInt();
		}
		return set;
	}
}
