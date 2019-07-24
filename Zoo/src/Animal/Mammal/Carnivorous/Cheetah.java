/*
 * Class of Cheetah
 * Methods 	
 * 		getSound() - returns the sound of Cheetah
 */
package Animal.Mammal.Carnivorous;
public class Cheetah extends CarnivorousMammal {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Cheetah(double age,double weight){
		super();
		this.age = age;
		this.uniqueName = "Cheetah";
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
