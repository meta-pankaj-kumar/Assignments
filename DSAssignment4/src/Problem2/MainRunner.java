/**
 * Main Class implementing String cache memory
 */
package Problem2;
import java.util.*;
public class MainRunner {
	/**
	 * @param null
	 * @return null
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		StringCache cache=new StringCache();
		while(true){
			System.out.println("Enter 1 for getting Unique characters of a String");
			if(in.nextInt()==1){
				in.nextLine();
				System.out.println("Enter a String");
				System.out.println("Number of Unique Characters = "+cache.getLengthOfUniqueCharacters(in.nextLine()));
			}
			else{
				System.out.println("Wrong Choice");
			}
		}
	}
}