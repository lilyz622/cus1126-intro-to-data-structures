public class BST {
	public Node root;

	public void addNode(Node node) {
		Node newNode = node;
		newNode.leftChild = null;
		newNode.rightChild = null;
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent = null;
			while (current != null) {
				parent = current;
				if (newNode.info < current.info) {
					current = current.leftChild;
					if (current == null)
						parent.leftChild = newNode;
				} else {
					current = current.rightChild;
					if (current == null)
						parent.rightChild = newNode;
				}
			}

		}
	}

	public Node deleteNode(Node target) {
		if (!findNode(target)) {
			return null;
		}
		int targetInfo = target.info;
		Node current = root;
		Node parent = null;
		while (current != null) {
			if (current == target) {
				Node temp = current;
				if (current.leftChild == null && current.rightChild == null){
					current = null;
				} else if (parent.leftChild == null || parent.rightChild == null) {
					parent.leftChild = current.leftChild;
					parent.rightChild = current.rightChild;
				} else if (current.leftChild == null) {
					if (current == parent.leftChild) {
						parent.leftChild = current.rightChild;
					} else {
						parent.rightChild = current.rightChild;
					}
				} else if (current.rightChild == null) {
					if (current == parent.leftChild) {
						parent.leftChild = current.leftChild;
					} else {
						parent.rightChild = current.leftChild;
					}
				} else {
					Node max = current.leftChild;
					Node maxParent = current;
					while (max.rightChild!= null){
						maxParent = max;
						max = max.rightChild;
					}
					if (max.leftChild != null){
						maxParent.rightChild = max.leftChild;
					} else {
						maxParent.rightChild = null;
					}
					max.leftChild = current.leftChild;
					max.rightChild = current.rightChild;
					if (current == parent.leftChild){
						parent.leftChild = max;
					} else {
						parent.rightChild = max;
					}
					System.gc();
				}
				return temp;
			} else {
				parent = current;
				if (targetInfo < current.info) {
					current = current.leftChild;
				} else {
					current = current.rightChild;
				}
			}
		}
		return current;
	}
	
	public Node findMax(Node current){
		Node parent = null;
		while (current!= null){
			parent = current;
			current = current.rightChild;
		}
		return parent;
	}

	public boolean findNode(Node node) {
		Node current = root;
		while (current != null) {

			if (current == node) {
				return true;
			} else {
				if (node.info < current.info)
					current = current.leftChild;
				else
					current = current.rightChild;
			}
		}
		return false;
	}
//	public int current=root.info;
	public int nodeFreq =0;
	public int max=root.info;
	public int maxFreq=0;
	public void inOrderTraverse(Node node) {
		if (node == null)
			return;
		if (node.leftChild!= null && node.leftChild.info == node.info){
			nodeFreq++;
			if (nodeFreq > maxFreq){
				maxFreq = nodeFreq;
				max = node.info;
			}
		}
		inOrderTraverse(node.leftChild);
		System.out.print(node.info + ",");
		inOrderTraverse(node.rightChild);
	}

	public void preOrderTraverse(Node node) {
		if (node == null)
			return;
		System.out.print(node.info + ",");
		preOrderTraverse(node.leftChild);
		preOrderTraverse(node.rightChild);
	}

	public void postOrderTraverse(Node node) {
		if (node == null)
			return;
		postOrderTraverse(node.leftChild);
		postOrderTraverse(node.rightChild);
		System.out.print(node.info + ",");
	}
	
	public void levelOrderTraverse(Node current, Node parent) {
		if (current == null)
			return;
		
		if(current == root) {
			System.out.print(current.info+",");
			levelOrderTraverse(current.leftChild, root);
			return;
		} 
		
		// start with left child
		System.out.print(current.info+",");
		if (current == parent.leftChild){
			levelOrderTraverse(parent.rightChild, parent);
		} else {
			levelOrderTraverse(parent.leftChild.leftChild,parent.leftChild);
		}
	}

}
