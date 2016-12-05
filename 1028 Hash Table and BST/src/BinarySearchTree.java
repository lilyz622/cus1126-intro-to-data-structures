
public class BinarySearchTree {
	public BstNode root;
	private final int HASH_SIZE = 50;
	private int offsetHash = 0;
	
	public int getHash(Pet pet){
		String hashString = pet.pName+pet.breed+pet.owner;
		int hash = hashString.hashCode();
		int index = Math.abs((hash+offsetHash)%(HASH_SIZE));
		return index;
	}
	
	// add
	public void addNode(Pet pet){
		BstNode newNode = new BstNode();
		newNode.pet = pet;
		if (root == null){
			root = newNode;
			offsetHash = 25 - getHash(pet); // sets the first node to 25 in order to build a balanced bst.
		} else {
			BstNode current = root;
			BstNode parent = null;
			int hash = getHash(pet);
			while (current!= null){
				parent = current;
				if (hash < getHash(parent.pet)){
					current = current.leftChild;
					if (current == null){
						parent.leftChild = newNode;
					}
				} else {
					current = current.rightChild;
					if (current == null){
						parent.rightChild = newNode;
					}
				}
			}
		}
		
	}
	// print
	public String toString(){
		String print = "";
		BstNode current = root;
		helpToString(print, current);
		return print;
		
	}
	
	private void helpToString(String print, BstNode current){
		if (current == null){
			return;
		}
		System.out.print("\n"+current.pet.pName + ": "+getHash(current.pet));
		helpToString(print,current.leftChild);
		helpToString(print,current.rightChild);
	}
	
	// search
	public boolean findPet(Pet pet){
		BstNode current = root;
		String path = "root";
		boolean found = false;
		while (current != null && !found){
			if (getHash(pet)<getHash(current.pet)){
				current = current.leftChild;
				path+=".leftChild";
			} else if (getHash(pet)<getHash(current.pet)){
				current = current.rightChild;
				path+=".rightChild";
			} else {
				System.out.println("FOUND Path:"+path);
				return true;
			}
		}
		System.out.println("NOT FOUND");
		return found;
	}
	
	
}
