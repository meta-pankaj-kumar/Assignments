/*
 * Class of SurgeonFish
 * Methods 
 * 		getSound - returning Sound of surgeon fish
 */
package Animal.Aqua.Herbivorous;
public class SurgeonFish extends HerbivorousAqua {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public SurgeonFish(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "SurgeonFish";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Glub";
	}
}