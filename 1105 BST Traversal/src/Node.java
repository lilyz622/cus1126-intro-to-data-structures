public class Node {
	public int info;
	public Node leftChild;
	public Node rightChild;

	public Node(int info) {
		this.info = info;
		leftChild = rightChild = null;
	}
}