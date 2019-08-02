/*
 * Negative test cases of Max Heap operating under Junit 4
 */
package Problem3;
import static org.junit.Assert.*;
import org.junit.Test;
public class MaxHeapNegativeTest {

	@Test(expected = Exception.class)
	public void testInsertNode() {
		MaxHeap heap =new MaxHeap(3);
		assertTrue(heap.insertNode(new Object("Hello",3)));
		assertTrue(heap.insertNode(new Object("Hiii",1)));
		assertTrue(heap.insertNode(new Object("Whats up",2)));
		assertTrue(heap.insertNode(new Object("Whats up",2)));
	}

	@Test(expected = Exception.class)
	public void testDeleteNode() {
		MaxHeap heap =new MaxHeap(1);
		
		heap.deleteNode();	
	}

	@Test
	public void testCheckIfAllElmentsAreZero() {
		MaxHeap heap =new MaxHeap(3);	
		assertTrue(heap.insertNode(new Object("Hello",3)));
		assertFalse(heap.checkIfAllElmentsAreZero());
	}
}