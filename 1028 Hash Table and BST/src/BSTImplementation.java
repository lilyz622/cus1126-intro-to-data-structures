
public class BSTImplementation {
	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();
		tree.addNode(new Pet("A","A","Dog", Size.MEDIUM));
		System.out.println("We offset the first node we add to make a balanced tree.\n"
				+ "Offset root hash index:"+tree.getHash(tree.root.pet));
		tree.addNode(new Pet("B","B","Dog", Size.MEDIUM));
		tree.addNode(new Pet("C","C","Dog", Size.MEDIUM));
		tree.addNode(new Pet("D","D","Dog", Size.MEDIUM));
		tree.addNode(new Pet("E","E","Dog", Size.MEDIUM));
		tree.addNode(new Pet("F","F","Dog", Size.MEDIUM));
		
		System.out.println("We try to find a pet we haven't added to the tree.");
		Pet pet = new Pet("G","G","Dog", Size.MEDIUM);
		tree.findPet(pet);
		System.out.println("We try to find the same pet after we add it to the tree.");
		tree.addNode(pet);
		tree.findPet(pet);
		System.out.println("Below are the Pets and their hash codes:\n"+tree);
	}

}
