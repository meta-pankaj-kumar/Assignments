/*
 * Test Class working on JUnit 4
 */
package Zoo;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Animal.*;
import Animal.Aqua.Carnivorous.Shark;
import Animal.Aqua.Herbivorous.SurgeonFish;
import Animal.Aqua.Omnivorous.AngelFish;
import Animal.Bird.Carnivorous.Eagle;
import Animal.Bird.Herbivorous.Duck;
import Animal.Bird.Omnivorous.Peacock;
import Animal.Mammal.Carnivorous.Lion;
import Animal.Mammal.Herbivorous.Deer;
import Animal.Mammal.Herbivorous.Elephant;
import Animal.Mammal.Omnivorous.Bear;
import Animal.Reptile.Carnivorous.Crocodile;

public class RemoveAnimalMethodPositiveCasesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Cage cage1 = new Cage(3,"Mammal",1,"Carnivorous");
		Cage cage2 = new Cage(3,"Mammal",2,"Herbivorous");
		Cage cage3 = new Cage(3,"Mammal",3,"Omnivorous");
		Cage cage4 = new Cage(3,"Bird",4,"Carnivorous");
		Cage cage5 = new Cage(3,"Bird",5,"Herbivorous");
		Cage cage6 = new Cage(3,"Bird",6,"Omnivorous");
		Cage cage7 = new Cage(3,"Reptile",7,"Carnivorous");
		Cage cage8 = new Cage(3,"Aqua",8,"Carnivorous");
		Cage cage9 = new Cage(3,"Aqua",9,"Herbivorous");
		Cage cage10 = new Cage(3,"Aqua",10,"Omnivorous");
		Cage cage11 = new Cage(3,"Mammal",11,"Herbivorous");
		
		Zoo.addCage(cage1);
		Zoo.addCage(cage2);
		Zoo.addCage(cage3);
		Zoo.addCage(cage4);
		Zoo.addCage(cage5);
		Zoo.addCage(cage6);
		Zoo.addCage(cage7);
		Zoo.addCage(cage8);
		Zoo.addCage(cage9);
		Zoo.addCage(cage10);
		Zoo.addCage(cage11);
	}

	@Test
	public void testRemoveAnimal() {
		try{
			Animal animal1 =new Lion("alphaLion",10,150);
			assertTrue(Zoo.addAnimal(animal1));
			assertTrue(Zoo.removeAnimal(animal1));
			
			Animal animal2 =new Lion("betaLion",9,150);
			assertTrue(Zoo.addAnimal(animal2));
			assertTrue(Zoo.removeAnimal(animal2));
			
			Animal animal3 =new Deer("alphaDeer",5,70);
			assertTrue(Zoo.addAnimal(animal3));
			assertTrue(Zoo.removeAnimal(animal3));
			
			Animal animal4 =new Elephant("aplhaElephant",25,300);
			assertTrue(Zoo.addAnimal(animal4));
			assertTrue(Zoo.removeAnimal(animal4));
			
			Animal animal5 =new Bear("alphaBear",10,150);
			assertTrue(Zoo.addAnimal(animal5));
			assertTrue(Zoo.removeAnimal(animal5));
			
			Animal animal6 =new Crocodile("alphaCrocodile",15, 120);
			assertTrue(Zoo.addAnimal(animal6));
			assertTrue(Zoo.removeAnimal(animal6));
			
			Animal animal7 =new Eagle("alphaEagle",2,3);
			assertTrue(Zoo.addAnimal(animal7));
			assertTrue(Zoo.removeAnimal(animal7));
			
			Animal animal8 =new AngelFish("alphaAngelFish",.5,.5);
			assertTrue(Zoo.addAnimal(animal8));
			assertTrue(Zoo.removeAnimal(animal8));
			
			Animal animal9 =new Shark("alphaShark",5,150);
			assertTrue(Zoo.addAnimal(animal9));
			assertTrue(Zoo.removeAnimal(animal9));
			
			Animal animal10 = new Duck("alphaDuck",1,1.5);
			assertTrue(Zoo.addAnimal(animal10));
			assertTrue(Zoo.removeAnimal(animal10));
			
			Animal animal11 = new Peacock("aplhaPeacock",2,3);
			assertTrue(Zoo.addAnimal(animal11));
			assertTrue(Zoo.removeAnimal(animal11));
			
			Animal animal12 = new SurgeonFish("alphaSurgeonFish",1,.5);
			assertTrue(Zoo.addAnimal(animal12));
			assertTrue(Zoo.removeAnimal(animal12));
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
