/*
 * Class of Duck
 * Methods 	
 * 		getSound() - returns the sound of Duck
 */
package Animal.Bird.Herbivorous;
public class Duck extends HerbivorousBird {
	/*
	 * @param String Unique name
	 * @param Double Age
	 * @param Double Weight
	 * @return Null
	 */
	public Duck(String uniqueName,double age,double weight){
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Duck";
	}
	/*
	 * @param Null
	 * @return Null
	 */
	public String getSound(){
		return "Quack";
	}
}
