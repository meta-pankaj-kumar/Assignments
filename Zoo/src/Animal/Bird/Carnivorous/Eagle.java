/*
 * Class of Eagle Bird
 * Methods 	
 * 		getSound() - returns the sound of eagle
 */
package Animal.Bird.Carnivorous;
public class Eagle extends CarnivorousBird {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Eagle(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Eagle";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Screech";
	}
}
