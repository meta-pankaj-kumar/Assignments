/*
 * Test class operating under JUnit 4
 * This class tests for Positive as well as negative test cases of Sparse Matrix based in sparse.java in Problem1 Package
 */ 
package Problem1;
import static org.junit.Assert.*;
import org.junit.Test;
public class sparseTest {
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testGetMatrix() {
		int[][] array1 = new int[][] {{0,0,1},{0,2,0},{1,0,3}};
		sparse matrix1 = new sparse(array1);		
		int[][] actualArray = matrix1.getMatrix();
		assertArrayEquals(array1,actualArray);
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testMultiplyMatrix() throws Exception {
		int[][] array1 = new int[][] {{0,0,1},{0,2,0},{1,0,3}};
		sparse matrix1 = new sparse(array1);		
		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		sparse matrix2 = new sparse(array2);
		int[][] expectedMultiplication1 = new int[][] {{3,0,0},{4,0,0},{10,0,0}};
		int[][] actualMultiplication1 = matrix1.multiplyMatrix(matrix2).getMatrix();
		assertArrayEquals(expectedMultiplication1,actualMultiplication1);
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testTranspose() {
		int[][] array1 = new int[][] {{0,0,1},{0,0,2},{0,0,3}};
		sparse matrix1 = new sparse(array1);
		int[][] expectedTranspose1 = new int[][] {{0,0,0},{0,0,0},{1,2,3}};
		int[][] actualTranspose1 = matrix1.transpose().getMatrix();
		assertArrayEquals(expectedTranspose1,actualTranspose1);

		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		sparse matrix2 = new sparse(array2);
		int[][] expectedTranspose2 = new int[][] {{1,2,3},{0,0,0},{0,0,0}};
		int[][] actualTranspose2 = matrix2.transpose().getMatrix();
		assertArrayEquals(expectedTranspose2,actualTranspose2);
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive as well as negative test cases
	 */
	@Test
	public void testSymmetric() {
		int[][] array1 = new int[][] {{0,0,1},{0,2,0},{1,0,3}};
		sparse matrix1 = new sparse(array1);
		assertTrue(matrix1.symmetric());
		
		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		sparse matrix2 = new sparse(array2);
		assertFalse(matrix2.symmetric());
	}
	/*
	 * @param Null
	 * @return Null
	 * Testing for positive test cases
	 */
	@Test
	public void testAdd() {
		int[][] array1 = new int[][] {{0,0,1},{0,2,0},{1,0,3}};
		sparse matrix1 = new sparse(array1);		
		int[][] array2 = new int[][] {{1,0,0},{2,0,0},{3,0,0}};
		sparse matrix2 = new sparse(array2);
		int[][] expectedAddition1 = new int[][] {{1,0,1},{2,2,0},{4,0,3}};
		int[][] actualAddition1 = matrix1.addMatrix(matrix2).getMatrix();
		assertArrayEquals(expectedAddition1,actualAddition1);
	}
}