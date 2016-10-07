
public class List {
	public static Node last=null;
	public static Node first=null;
	
	public static void insertNode(String fname, String lname, int age){
		Node newNode = new Node();
		newNode.firstName = fname;
		newNode.lastName = lname;
		newNode.age = age;
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
	
	
	
	public static void main(String[] args){
		// adding elements to list
		insertNode("Travis","CUS1126",20);
		insertNode("Chris","CUS1126",21);
		insertNode("Yi Yi","CUS1126",19);
		display();
		deleteNode("Chris","CUS1126",21);
		first.link = first.link.link;
		display();
	}
	
	//display the linked list
	public static void display(){
		Node current = first;
		while (current!=null){
			System.out.println(current.firstName+" "+current.toString());
			current = current.link;
		}
		
	}
	
	//delete node
	public static void deleteNode(String fname, String lname, int age){
		Node current = first;
		// is the list empty
		if (current == null){
			System.out.println("Empty list");
			return;
		}
		
		int count = 0;
		while (current!=null){
			if (current.age == age){
				for (int i = 0; i <=count; count++){
					first.link;
				}
			}
			count ++;
			current = current.link;
		}
	}
	
	
}
