/*
 * Junit test class operating on junit 4
 */
package Polynomial;
import static org.junit.Assert.*;
import org.junit.Test;
public class PolynomialTest {
	
	@Test
	public void testDegree() {
		Polynomial poly=new Polynomial("-4x3y+3xy-5vgh+4yu-89y-96g25fr");
		assertEquals(27,poly.degree());
		Polynomial lko=new Polynomial("4x35y+3xy-5vgh+4yu-89y-96g25fr");
		assertEquals(36,lko.degree());
		Polynomial pol = new Polynomial("4x3y+3x2y3");
		assertEquals(5,pol.degree());
	}
}