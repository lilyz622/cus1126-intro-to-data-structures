import java.util.Hashtable;

public class CustomHashtable {
	public BucketLinkedList[] table;
	public int size;
	
	public CustomHashtable(int initialCapacity){
		size = initialCapacity;
		table = new BucketLinkedList[size];
	}
	
	public int put(Pet pet){
		String hashString = pet.pName+pet.breed+pet.owner;
		int hash = hashString.hashCode();
		int index = Math.abs(hash%(table.length));
		
		if (table[index] == null){
			table[index] = new BucketLinkedList();
			table[index].addPet(pet);
			return index;
		}
		
		if (table[index].addPet(pet)){
			return index;	
		} else {
			return -1;
		}
		
	}
	
	public String toString(){
		String print = "";
		for (int i = 0; i< table.length; i++){
			print +="\nINDEX "+i+":";
			print += table[i];
		}
		return print;
	}

}
