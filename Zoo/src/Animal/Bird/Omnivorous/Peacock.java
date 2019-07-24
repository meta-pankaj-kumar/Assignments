/*
 * Class of Peacock
 * Methods 	
 * 		getSound() - returns the sound of Peacock
 */
package Animal.Bird.Omnivorous;
public class Peacock extends OmnivorousBird {
	public Peacock(String uniqueName,double age,double weight){
		/*
		 * @param String Unique name
		 * @param Double Age
		 * @param Double Weight
		 * @return Null
		 */
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Peacock";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Scream";
	}
}
