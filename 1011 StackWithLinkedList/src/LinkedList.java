
public class LinkedList {
	public Node first;
	public Node last;
	
	// we build the list forward, so all operations will be done to the tail
	public void push(Pets pet){
		Node newNode = new Node();
		newNode.pet = pet;
		newNode.link = null;
		if (first == null){
			first = newNode;
			last = newNode;
		} else {
			last.link = newNode;
			last = newNode;
		}
	}
	
	public void pop(){
		Node current = first;
		while (current != null){
			if (current.link.link == null){
				current.link = null;
				last = current;
			}
			current = current.link;
		}
	}
	
	public String toString(){
		Node current = first;
		String print = "";
		while (current!=null){
			print= print+current.pet.toString()+"\n";
			current = current.link;
		}
		return print;
	}
}
