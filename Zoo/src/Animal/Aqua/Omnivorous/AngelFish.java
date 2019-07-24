/*
 * Class of AngelFish
 * Methods 
 * 		getSound - returning Sound of AngelFish
 */
package Animal.Aqua.Omnivorous;
public class AngelFish extends OmnivorousAqua {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public AngelFish(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "AngelFish";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Glub";
	}
}
