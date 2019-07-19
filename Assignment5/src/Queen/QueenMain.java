/*
 * Tester Main Class for testing queen.java
 */
package Queen;
public class QueenMain {
	public static void main(String[] args) {
		queen obje=new queen();
		int base=14;
		String b[][]=obje.nQueenSolver(base);
		for(int indexFirst=0;indexFirst<base;indexFirst++)		{
			for(int indexSecond=0;indexSecond<base;indexSecond++)	{
				System.out.print(b[indexFirst][indexSecond]+" , ");
			}
			System.out.println();
		}
	}
}
