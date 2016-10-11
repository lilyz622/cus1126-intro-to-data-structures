public class List{
	public static Node first = null;
	public static Node last = null;
	
	public static void insertNode(String fname, String lname, int age){
		Node newNode = new Node();
		newNode.firstName = fname;
		newNode.lastName = lname;
		newNode.age = age;
		newNode.link =null;
		
		//Check if list is empty
		if(first==null){
			first=newNode;
			last=newNode;
		}
		else{
			last.link= newNode;
			last=newNode;
		}
			
	}
	//delete a node
	public static void deleteNode(String fname, String lname, int targetAge){
		Node previous = first;
		Node current = first;
		// is the list empty
		if (current == null){
			System.out.println("Empty list");
			return;
		}
		
		// check if the attributes matches the key, and if so, return it.
		
			while (current != null){
				if (current.age == targetAge){
					previous.link = current.link;
				}
				previous = current;
				current = current.link;
			}
		
	}
	
	//display the linked list
	public static void display(){
		Node current = first;
		while(current!=null){
			System.out.println(current.firstName+ " " +current.lastName+" " +current.age);
			current=current.link;
		}
	}
	
	
	
	public static void main(String [] args){
		//adding elements to list
		insertNode("Travis", "CUS1126", 20);
		insertNode("Chris", "CUS1126", 22);
		insertNode("Yi Yi", "CUS1126", 19);
		display();
		
		System.out.println("\nAfter we delete Chris we have:");
		deleteNode("Chris", "CUS1126", 22);
		display();
	}
}