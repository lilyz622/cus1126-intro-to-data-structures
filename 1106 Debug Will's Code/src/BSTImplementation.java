import java.util.*;

public class BSTImplementation {

	static Node1 root;

	public void addNode(int key, String name) {

		Node1 newNode1 = new Node1(key, name);

		if (root == null) {
			root = newNode1;
		}

		else {

			Node1 focusNode1 = root;

			Node1 parent;
			while (true) {

				parent = focusNode1;

				if (key < focusNode1.key) {

					focusNode1 = focusNode1.leftChild;

					if (focusNode1 == null) {

						parent.leftChild = newNode1;
						return;
					}
				}

				else {
					focusNode1 = focusNode1.rightChild;

					if (focusNode1 == null) {

						parent.rightChild = newNode1;
						return;
					}
				}
			}
		}
	}

	public void inOrderTraverseTree(Node1 focusNode1) {
		if (focusNode1 != null) {

			inOrderTraverseTree(focusNode1.leftChild);

			System.out.println(focusNode1);

			inOrderTraverseTree(focusNode1.rightChild);
		}
	}

	public void addNode1(Node1 node, int key) {
		// Create a new Node and initialize it
		Node1 newNode = node;
		newNode.key = key;
		// If there is no root this becomes root
		if (root == null) {
			root = newNode;
		}

		else {
			// Set root as the Node we will start
			// with as we traverse the tree
			Node1 focusNode = root;
			// Future parent for our new Node
			Node1 parent;
			while (true) {
				// root is the top parent so we start
				// there
				parent = focusNode;
				// Check if the new node should go on
				// the left side of the parent node

				if (key < focusNode.key) {
					// Switch focus to the left child
					focusNode = focusNode.leftChild;
					// If the left child has no children
					if (focusNode == null) {
						// then place the new node on the left of it
						parent.leftChild = newNode;
						return; // All Done
					}
				} else { // If we get here put the node on the right
					focusNode = focusNode.rightChild;
					// If the right child has no children
					if (focusNode == null) {
						// then place the new node on the right of it
						parent.rightChild = newNode;
						return; // All Done
					}
				}

			}
		}
	}

	public static void main(String[] args) {
		BSTImplementation theTree = new BSTImplementation();

		Node1 dog1 = new Node1("Fluffy", "poodle", "Mark");
		Node1 dog2 = new Node1("Noodle", "yorkie", "Bob");
		Node1 dog3 = new Node1("Baxter", "pitbull", "Nick");

		theTree.addNode1(dog1, 1);
		theTree.addNode1(dog2, 2);
		theTree.addNode1(dog3, 3);

		System.out.println("\nNode with the key 316");
		System.out.println(theTree.findNode(316));
		
		System.out.println("\nNode with the key 3");
		System.out.println(theTree.findNode(3));
	}

	public Node1 findNode(int targetKey) {
		// traverse tree -- this is pretty much the same to adding a new node
		// except we check if each node is equal to the targetKey
		// until we find a match or until we hit null, in which the node does not exist.
		
		if (root == null) {
			return null;
		}

		else {

			Node1 focusNode1 = root;

			Node1 parent;
			while (true) {

				parent = focusNode1;

				if (targetKey < focusNode1.key) {
					focusNode1 = focusNode1.leftChild;
				} else if (targetKey == focusNode1.key) {
					return focusNode1;
				} else {
					focusNode1 = focusNode1.rightChild;
				}

				if (focusNode1 == null) {
					return null;
				}
			}
		}

	}

}
