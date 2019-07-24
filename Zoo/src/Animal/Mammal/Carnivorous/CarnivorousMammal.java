/*
 * Parent Class of Carnivorous Mammals
 */
package Animal.Mammal.Carnivorous;
import Animal.Mammal.Mammal;
public abstract class CarnivorousMammal extends Mammal {
	/*
	 * @param Null
	 * @return Null
	 */
	public CarnivorousMammal(){
		super.subCatagory = "Carnivorous";
	}
}
