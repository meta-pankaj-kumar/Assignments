/*
 * Class of Elephant
 * Methods 	
 * 		getSound() - returns the sound of Elephant
 */
package Animal.Mammal.Herbivorous;
public class Elephant extends HerbivorousMammal {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Elephant(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Elephant";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Trumpet";
	}
}
