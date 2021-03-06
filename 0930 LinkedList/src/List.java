/**
 * List class with nodes of objects from the Pets class.
 * (Note: I tried to make a generic List class but was unable to implement a generic version for
 * the delete and search operations, though they still work for the Pets class).
 * @author yzhan265
 *
 */
public class List{

	public Node last=null;
	public Node first=null;
	
	/**
	 * inserts object with object attached.
	 * @param object thats attached to the node.
	 */
	public void insertNode(Object object){
		Node newNode = new Node();
		newNode.object = object;
		newNode.link = null;
		
		// Check if list is empty
		if (first == null){
			first = newNode;
			last =newNode;
		}
		else {
			last.link = newNode;
			last=newNode;
		}
	}
	
	/**
	 * traverses and prints out the objects in the list using the object's toString method.
	 */
	//display the linked list
	public String toString(){
		Node current = first;
		String print = "";
		while (current!=null){
			print= print+current.object.toString()+"\n";
			current = current.link;
		}
		return print;
	}
	
	/**
	 * deletes the Pets node with the input key
	 * @param key id of pet object
	 */
	//delete node
	public void deleteNode(int key) {
		Node previous = first;
		Node current = first;
		// is the list empty
		if (current == null){
			System.out.println("Empty list");
			return;
		}
		
		// if there is an initialized Pets object attached to the node,
		// check if the id matches the key, and if so, return it.
		if ((Pets) current.object != null){
			while (current != null){
				if (((Pets) current.object).ID == key){
					previous.link = current.link;
				}
				previous = current;
				current = current.link;
			}
		}
		else{
			// else there are no pets with the matching id.
			System.out.println("No such key exists");
		}

	}
	
	/**
	 * traverses the list and returns the pet node with the matching key / pet id
	 * @param key
	 * @return node with Pet object of matching key, or null if not found.
	 */
	public Object findNode(int key) {
		Node current = first;
		
		// if there is an initialized Pets object attached to the node,
		// check if the id matches the key, and if so, return it.
		if ((Pets) current.object != null){
			while (current != null){
				if (((Pets) current.object).ID == key){
					return (Pets) current.object;
				}
				current = current.link;
			}
		}
		else{
			// else there are no pets with the matching id.
			System.out.println("No such key exists");
		}
		return null;
	}
	
}
