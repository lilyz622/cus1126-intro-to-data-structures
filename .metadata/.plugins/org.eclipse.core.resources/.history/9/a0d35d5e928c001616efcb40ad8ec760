import java.util.ArrayList;


public class LinkedListOperations {
	public static void main(String[] args){
		// sample list of inputs
		ArrayList<Pets> petList = new ArrayList<Pets>();
		petList.add(new Pets("Dog", "Ace", 5)); // initializes objects with properties: species="Dog",name="Ace", and ID=5.
		petList.add(new Pets("Cat", "Betty", 8));
		petList.add(new Pets("Snake", "Creepy", 4));
		petList.add(new Pets("Bird", "Diana", 6));
		petList.add(new Pets("Ant", "Elaine", 1));
		
		buildListForward(petList);
	}
	
	public static Node buildListForward(ArrayList<Pets> input){
		Node first, newNode, last;
		first = null;
		last = null;
		int index = 0;
		while(index<input.size()){
			newNode= new Node();
//			newNode.info = input.get(index);
			newNode.link = null;
			
			if (first == null){
				first = newNode;
				last = newNode;
			}
			else {
				last.link = newNode;
				last = newNode;
			}
		}
		
		return first;
	}

}
