
public class BST {
	public Node root;
	
	public void add(int[] info){
		for (int i = 0; i<info.length; i++){
			add(info[i]);
		}
	}

	public void add(int info) {
		Node newNode = new Node(info);
		newNode.leftChild = null;
		newNode.rightChild = null;

		if (root == null) {
			root = newNode;
			return;
		}

		Node current = root;
		Node parent = null;

		while (current != null) {
			// traverse tree
			parent = current;
			if (newNode.info < current.info) {
				current = current.leftChild;
				if (current == null) {
					current = newNode;
					parent.leftChild = current;
					return;
				}
			} else {
				current = current.rightChild;
				if (current == null) {
					current = newNode;
					parent.rightChild = current;
					return;
				}
			}
		}

		System.out.println("Error adding new node:" + newNode.info);
	}
	public void inOrderTraverse(Node current) {
		if (current!= null){
			inOrderTraverse(current.leftChild);
			System.out.print(current.info+",");
			inOrderTraverse(current.rightChild);
		}
	}
	

}
