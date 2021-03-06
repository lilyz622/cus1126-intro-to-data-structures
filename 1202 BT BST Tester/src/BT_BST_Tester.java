import java.util.Arrays;

public class BT_BST_Tester {
	public static void main(String[] args)
	{
		BST bst = new BST();
		int[] array = {100, 51, 151, 42, 72, 182, 142, 93,43,23};
		bst.add(array);
		System.out.println("We add the same set of values to both trees.\n"
				+Arrays.toString(array)+"\n\n"
				+ "Binary Search Tree inOrderTraverse:");
		bst.inOrderTraverse(bst.root);
		System.out.println();
		
		BT bt = new BT();
		bt.add(array);
		System.out.println("\nBinary Tree inOrderTraverse:");
		bt.inOrderTraverse(bt.root);
		System.out.println("\n");
		
		System.out.println(bst.getClass()+" is a bst:"+bstTest(bst.root));
		System.out.println(bt.getClass()+" is a bst:"+bstTest(bt.root));
	}
	
	public static boolean bstTest(Node current){
		if (current!= null){
			
			if (current.leftChild!= null){
				if (current.info <= current.leftChild.info){
					return false;
				} 
				return bstTest(current.leftChild);
			}
			if (current.rightChild!= null){
				if (current.info > current.rightChild.info){
					return false;
				}
				return bstTest(current.rightChild);
			}
			
		}
		return true;
	}
}
