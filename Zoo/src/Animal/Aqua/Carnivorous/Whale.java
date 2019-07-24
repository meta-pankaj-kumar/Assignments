/*
 * Class of Whale
 * Methods 
 * 		getSound - Returns sound
 */
package Animal.Aqua.Carnivorous;
public class Whale extends CarnivorousAqua {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Whale(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Whale";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Pods";
	}
}
