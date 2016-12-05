
public class Stack {
	public Node head;
	
	public void push(Node newNode){
		newNode.next = head;
		head = newNode;
	}
	
	public Node pop(){
		Node temp = head;
		head = head.next;
		return temp;
	}
	
	public Node peak(){
		return head;
	}
	
	public String toString(){
		Node current = head;
		String print = "";
		while (current != null){
			if (current.symbol != '\u0000') print += current.symbol+",";
			else print += current.num+",";
			current = current.next;
		}
		return print;
	}

}
