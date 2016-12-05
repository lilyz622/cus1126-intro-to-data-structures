
public class LinkedListTest {
	public static void main(String[] args){
		List linkedList = new List();
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		for (int element: array){
			linkedList.insertNode(element);
		}
		
		linkedList.sumLinkedList(linkedList.head);
		linkedList.findForth(linkedList.head);
		linkedList.findEighth(linkedList.head);
	}

}
