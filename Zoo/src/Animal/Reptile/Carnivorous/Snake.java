/*
 * Class of Snake
 * Methods 	
 * 		getSound() - returns the sound of Snake
 */
package Animal.Reptile.Carnivorous;
public class Snake extends CarnivorousReptile {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Snake(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Snake";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Hiss";
	}
}
