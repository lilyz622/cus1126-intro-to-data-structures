
public class LinkedListTest {
	public static void main(String[] args){
		List linkedList = new List();
		int[] array = {6, 16, 15, 4, 5};
		for (int element: array){
			linkedList.insertNode(element);
		}
		
		linkedList.sumLinkedList(linkedList.head);
		linkedList.findForth(linkedList.head);
	}

}