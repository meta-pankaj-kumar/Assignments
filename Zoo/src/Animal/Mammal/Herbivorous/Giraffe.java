/*
 * Class of Giraffe
 * Methods 	
 * 		getSound() - returns the sound of Elephant
 */
package Animal.Mammal.Herbivorous;
public class Giraffe extends HerbivorousMammal {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Giraffe(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Giraffe";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Hum";
	}
}
