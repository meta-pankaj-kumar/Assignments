/*
 * Class of Lion
 * Methods 	
 * 		getSound() - returns the sound of Lion
 */
package Animal.Mammal.Carnivorous;
public class Lion extends CarnivorousMammal {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Lion(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Lion";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return ("Roars");
	}
}
