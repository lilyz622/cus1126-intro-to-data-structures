
public class List {
	public Node head;
	public Node tail;
	public void insertNode(int input){
		Node newNode = new Node();
		newNode.info = input;
		newNode.link = null;
		Node oldTail = tail;
		if (head == null){
			head = newNode;
			tail = head;
			oldTail = tail;
		} else {
			tail.link = newNode;
			tail = newNode;
		}
		System.out.println("Head:"+head.info+"\tOld Tail:"+oldTail.info+"\tNew Tail:"+tail.info);
	}
	
	public void sumLinkedList(Node current){
		Node temp = current;
		int sum = 0;
		while (temp != null){
			sum += temp.info;
			temp = temp.link;
		}
		System.out.println("The sum is:"+sum);
	}
	
	public void findForth(Node current){
		Node temp = current;
		int count = 1;
		while (count < 4 && temp != null){
			temp = temp.link;
			count++;
		}
		System.out.println("The "+count+" node has value:"+temp.info);
	}
	
	public void findEighth(Node current){
		int count=1;
		while (count <=8 && current!= null){
			if (count == 8){
				System.out.println("The "+count+" node has value:"+current.info);
			}
			current = current.link;
			count++;
		}
	}

}
