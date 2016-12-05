
public class Stack {
	public Node top;
	
	public void push(int diskNum){
		Node newNode = new Node();
		newNode.diskNum = diskNum;
		newNode.next = top;
		top = newNode;
	}
	
	public Node pop(){
		Node topNode = top;
		top = top.next;
		return topNode;
	}
	
	public Node peek(){
		return top;
	}
	
	public int height(){
		int height = 0;
		Node current = top;
		while (current!= null){
			height++;
			current = current.next;
		}
		return height;
	}
	
	public boolean isEmpty(){
		if (top == null)
			return true;
		return false;
	}
	
	
	public String toString(){
		Node current = top;
		String print = "";
		while (current != null){
			print = current.diskNum+"\t"+print;
			current = current.next;
		}
		return print;
	}
	

}
