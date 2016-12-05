
public class BSTImplementation {
	public static void main(String[] args){
		BST tree = new BST();
		tree.addNode(new Node(64));
		Node test = new Node(32);
		tree.addNode(test);
		tree.addNode(new Node(16));
		tree.addNode(new Node(48));
		tree.addNode(new Node(96));
		tree.addNode(new Node(8));
		tree.addNode(new Node(24));
		tree.addNode(new Node(36));
		tree.addNode(new Node(56));
		tree.addNode(new Node(80));
		tree.addNode(new Node(112));
		tree.inOrderTraverse(tree.root);
		System.out.println();
		System.out.println(tree.root.leftChild.rightChild.info);
		tree.deleteNode(test);
		System.out.println(tree.root.leftChild.info);
		tree.addNode(new Node(20));
		tree.inOrderTraverse(tree.root);
		System.out.println();
		tree.preOrderTraverse(tree.root);
		System.out.println();
		tree.postOrderTraverse(tree.root);
		System.out.println();
		tree.levelOrderTraverse(tree.root, null);
	}

}
