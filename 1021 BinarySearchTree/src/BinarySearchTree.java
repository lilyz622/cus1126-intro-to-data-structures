import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchTree {
	public Node root;

	public void insertNode(Pets pet) {
		Node newNode = new Node();
		newNode.pet = pet;
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
			if (newNode.pet.compareTo(current.pet) < 0) {
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

		System.out.println("Error adding new node:" + newNode.pet);
	}

	public Node findNode(int key) {
		Node current = root;

		while (current != null) {
			if (current.pet.ID == key) {
				return current;
			} else if (key < current.pet.ID) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
		}

		return null;
	}

	public void deleteNode(int key) {
		Node parent = null;
		Node target = findNode(key);
		if (target == null) {
			return;
		}
		Node current = root;

		while (!target.equals(current)) {
			if (target.pet.compareTo(current.pet) < 0) {
				parent = current;
				current = current.leftChild;
			} else {
				parent = current;
				current = current.rightChild;
			}
		}

		deleteNodeHelper(parent, target);
	}

	public void deleteNodeHelper(Node parent, Node current) {

		// once you find the target, test if it has children
		// if it has a child, replace it with child.

		// if target doesn't have children, just delete target.
		if (current.leftChild == null && current.rightChild == null) {
			current = null;
		}
		// if target doesn't have siblings, then target's children can become
		// parent's children
		else if (parent.rightChild == null || parent.leftChild == null) {
			parent.leftChild = current.leftChild;
			parent.rightChild = current.rightChild;
		}
		// if target only has one child, replace target with target's child
		else if (current.rightChild == null) {
			parent.leftChild = current.leftChild;
		} else if (current.leftChild == null) {
			parent.rightChild = current.rightChild;
		}
		// the last case is when target has siblings and two children.
		else {
			// if leftChild is taller, pick left
			// if rightChild is taller, pick right
			// default: pick right child for now
			current.pet = current.rightChild.pet;
			// repeat
			deleteNodeHelper(current, current.rightChild);
		}

	}

	public String toString() {
		ArrayList<String> print = new ArrayList<String>();
		Node parent = null;
		Node current = root;
		int level = 0;

		// toStringHelper(print, level, parent, current);

		String printAll = "";
		for (String str : print) {
			printAll += str + "\n";
		}

		return printAll;
	}

	public void toStringHelper(ArrayList<String> print, int level, Node parent, Node current) {
		try {
			print.get(level);
		} catch (IndexOutOfBoundsException e) {
			print.add(level, "");
		}

		if (current == null) {
			print.set(level, print.get(level) + "null \t");
			return;
		}

		// continue down tree
		print.set(level, print.get(level) + current.pet.ID + "\t");
		level++;
		toStringHelper(print, level, current, current.leftChild);
		toStringHelper(print, level, current, current.rightChild);

	}

	public void inOrderTraverse() {
		Node current = root;
		Node parent = null;
		
		ArrayList<Integer> print = new ArrayList<Integer>();
		inOrderTraverseHelper(parent, current, 0, print);
		
		System.out.println(print);
	}
	
	public void inOrderTraverseHelper(Node parent, Node current, int level, ArrayList<Integer> list){	
		if(current == null){
			return;
		}
		level ++;
		inOrderTraverseHelper(current, current.leftChild, level, list);
		list.add(current.pet.ID);
		inOrderTraverseHelper(current, current.rightChild, level, list);
		list.add(current.pet.ID);
		
	}

}
