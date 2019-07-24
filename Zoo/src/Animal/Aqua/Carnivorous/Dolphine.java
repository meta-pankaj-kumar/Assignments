/*
 * Class of Dolphine
 * Methods 
 * 		getSound - Returns sound
 */
package Animal.Aqua.Carnivorous;
public class Dolphine extends CarnivorousAqua {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Dolphine(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Dolphine";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Clicks";
	}
}
