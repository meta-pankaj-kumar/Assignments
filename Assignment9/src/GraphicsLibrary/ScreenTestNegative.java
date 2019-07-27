package GraphicsLibrary;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Test;

public class ScreenTestNegative {

	@Test(expected = Exception.class)
	public void AddShapeMethodNegativeCasesTest() throws Exception {
		Point point1 = new Point(1, 1);
		Screen screen1 = new Screen();
		ArrayList<Double> attributeList = new ArrayList<Double>();
		screen1.addShape("Hexagon", point1, attributeList);
	}

	@Test()
	public void DeleteAllShapesMethodNegativeCasesTest() {
		Screen screen2 = new Screen();
		assertFalse(screen2.deleteShape("Hexagon"));
	}

	@Test()
	public void DeleteAllShapesOfParticularTypeMethodNegativeCasesTest() {
		Screen screen3 = new Screen();
		assertFalse(screen3.deleteAllShapesOfParticularType("Circle"));
	}

	@Test(expected = Exception.class)
	public void SortMethodNegativeCasesTest() throws Exception {
		Point point1 = new Point(1, 1);
		ArrayList<Double> attributeList1 = new ArrayList<Double>();
		attributeList1.add(0, 1.0);
		attributeList1.add(1, 1.0);
		Screen screen3 = new Screen();
		screen3.addShape("Rectangle", point1, attributeList1);
		screen3.sort("Hexagon");
	}



}
