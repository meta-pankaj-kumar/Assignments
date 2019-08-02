/*
 * Negative test cases of priority queue Operating under JUnit 4
 */
package Problem2;
import static org.junit.Assert.*;
import org.junit.Test;
public class PriorityQueueNegativeTest {

	@Test(expected = Exception.class)
	public void testEnQueue() throws Exception {
		PriorityQueue queue=new PriorityQueue(5);
		assertTrue(queue.enQueue(1,10));
		assertTrue(queue.enQueue(2,11));
		assertTrue(queue.enQueue(3,12));
		assertTrue(queue.enQueue(4,13));
		assertTrue(queue.enQueue(5,14));
		
		queue.enQueue(6,15);
	}

	@Test(expected = Exception.class)
	public void testDeQueue() throws Exception {
		PriorityQueue queue=new PriorityQueue(5);
		assertTrue(queue.enQueue(1,10));
		assertTrue(queue.enQueue(2,11));
		assertTrue(queue.enQueue(3,12));
		assertTrue(queue.enQueue(4,13));
		assertTrue(queue.enQueue(5,14));
		
		assertEquals(5,queue.deQueue());
		assertEquals(4,queue.deQueue());
		assertEquals(3,queue.deQueue());
		assertEquals(2,queue.deQueue());
		assertEquals(1,queue.deQueue());
		
		queue.deQueue();
	}

	@Test
	public void testIsQueueEmpty() throws Exception {
		PriorityQueue queue=new PriorityQueue(1);
		assertTrue(queue.enQueue(5,14));
		assertFalse(queue.isQueueEmpty());
	}

	@Test
	public void testIsQueueFull() throws Exception {
		PriorityQueue queue=new PriorityQueue(5);
		assertTrue(queue.enQueue(1,10));
		assertTrue(queue.enQueue(2,11));
		assertTrue(queue.enQueue(3,12));
		assertTrue(queue.enQueue(4,13));
		
		assertFalse(queue.isQueueFull());
	}
}