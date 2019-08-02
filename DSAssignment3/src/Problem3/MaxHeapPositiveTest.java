/*
 * Positive test cases of Max Heap operating under Junit 4
 */
package Problem3;
import static org.junit.Assert.*;
import org.junit.Test;
public class MaxHeapPositiveTest {

	@Test
	public void testInsertNode() {
		MaxHeap heap =new MaxHeap(3);
		assertTrue(heap.insertNode(new Object("Hello",3)));
		assertTrue(heap.insertNode(new Object("Hiii",1)));
		assertTrue(heap.insertNode(new Object("Whats up",2)));
	}

	@Test
	public void testDeleteNode() {
		MaxHeap heap =new MaxHeap(3);
		assertTrue(heap.insertNode(new Object("Hello",3)));
		assertTrue(heap.insertNode(new Object("Hiii",1)));
		assertTrue(heap.insertNode(new Object("Whats up",2)));
		
		Object object=heap.deleteNode();
		assertEquals("Hello",object.getValue());
	}

	@Test
	public void testCheckIfAllElmentsAreZero() {
		MaxHeap heap =new MaxHeap(3);		
		assertTrue(heap.checkIfAllElmentsAreZero());
	}
}