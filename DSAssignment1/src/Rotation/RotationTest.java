/*
 * Junit test class operating on junit 4
 */
package Rotation;
import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;
public class RotationTest {

	@Test
	public void testRotateSubListClockWise() {
		LinkedList<Integer> list=new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		int left=2;
		int right=5;
		int rotations=3;
		LinkedList<Integer> expected=new LinkedList<Integer>();
		expected.add(1);
		expected.add(5);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(6);
		Rotation rotate=new Rotation(); 
		assertEquals(expected,rotate.rotateClockWise(list, left, right, rotations));
	}
}
