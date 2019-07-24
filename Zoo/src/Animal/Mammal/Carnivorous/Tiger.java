/*
 * Class of Tiger
 * Methods 	
 * 		getSound() - returns the sound of Tiger
 */
package Animal.Mammal.Carnivorous;
public class Tiger extends CarnivorousMammal {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Tiger(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound() {
		return "Roars";
	}
}
