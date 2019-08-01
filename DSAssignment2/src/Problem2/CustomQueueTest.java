/*
 * This is test class operating under JUnit 4
 */
package Problem2;
import static org.junit.Assert.*;
import org.junit.Test;
public class CustomQueueTest {
	
	@Test
	public void enQueueMethodPositiveCasesTest() throws Exception{
		Queue queue = new CircularQueue(10);
		assertTrue(queue.enQueue(1));
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(4));
		assertTrue(queue.enQueue(5));
		assertTrue(queue.enQueue(6));
		assertTrue(queue.enQueue(7));
		assertTrue(queue.enQueue(8));
		assertTrue(queue.enQueue(9));
		assertTrue(queue.enQueue(10));	
	}
	
	@Test
	public void deQueueMethodPositiveCasesTest() throws Exception {
		Queue queueSecond = new CircularQueue(10);
		queueSecond.enQueue(1);
		queueSecond.enQueue(2);
		queueSecond.enQueue(3);
		queueSecond.enQueue(4);
		queueSecond.enQueue(5);
		queueSecond.enQueue(6);
		queueSecond.enQueue(7);
		queueSecond.enQueue(8);
		queueSecond.enQueue(9);
		queueSecond.enQueue(10);
		
		assertEquals(1,queueSecond.deQueue());
		assertEquals(2,queueSecond.deQueue());
		assertEquals(3,queueSecond.deQueue());
		assertEquals(4,queueSecond.deQueue());
		assertEquals(5,queueSecond.deQueue());
		assertEquals(6,queueSecond.deQueue());
		assertEquals(7,queueSecond.deQueue());
		assertEquals(8,queueSecond.deQueue());
		assertEquals(9,queueSecond.deQueue());
		assertEquals(10,queueSecond.deQueue());
	}
	
	@Test
	public void isEmptyMethodPositiveCasesTest() {
		Queue queue = new CircularQueue();
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void isFullMethodPositiveCasesTest(){
		
		Queue queue = new CircularQueue();
		try{
			assertTrue(queue.enQueue(1));
			assertTrue(queue.enQueue(2));
			assertTrue(queue.enQueue(3));
			assertTrue(queue.enQueue(4));
			assertTrue(queue.enQueue(5));
			assertTrue(queue.enQueue(6));
			assertTrue(queue.enQueue(7));
			assertTrue(queue.enQueue(8));
			assertTrue(queue.enQueue(9));
			assertTrue(queue.enQueue(10));
		}catch(Exception e){
			System.out.println(e);
		}
		assertTrue(queue.isFull());
	}
	
	@Test(expected = Exception.class)
	public void enQueueMethodNegativeCasesTest() throws Exception{
		
		Queue queue = new CircularQueue();
		assertTrue(queue.enQueue(1));
		assertTrue(queue.enQueue(2));
		assertTrue(queue.enQueue(3));
		assertTrue(queue.enQueue(4));
		assertTrue(queue.enQueue(5));
		assertTrue(queue.enQueue(6));
		assertTrue(queue.enQueue(7));
		assertTrue(queue.enQueue(8));
		assertTrue(queue.enQueue(9));
		assertTrue(queue.enQueue(10));	
		assertTrue(queue.enQueue(11));
	}

	@Test(expected = Exception.class)
	public void deQueueMethodNegativeCasesTest() throws Exception {
		
		Queue queue = new CircularQueue();
		assertEquals(11,queue.deQueue());
	}
	
	@Test
	public void isEmptyMethodNegativeCasesTest() throws Exception {
		
		Queue queue = new CircularQueue();
		queue.enQueue(1);
		assertFalse(queue.isEmpty());
	}

	@Test
	public void isFullMethodNegativeCasesTest() throws Exception{
		
		Queue queue = new CircularQueue();
		assertFalse(queue.isFull());
	}
}