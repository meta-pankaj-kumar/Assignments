package Problem3;
import static org.junit.Assert.*;
import org.junit.Test;
public class MassCalculatorTest {

	@Test
	public void calculateMassMethodPositiveCasesTest() throws Exception {
		
		MassCalculator massCalculator = new MassCalculator();
		
		String formula1 = "C2H4";
		String formula2 = "H2O";
		String formula3 = "CO2";
		String formula4 = "C(OH)3";
		String formula5 = "OH";
		
			assertEquals(28,massCalculator.calculateMass(formula1));
			assertEquals(18,massCalculator.calculateMass(formula2));
			assertEquals(44,massCalculator.calculateMass(formula3));
			assertEquals(63,massCalculator.calculateMass(formula4));
			assertEquals(17,massCalculator.calculateMass(formula5));
	}
	
	@Test(expected = Exception.class)
	public void calculateMassMethodNegativeCasesTest() throws Exception {
		
		MassCalculator massCalculator = new MassCalculator();
	
		String formula = "C(OH3";
		assertEquals(63,massCalculator.calculateMass(formula));
	}
}