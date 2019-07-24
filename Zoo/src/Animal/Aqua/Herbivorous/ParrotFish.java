/*
 * Class of ParrotFish
 * Methods 
 * 		getSound - returning Sound of surgeon fish
 */
package Animal.Aqua.Herbivorous;
public class ParrotFish extends HerbivorousAqua {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public ParrotFish(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "ParrotFish";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Grunts";
	}
}