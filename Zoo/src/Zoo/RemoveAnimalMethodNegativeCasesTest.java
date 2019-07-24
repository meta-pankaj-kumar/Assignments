/*
 * Test Class working on JUnit 4
 */
package Zoo;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Animal.Animal;
import Animal.Mammal.Carnivorous.Tiger;
import Zoo.Cage;
import Zoo.Zoo;

public class RemoveAnimalMethodNegativeCasesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Cage cage1 = new Cage(3,"Mammal",1,"Carnivorous");
		Zoo.addCage(cage1);
	}

	@Test
	public void testRemoveAnimal()throws Exception{
		
		Animal animal2 =new Tiger("alphaTiger",10,150);
		assertFalse(Zoo.removeAnimal(animal2));
	}
}
