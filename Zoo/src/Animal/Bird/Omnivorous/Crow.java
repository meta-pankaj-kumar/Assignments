/*
 * Class of Crow
 * Methods 	
 * 		getSound() - returns the sound of Crow
 */
package Animal.Bird.Omnivorous;

public class Crow extends OmnivorousBird {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Crow(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Crow";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return ("Rattle");
	}
}
