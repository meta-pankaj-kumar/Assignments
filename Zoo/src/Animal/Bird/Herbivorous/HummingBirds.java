/*
 * Class of Humming Birds
 * Methods 	
 * 		getSound() - returns the sound of Humming Birds
 */
package Animal.Bird.Herbivorous;
public class HummingBirds extends HerbivorousBird {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public HummingBirds(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "HummingBirds";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Whirring";
	}
}
