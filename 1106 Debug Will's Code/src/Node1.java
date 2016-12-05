public class Node1 {

	int key;
	String name;
	String name2;
	String name3;
	Node1 leftChild;
	Node1 rightChild;

	public Node1(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public Node1(String nameInput, String name2Input, String name3Input) {
		name = nameInput;
		name2 = name2Input;
		name3 = name3Input;
	}

	public String toString() {
		return name + " has the key " + key;

	}
}
