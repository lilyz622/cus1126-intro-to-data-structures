import java.lang.reflect.Field;
import java.util.ArrayList;


public class LinkedListOperations {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		List petList = new List();
		petList.insertNode(new Pets("Dog", "Ace", 5));
		petList.insertNode(new Pets("Cat", "Betty", 8));
		petList.insertNode(new Pets("Snake", "Creepy", 4));
		petList.insertNode(new Pets("Bird", "Diana", 6));
		petList.insertNode(new Pets("Ant", "Elaine", 1));
		
		System.out.println("Here is the list of Pets objects nodes in the linkedlist:");
		System.out.println(petList);
		
		System.out.println("We delete the node for Diana, a bird with ID 6");
		petList.deleteNode(6);
		System.out.println("The result is:\n"+petList);
		
		System.out.println("We search for Betty the cat with ID 8");
		System.out.println("The result find is:\n"+petList.findNode(8));

	}

}
