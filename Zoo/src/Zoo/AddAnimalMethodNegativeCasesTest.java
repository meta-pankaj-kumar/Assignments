/*
 * Test Class working on JUnit 4
 */
package Zoo;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Animal.Animal;
import Animal.Mammal.Carnivorous.Lion;
import Zoo.Cage;
import Zoo.Zoo;

public class AddAnimalMethodNegativeCasesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Cage cage1 = new Cage(3,"Mammal",1,"Carnivorous");
		Zoo.addCage(cage1);
	}

	@Test(expected = Exception.class)
	public void testAddAnimal() throws Exception{
		
		Animal animal1 =new Lion("alphaLion",10,150);
		assertTrue(Zoo.addAnimal(animal1));
		
		Animal animal2 =new Lion("alphaLion",10,150);
		assertFalse(Zoo.addAnimal(animal2));
		
	}

}
