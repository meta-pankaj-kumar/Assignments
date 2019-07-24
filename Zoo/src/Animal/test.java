package Animal;

import Zoo.Cage;
import Zoo.Zoo;
import Animal.Mammal.Carnivorous.Lion;

public class test {

	public static void main(String[] args) {
		
		String uniqueName ="xyz";
		double age = 10;
		double weight = 150;
		Animal animal = new Lion(uniqueName,age,weight);
		 int cageId = 1;
		 int capacityOfCage = 2;
		 String catagoryOfAnimalSupported = "Mammal";
		 String subCatagoryOfAnimalSupported = "Carnivorous";
		Cage cage = new Cage(cageId,catagoryOfAnimalSupported,capacityOfCage,subCatagoryOfAnimalSupported);
		try{
			boolean cageAdded = Zoo.addCage(cage);
			System.out.println(cageAdded+" cage added");
			boolean animalAdded = Zoo.addAnimal(animal);
			System.out.println(animalAdded+" animal added");
			boolean animalRemoved = Zoo.removeAnimal(animal);
			System.out.println(animalRemoved+" animal removed");
			animalAdded = Zoo.addAnimal(animal);
			System.out.println(animalAdded+" animal added");
			
			animalAdded = Zoo.addAnimal(animal);
			System.out.println(animalAdded+" animal added");
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
