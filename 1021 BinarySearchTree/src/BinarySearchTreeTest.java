
public class BinarySearchTreeTest {
	public static void main(String[] args){
		BinarySearchTree petTree = new BinarySearchTree();
		petTree.insertNode(new Pets("Cat", "Betty", 75));
		petTree.insertNode(new Pets("Dog", "Ace", 50));
		petTree.insertNode(new Pets("Bird", "Diana", 100));
		petTree.insertNode(new Pets("Snake", "Creepy", 25));
		petTree.insertNode(new Pets("Ant", "Elaine", 60));
		petTree.insertNode(new Pets("Ant", "Elaine", 55));
		petTree.insertNode(new Pets("Ant", "Elaine", 70));
		petTree.insertNode(new Pets("Ant", "Elaine", 72));
		
		petTree.inOrderTraverse();
		
		System.out.println(petTree.root.leftChild.rightChild.leftChild.pet);
		petTree.deleteNode(50);
		System.out.println(petTree.root.leftChild.leftChild.pet); // should be 25
		System.out.println(petTree.root.leftChild.pet); // should be 60
		System.out.println(petTree.root.leftChild.rightChild.pet); // should be 70
		System.out.println(petTree.root.leftChild.rightChild.leftChild.pet); //should be 55
	}

}
