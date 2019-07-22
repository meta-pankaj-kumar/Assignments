/*
 * Main Class for checking working of Sparse class
 * Methods 
 * 		main - Main Method
 * 		inputMatrix - to input matrix
 * 		display - to display it back to user
 */
package Problem1;
import java.util.Scanner;
public class SparseDriver {
	/*
	 * @param Null
	 * @return null
	 */
	static Scanner in=new Scanner(System.in);
	public static void main(String args[])	{
		try {
			//user controlled loop
			while(true) {
				System.out.println("Enter 1 for getting transpose");
				System.out.println("Enter 2 for checking if it is Symmetric");
				System.out.println("Enter 3 for adding two sparse matrices");
				System.out.println("Enter 4 for multiplying two sparse matrix");
				int userInput=in.nextInt();
				switch(userInput) {
					case 1:
						int matTranspose[][]=SparseDriver.inputMatrix();
						sparse matrixTranspose=new sparse(matTranspose);
						sparse transposeResult=matrixTranspose.transpose();
						SparseDriver.display(transposeResult.getMatrix());
						break;
					case 2:
						int matSymmetric[][]=SparseDriver.inputMatrix();
						sparse matrixSymmetric=new sparse(matSymmetric);
						System.out.println("Result will be true if symmetric else false");
						System.out.println("Symmetric - "+matrixSymmetric.symmetric());
						break;
					case 3:	
						System.out.println("Enter Contents of First Matrix");
						int matAddFirst[][]=SparseDriver.inputMatrix();
						System.out.println("Enter Contents of Second Matrix");
						int matAddSecond[][]=SparseDriver.inputMatrix();
						sparse matrixAddFirst=new sparse(matAddFirst);
						sparse matrixAddSecond=new sparse(matAddSecond);
						sparse addResult=matrixAddFirst.addMatrix(matrixAddSecond);
						SparseDriver.display(addResult.getMatrix());
						break;
					case 4:
						System.out.println("Enter Contents of First Matrix");
						int matMulFirst[][]=SparseDriver.inputMatrix();
						System.out.println("Enter Contents of Second Matrix");
						int matMulSecond[][]=SparseDriver.inputMatrix();
						sparse matrixMulFirst=new sparse(matMulFirst);
						sparse matrixMulSecond=new sparse(matMulSecond);
						sparse mulResult=matrixMulFirst.multiplyMatrix(matrixMulSecond);
						SparseDriver.display(mulResult.getMatrix());
						break;
					default:
						System.out.println("Your Input was "+userInput);
						System.out.println("MATRIX OPERATIONS ABORTED!!!");
						System.exit(0);
				}
			}
		}
		//exception handling
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("MATRIX OPERATIONS ABORTED!!!");
			System.exit(0);
		}
	}
	/*
	 * @param null
	 * @return int double dimensional Array
	 */
	public static int[][] inputMatrix() {
		System.out.println("Enter size of Sparse Matrix");
		System.out.println("Enter Total Number of Rows");
		int rowSize=in.nextInt();
		System.out.println("Enter Total Number of Columns");
		int columnSize=in.nextInt();
		if(rowSize<0 || columnSize<0 || (rowSize==0 && columnSize==0) ) {
			System.out.println("Invalid Size");
			System.exit(0);
		}
		int matrix[][]=new int [rowSize][columnSize];
		for(int indexNumberFirst=0;indexNumberFirst<matrix.length;indexNumberFirst++) {
			for(int indexNumberSecond=0;indexNumberSecond<matrix.length;indexNumberSecond++) {
				System.out.println("Value at "+indexNumberFirst+" "+indexNumberSecond+" index = ");
				matrix[indexNumberFirst][indexNumberSecond]=in.nextInt();
			}
		}
		return matrix;
	}
	/*
	 * @param int double dimensional Array
	 * @return null
	 */
	public static void display(int[][] result) {
		
		for(int indexFirst=0;indexFirst<result.length;indexFirst++) {
			for(int indexSecond=0;indexSecond<result[0].length;indexSecond++) {
				System.out.print(result[indexFirst][indexSecond]+"\t");
			}
			System.out.println();
		}
	}
}
