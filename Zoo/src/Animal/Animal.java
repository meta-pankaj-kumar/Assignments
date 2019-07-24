/*
 * Abstract Parent Class of Animals
 * Methods 
 * 		getSound - Signature of getSound Method
 */
package Animal;
public abstract class Animal {
	public String catagory;
	public String subCatagory;
	public String species;
	public String uniqueName;
	protected double age;
	protected double weight;
	//abstract method for getting Sound
	abstract public String getSound();
}
