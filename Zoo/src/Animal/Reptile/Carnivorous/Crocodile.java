/*
 * Class of Crocodile
 * Methods 	
 * 		getSound() - returns the sound of Crocodile
 */
package Animal.Reptile.Carnivorous;
public class Crocodile extends CarnivorousReptile {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Crocodile(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Crocodile";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Bellows";
	}
}
