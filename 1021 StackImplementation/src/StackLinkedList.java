
public class StackLinkedList {
	public Patient head;
	public Patient tail;

	public void push(Patient patient) {
		Patient newNode = patient;
		newNode.next = null;
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public Patient peek() {
		Patient current = tail;
		return current;
	}

	public Patient pop() {
		Patient current = head;
		Patient previous = null;
		if (current.next == null){
			head = null;
			tail = null;
		}
		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		Patient temp = current;
		previous.next = null;
		tail = previous;
		return temp;

	}
	
	public String toString(){
		Patient current = head;
		String print = "";
		while (current != null){
			print += current.toString()+"\n";
			current = current.next;
		}
		return print;
	}

}
