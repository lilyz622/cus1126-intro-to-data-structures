import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Project name: BinarySearch
 * Background: Suppose you own a vet store. Each pet you have in record is identified by its id, 
 *     and for a certain day some pets come and visit, and you want to organize their information by id. 
 * Description: Project implements iterative and recursive binary searches to search for the desired
 *     id of a Pets object, after ensuring the arraylist of Pets is sorted.
 * Due Date: Sept. 26, 2016
 * @author yzhan265
 *
 */

public class BinarySearch {
	public static void main(String[] args){
		// sample unordered list of inputs
		ArrayList<Pets> petList = new ArrayList<Pets>();
		petList.add(new Pets("Dog", "Ace", 5)); // initializes objects with properties: species="Dog",name="Ace", and ID=5.
		petList.add(new Pets("Cat", "Betty", 8));
		petList.add(new Pets("Snake", "Creepy", 4));
		petList.add(new Pets("Bird", "Diana", 6));
		petList.add(new Pets("Ant", "Elaine", 1));
		
		// sort the list by the desired attribute, in this case by ID.
		ArrayList<Pets> sortedPets = sortArrayList(petList);
		
		// prints list of pets
		for (int j = 0; j < petList.size(); j++) {
			System.out.println(sortedPets.get(j));
		}
		
		// prints out results using the iterative binary search.
		System.out.println();
		for (int i = 1; i<=8; i++){
			System.out.println("The pet with id:"+i+" is at index "+iterativeBinarySearch(sortedPets,i));
		}

		// prints out results using the recursive binary search.
		System.out.println();
		for (int i = 1; i<=8; i++){
			System.out.println("The pet with id:"+i+" is at index "+ recursiveBinarySearch(sortedPets,i, 0, sortedPets.size()-1));
		}
	
	}
	
	/**
	 * sorts arraylist of pets objects by id using insertion sort.
	 * @param input unordered ArrayList of Pets objects
	 * @return ordered ArrayList of Pets objects
	 */
	public static ArrayList<Pets> sortArrayList(ArrayList<Pets> input){
		// destination ArrayList
		ArrayList<Pets> sortedPets = new ArrayList<Pets>();
		
		// for each element read from the input list, compare it to the values in the destination list
		// and insert it.
		for (int inputIndex = 0; inputIndex < input.size(); inputIndex++){
			int addIndex = 0;
			for (int spIndex = 0; spIndex < sortedPets.size(); spIndex++) {
				if (input.get(inputIndex).getId() > sortedPets.get(spIndex).getId()) {
					addIndex++;
				} 
			}
			sortedPets.add(addIndex, input.get(inputIndex));
		}
		return sortedPets;
	}
	
	/**
	 * Iterative binary search for desired pet
	 * @param inputList ArrayList of Pets objects
	 * @param targetId the id of the pet we want to find
	 * @return the index of the pet object by id. Returns -1 if not found.
	 */
	public static int iterativeBinarySearch(ArrayList<Pets> inputList, int targetId){
		int startIndex = 0;
		int endIndex = inputList.size()-1;
		
		// while the startIndex does not exceed the endIndex
		while (startIndex <= endIndex){
			//calculate the midpoint
			int midpoint = (startIndex + endIndex)/2;
			if (targetId < inputList.get(midpoint).getId()){
				// if the targetId is smaller than the midpoint id, set the new endIndex to be the midpoint minus one.
				endIndex = midpoint-1;
			} else if (targetId > inputList.get(midpoint).getId()){
				// if the target Id is larger than the midpoint id, set the new startIndex to be the midpoint plus one.
				startIndex = midpoint+1;
			} else {
				// last option is if the target id is equal to the midpoint id, we return our found result.
				return midpoint;
			}
		}
		
		// if we do not find the id within the input list, return -1.
		return -1;
	}
	
	/**
	 * Recursive binary search for desired pet
	 * @param inputList ArrayList of Pets objects
	 * @param targetId the id of the pet we want to find
	 * @param startIndex 
	 * @param endIndex
	 * @return the index of the pet object by id. Returns -1 if not found.
	 */
	public static int recursiveBinarySearch(ArrayList<Pets> inputList, int targetId, int startIndex, int endIndex){
		// if startIndex becomes greater than endIndex, then the id is not in the inputList.
		if (startIndex > endIndex){
			return -1;
		}
		
		// calculate the midpoint index
		int midpoint = (startIndex + endIndex)/2;
		
		if (targetId < inputList.get(midpoint).getId()){
			// if the targetId is smaller than the midpoint id, set the new endIndex to be the midpoint minus one.
			return recursiveBinarySearch(inputList, targetId, startIndex, midpoint-1);
		} else if (targetId > inputList.get(midpoint).getId()){
			// if the target Id is larger than the midpoint id, set the new startIndex to be the midpoint plus one.
			return recursiveBinarySearch(inputList, targetId, midpoint+1, endIndex);
		} else {
			// if targetId equals the id of the midpoint object id, return the midpoint index.
			return midpoint;
		}
		
	}
	
}

/*
 * ID: 1	Name: Elaine	Species: Ant
ID: 4	Name: Creepy	Species: Snake
ID: 5	Name: Ace	Species: Dog
ID: 6	Name: Diana	Species: Bird
ID: 8	Name: Betty	Species: Cat

The pet with id:1 is at index 0
The pet with id:2 is at index -1
The pet with id:3 is at index -1
The pet with id:4 is at index 1
The pet with id:5 is at index 2
The pet with id:6 is at index 3
The pet with id:7 is at index -1
The pet with id:8 is at index 4

The pet with id:1 is at index 0
The pet with id:2 is at index -1
The pet with id:3 is at index -1
The pet with id:4 is at index 1
The pet with id:5 is at index 2
The pet with id:6 is at index 3
The pet with id:7 is at index -1
The pet with id:8 is at index 4

 */
