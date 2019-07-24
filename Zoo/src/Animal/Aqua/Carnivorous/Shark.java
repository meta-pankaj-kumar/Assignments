/*
 * Class of Shark
 * Methods 
 * 		getSound - Returns sound
 */
package Animal.Aqua.Carnivorous;
public class Shark extends CarnivorousAqua {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Shark(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Shark";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Glub";
	}
}
