import java.util.Hashtable;
import java.util.Map;

public class HashTableImplementation{
	
	public static void main(String[] args){
		CustomHashtable hashTable = new CustomHashtable(50);
		System.out.println("Welcome to the Pet Store!\n"
				+ "There are 50 kennels for pets to be put in. "
				+ "Hashtable size:"+hashTable.size);
		System.out.println("We add a large dog followed by another large dog into the same kennel.");
		hashTable.put(new Pet("A Pet", "A Owner", "A breed", Size.LARGE));
		hashTable.put(new Pet("A Pet", "A Owner", "A breed", Size.LARGE));
		System.out.println("We add a medium sized cat, then a small cat, and then try to add another small cat"
				+ " into the same kennel");
		hashTable.put(new Pet("Sapphire","George Washington", "Cat", Size.MEDIUM));
		hashTable.put(new Pet("Sapphire","George Washington", "Cat", Size.SMALL));
		hashTable.put(new Pet("Sapphire","George Washington", "Cat", Size.SMALL));
		
		
		
		System.out.println("The resulting hash table is:\n"+hashTable);
		
		
		
	}

}
