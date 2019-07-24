/*
 * Parent Class of Omnivorous Mammals
 */
package Animal.Mammal.Omnivorous;
import Animal.Mammal.Mammal;
public abstract class OmnivorousMammal extends Mammal {
	/*
	 * @param Null
	 * @return Null
	 */
	public OmnivorousMammal(){
		super.subCatagory = "Omnivorous";
	}
}