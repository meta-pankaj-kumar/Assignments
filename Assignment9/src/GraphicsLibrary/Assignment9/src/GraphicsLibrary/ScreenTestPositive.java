package GraphicsLibrary;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ScreenTestPositive {

	@Test
	public void testAddShape() throws Exception {
		Screen screen=new Screen();
		Point point=new Point(1,1);
		ArrayList<Double> list=new ArrayList<Double>();
		list.add(1.0);
		assertTrue(screen.addShape("Square",point,list));
		assertTrue(screen.addShape("Circle",point, list));
		list.add(2.3);
		assertTrue(screen.addShape("Rectangle",point,list));
		assertTrue(screen.addShape("Triangle",point, list));
	}

	@Test
	public void testDisplayScreen() throws Exception {
		Screen screen=new Screen();
		Point point=new Point(1,1);
		ArrayList<Double> list=new ArrayList<Double>();
		list.add(1.0);
		screen.addShape("Square",point,list);
		screen.addShape("Circle",point, list);
		list.add(2.3);
		screen.addShape("Rectangle",point,list);
		screen.addShape("Triangle",point, list);
		screen.addShape("Rectangle",point,list);
		screen.addShape("Rectangle",point,list);
		screen.addShape("Rectangle",point,list);
		screen.addShape("Triangle",point, list);
		String actual[]=screen.displayScreen();
		String expected[]=new String[]{"Square","Circle","Rectangle","Triangle","Rectangle","Rectangle","Rectangle","Triangle"};
		assertArrayEquals(expected, actual);	}

	@Test
	public void testDeleteShape() throws Exception {
		Screen screen=new Screen();
		Point point=new Point(1,1);
		ArrayList<Double> list=new ArrayList<Double>();
		list.add(1.0);
		screen.addShape("Square",point,list);
		screen.addShape("Circle",point, list);
		list.add(2.3);
		screen.addShape("Rectangle",point,list);
		screen.addShape("Triangle",point, list);
		screen.addShape("Rectangle",point,list);
		screen.addShape("Rectangle",point,list);
		screen.addShape("Rectangle",point,list);
		screen.addShape("Triangle",point, list);
		assertTrue(screen.deleteShape("Rectangle"));
		assertTrue(screen.deleteShape("Circle"));
	}

	@Test
	public void testDeleteAll() throws Exception {
		Screen screen=new Screen();
		Point point=new Point(1,1);
		ArrayList<Double> list=new ArrayList<Double>();
		list.add(1.0);
		screen.addShape("Square",point,list);
		screen.addShape("Circle",point, list);
		list.add(2.3);
		screen.addShape("Rectangle",point,list);
		screen.addShape("Triangle",point, list);
		screen.addShape("Rectangle",point,list);
		screen.addShape("Rectangle",point,list);
		screen.addShape("Rectangle",point,list);
		screen.addShape("Triangle",point, list);
		assertTrue(screen.deleteAll());
	}

	@Test
	public void testIsEnclosed() throws Exception {
		Screen screen=new Screen();
		Point point=new Point(1,1);
		ArrayList<Double> list=new ArrayList<Double>();
		list.add(1.0);
		screen.addShape("Square",point,list);
		screen.addShape("Circle",point, list);
		List<String> actual=new LinkedList<String>();
		actual=screen.isEnclosed(point);
		List<String> expected=new LinkedList<String>();
		expected.add("Square");
		expected.add("Circle");
		assertEquals(expected, actual);
	}

	@Test
	public void testSort() throws Exception {
		Screen screen=new Screen();
		Point point=new Point(1,1);
		ArrayList<Double> list=new ArrayList<Double>();
		list.add(1.0);
		screen.addShape("Square",point,list);
		screen.addShape("Circle",point, list);
		List<String> actual=new LinkedList<String>();
		actual=screen.sort("Area");
		List<String> expected=new LinkedList<String>();
		expected.add("Square");
		expected.add("Circle");
		assertEquals(expected, actual);
		expected.removeAll(expected);
		actual=screen.sort("Perimeter");
		expected.add("Square");
		expected.add("Circle");
		assertEquals(expected, actual);
		expected.removeAll(expected);
		actual=screen.sort("Origin");
		expected.add("Square");
		expected.add("Circle");
		assertEquals(expected, actual);
		expected.removeAll(expected);
		actual=screen.sort("TimeStamp");
		expected.add("Square");
		expected.add("Circle");
		assertEquals(expected, actual);
	}

}
