/*
 * Zoo Class 
 * Methods 
 * 		addZone
 * 		findSupportedZoneForAnimal
 * 		findSupportedZoneForCage
 * 		addAnimal
 * 		addCage
 * 		removeAnimal
 */
package Zoo;
import java.util.HashMap;
import java.util.Map;
import Animal.Animal;
public class Zoo {
	public static Map<String,Animal> animalInZoo = new HashMap<String,Animal>();
	public static int numberOfZones = 0;
	public static Map<Integer,Zone> zonesInZoo = new HashMap<Integer,Zone>();
	private static int MAX_CAGE_LIMIT_IN_ZONE =15;
	//static method for initialising Zones at the time of zoo creation
	static{
		Zoo.addZone(new Zone("Reptile","Carnivorous",numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,true,true));
		Zoo.addZone(new Zone("Aqua","Carnivorous",numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,true,true));
		Zoo.addZone(new Zone("Aqua","Herbivorous",numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,true,true));
		Zoo.addZone(new Zone("Aqua","Omnivorous",numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,true,true));
		Zoo.addZone(new Zone("Bird","Carnivorous",numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,true,true));
		Zoo.addZone(new Zone("Bird","Herbivorous",numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,true,true));
		Zoo.addZone(new Zone("Bird","Omnivorous",numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,true,true));
		Zoo.addZone(new Zone("Mammal","Carnivorous",numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,true,true));
		Zoo.addZone(new Zone("Mammal","Herbivorous",numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,true,true));
		Zoo.addZone(new Zone("Mammal","Omnivorous",numberOfZones,MAX_CAGE_LIMIT_IN_ZONE,true,true));
	}
	/*
	 * @param Zone type zone
	 * @return boolean true if zone addition is successful
	 */
	public static boolean addZone(Zone zone){
		Zoo.zonesInZoo.put(zone.zoneId, zone);
		Zoo.numberOfZones++;
		return true;
	}
	/*
	 * @param Animal type animal
	 * @return Zone type zone of animal
	 * @exception throws custom exception if Zone not supported for current animal 
	 */
	public static Zone findSupportedZoneForAnimal(Animal animal) throws Exception{
		for(Zone zone : Zoo.zonesInZoo.values()){
			if((zone.subcatagoryOfAnimalSupported.equalsIgnoreCase(animal.subCatagory) && (zone.catagoryOfAnimalSupported.equalsIgnoreCase(animal.catagory)) )){
				return zone;
			}
		}
		throw new Exception("------Zone not found for given animal------"+animal.uniqueName);
	}	
	/*
	 * @param Cage type cage
	 * @return zone type zone for cage
	 * @exception throws custom exception if Zone not found for given cage
	 */
	public static Zone findSupportedZoneForCage(Cage cage) throws Exception{
		for(Zone zone : Zoo.zonesInZoo.values()){
			if((zone.subcatagoryOfAnimalSupported.equalsIgnoreCase(cage.subCatagoryOfAnimal)) && (zone.catagoryOfAnimalSupported.equalsIgnoreCase(cage.catagoryOfAnimal))){
				return zone;
			}
		}
		throw new Exception("------Zone not found for given cage------"+cage.cageId);
	}	
	/*
	 * @param Animal type animal
	 * @return boolean true if animal addition is successful
	 * @return boolean false if animal addition is unsuccessful
	 * @exception throws custom exception if animal with same name exists
	 */
	public static boolean addAnimal(Animal animal) throws Exception{
		//checking if any animal with same name is already present in zoo
		if(Zoo.animalInZoo.containsKey(animal.uniqueName)){
			throw new Exception("------An animal with same name is alredy present in Zoo------"+animal.uniqueName);
		}
		Zone supportedZone = Zoo.findSupportedZoneForAnimal(animal);
		boolean animalPlaced = supportedZone.addAnimal(animal);
		//if animal placed return true
		if(animalPlaced){
			return true; 
		}
		//else false
		return false;
	}
	/*
	 * @param Cage type cage
	 * @return boolean true if cage addition is successful
	 * @return boolean false if cage addition is unsuccessful
	 */
	public static boolean addCage(Cage cage) throws Exception{
		Zone zone = Zoo.findSupportedZoneForCage(cage);
		boolean cagePlaced = zone.addCage(cage);
		if(cagePlaced){
			return true; 
		}
		return false;
	}
	/*
	 * @param Animal type animal
	 * @return boolean true if animal removal is successful
	 * @return boolean false if animal removal is unsuccessful
	 */
	public static boolean removeAnimal(Animal animal) throws Exception{
		//checking if animal present in the zoo
		boolean isAnimalPresentInZoo = false;
		//finding animal by its unique name
		for(Animal allAnimalsInZoo : Zoo.animalInZoo.values()){
			if(allAnimalsInZoo.uniqueName.equalsIgnoreCase(animal.uniqueName)){
				isAnimalPresentInZoo = true;
			}
			//if true
			if(isAnimalPresentInZoo){
				//finding zone of the animal found
				Zone zone = Zoo.findSupportedZoneForAnimal(animal);
				Cage cage = zone.findCageOfAnimal(animal);
				boolean animalRemoved = cage.removeAnimalFromCage(animal) ;
				Zoo.animalInZoo.remove(animal.uniqueName);
				return animalRemoved;
			}
		}
		return false;
	}
}