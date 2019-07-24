/*
 * Class of Alligators
 * Methods 	
 * 		getSound() - returns the sound of Alligators
 */
package Animal.Reptile.Carnivorous;
public class Alligators extends CarnivorousReptile {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Alligators(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Alligators";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Urp";
	}
}
