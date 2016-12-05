
public class StackWithLinkedList {
	public static void main(String[] args){
		LinkedList petList = new LinkedList();
		petList.push(new Pets("Dog", "Ace", 5));
		petList.push(new Pets("Cat", "Betty", 8));
		petList.push(new Pets("Snake", "Creepy", 4));
		petList.push(new Pets("Bird", "Diana", 6));
		petList.push(new Pets("Ant", "Elaine", 1));
		
		System.out.println("Here is the list of Pets objects nodes in the linkedlist:");
		System.out.println(petList);
		
		System.out.println("We pop the last in:");
		petList.pop();
		System.out.println(petList);
		
		System.out.println("We pop the last in:");
		petList.pop();
		System.out.println(petList);
		
	}

}
