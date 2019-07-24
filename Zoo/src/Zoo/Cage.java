/*
 * Cage Class consisting of Animal Map and performs animal addition to cage
 * Methods
 * 		Cage - Parameterised Constructor initialising Values
 * 		removeAnimalFromCage - For Removing Animal from Cage
 * 		addAnimalInCage - For Adding Animal in Cage
 */
package Zoo;
import java.util.HashMap;
import java.util.Map;
import Animal.Animal;
public class Cage {
	
	public String catagoryOfAnimal;
	public String subCatagoryOfAnimal;
	public int cageId;
	public int cageCapacity;
	public int TotalAnimalsInCage;
	public Map<String,Animal> animalMap = new HashMap<String,Animal>();
	
	/*
	 * @param int cageId
	 * @param int Capacity of Cage
	 * @param String Category Of Animal Supported
	 * @param String Sub Category of Animal Supported
	 * @return Null
	 */
	public Cage(int cageCapacity,String catagoryOfAnimal,int cageId,String subCatagoryOfAnimal){
		this.catagoryOfAnimal = catagoryOfAnimal;
		this.subCatagoryOfAnimal = subCatagoryOfAnimal;
		this.cageId = cageId;
		this.cageCapacity = cageCapacity;
	}
	
	/*
	 * @param Animal type Animal
	 * @return boolean true if animal is removed
	 */
	public boolean removeAnimalFromCage(Animal animal){
		this.animalMap.remove(animal.uniqueName);
		this.TotalAnimalsInCage--;
		return true;
	}
	
	/*
	 * @param Animal type Animal
	 * @return boolean true if animal is added
	 * @return boolean false if animal is not added
	 * @exception throws custom exception if species is Different
	 */
	public boolean addAnimalInCage(Animal animal) throws Exception{
		for(Animal animalInCage : this.animalMap.values()){
			//check if current animal is of different species 
			if(!animalInCage.species.equalsIgnoreCase(animal.species)){
				throw new Exception("------Addition of Different Animals in same cage is not allowed------"+animal.uniqueName);
			}
		}
		//if not so then put animal in animal map
		this.animalMap.put(animal.uniqueName, animal);
		Zoo.animalInZoo.put(animal.uniqueName, animal);
		//after adding increase current holding capacity of cage
		this.TotalAnimalsInCage++;
		return true;
	}
}