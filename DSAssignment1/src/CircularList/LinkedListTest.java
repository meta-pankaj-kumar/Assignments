/*
 * Junit test class operating on junit 4
 */
package CircularList;
import static org.junit.Assert.*;
import org.junit.Test;
public class LinkedListTest {

	@Test
	public void testInsert() {
		LinkedList list=new LinkedList();
		assertTrue(list.insert(4));
	}

	@Test
	public void testInsertCircular() {
		LinkedList list=new LinkedList();
		assertTrue(list.insertCircular(4,2));
	}

	@Test
	public void testIsLoopPresent() {
		LinkedList list=new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		assertFalse(list.isLoopPresent());
		list.insertCircular(9, 3);
		assertTrue(list.isLoopPresent());
	}
}
