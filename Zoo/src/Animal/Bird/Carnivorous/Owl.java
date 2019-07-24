/*
 * Class of Owl
 * Methods 	
 * 		getSound() - returns the sound of Owl
 */
package Animal.Bird.Carnivorous;
public class Owl extends CarnivorousBird {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Owl(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Owl";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return ("Hoot");
	}
}
