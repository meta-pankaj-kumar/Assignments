/*
 * Class of Deer
 * Methods 	
 * 		getSound() - returns the sound of Deer
 */
package Animal.Mammal.Herbivorous;
public class Deer extends HerbivorousMammal {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Deer(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Deer";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Bleat";
	}
}