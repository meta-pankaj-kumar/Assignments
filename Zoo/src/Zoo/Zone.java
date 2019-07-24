/*
 * Zone class containing Cage Map and performs several methods
 * Methods 
 * 		Zone - parameterised Constructor for initialising Values
 * 		addAnimal - adding up of animal in zone and throws exception if it cannot 
 * 		addCage - adding up a new cage in zone if there is vacant space
 * 		findCageOfAnimal - finds cage of a particular animal 
 */
package Zoo;
import java.util.HashMap;
import java.util.Map;
import Animal.Animal;
public class Zone {
	public String catagoryOfAnimalSupported;
	public String subcatagoryOfAnimalSupported;
	private Map<Integer,Cage> cageMap = new HashMap<Integer,Cage>();
	public boolean hasCanteen;
	public boolean hasPark;
	public int zoneId;
	public int totalCageCapacity;
	public int numberOfCagesPlaced;
	
	/*
	 * @param String Category of animal Supported
	 * @param String Sub Category of animal Supported
	 * @param int zone Id
	 * @param int Total Cage Capacity
	 * @param boolean has canteen
	 * @param boolean has park
	 * @return Null
	 */
	public Zone(String catagoryOfAnimalSupported,String subcatagoryOfAnimalSupported,int zoneId,int totalCagesCapacity,boolean hasCanteen,boolean hasPark){
		this.catagoryOfAnimalSupported = catagoryOfAnimalSupported;
		this.subcatagoryOfAnimalSupported = subcatagoryOfAnimalSupported;
		this.zoneId = zoneId;
		this.totalCageCapacity = totalCagesCapacity;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
	}
	
	/*
	 * @param Animal type animal
	 * @return boolean true if animal is added
	 * @return boolean false if animal is not added
	 * @exception throws custom exception according to case 
	 */
	public boolean addAnimal(Animal animal) throws Exception{
		//check for if animal is supported in the current zone
		if(!animal.catagory.equalsIgnoreCase(this.catagoryOfAnimalSupported)){
			throw new Exception("------Animal is not Supported in this zone------"+animal.uniqueName);
		}
		//check for if supported cage has space or not
		boolean cageSupported = false;
		boolean animalPlaced = false;
		for(Cage cage :this.cageMap.values()){
			boolean animalCanBePlaced = true;
			if(cage.subCatagoryOfAnimal.equalsIgnoreCase(animal.subCatagory)){
				cageSupported = true;
			}
			if(cageSupported && cage.cageCapacity != cage.TotalAnimalsInCage){
				for(Animal animalInCage : cage.animalMap.values()){
					if(!animalInCage.species.equalsIgnoreCase(animal.species)){
						animalCanBePlaced = false;
						cageSupported = false;
						break;
					}
					else{
						animalCanBePlaced = true;
					}
				}
				if(animalCanBePlaced){
					cage.addAnimalInCage(animal);
					animalPlaced = true;
					return true;
				}
			}
		}
		if(!cageSupported){
			throw new Exception("------Cage is not in this zone------"+animal.uniqueName);
		}
		if(!animalPlaced){
			throw new Exception("------Cannot add animal to cage no space available Add new cage------"+animal.uniqueName);
		}
		return false;
	}
	
	/*
	 * @param Cage type cage
	 * @return true if cage addition is successful
	 * @exception throws custom Exception in case Zone capacity is Full
	 */
	public boolean addCage(Cage cage) throws Exception{
		//checking for if current zone cage capacity is full
		if(this.totalCageCapacity == this.numberOfCagesPlaced){
			throw new Exception("------Cannot place new cage to current zone capacity of zone is full------"+cage.cageId);
		}
		this.cageMap.put(cage.cageId, cage);
		this.numberOfCagesPlaced++;
		return true;
	}
	
	/*
	 * @param Animal type animal
	 * @return Cage type cage after finding cage of an animal
	 * @exception throws custom exception in case animal is not found
	 */
	public Cage findCageOfAnimal(Animal animal) throws Exception{
		for(Cage cageCheck : this.cageMap.values()){
			for(Animal animalInCage : cageCheck.animalMap.values()){
				if(animalInCage.uniqueName.equalsIgnoreCase(animal.uniqueName)){
					return cageCheck;
				}
			}
		}
		throw new Exception("------Animal not found------"+animal.uniqueName);
	}
}