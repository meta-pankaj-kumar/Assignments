/*
 * Class of Bear
 * Methods 	
 * 		getSound() - returns the sound of Bear
 */
package Animal.Mammal.Omnivorous;
public class Bear extends OmnivorousMammal {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Bear(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Bear";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Growl";
	}
}
