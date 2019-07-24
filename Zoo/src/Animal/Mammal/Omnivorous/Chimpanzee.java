/*
 * Class of Chimpanzee
 * Methods 	
 * 		getSound() - returns the sound of Chimpanzee
 */
package Animal.Mammal.Omnivorous;
public class Chimpanzee extends OmnivorousMammal {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Chimpanzee(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Chimpanzee";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Scream";
	}
}
