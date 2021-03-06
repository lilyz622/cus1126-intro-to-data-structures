
public class BT {
	public Node root;
	public int count = 0b0;
	
	public void add(int[] info){
		for (int i = 0; i<info.length; i++){
			add(info[i]);
		}
	}
	
	
	public void add(int info){
		Node newNode = new Node(info);
		if (root == null){
			root = newNode;
			count = 0b1;
			return;
		}
		
		Node current = root;
		count++;
		
		int countlength = Integer.toBinaryString(count).length();
		char[] charset = Integer.toBinaryString(count).toCharArray();
		int pointer = 1;
		Node parent = null;
		while (pointer <= countlength-1){
			
			parent = current;
			if (charset[pointer] == '0'){
				if (pointer == countlength-1){
					parent.leftChild = newNode;
				}
				current = current.leftChild;
			} else if (charset[pointer] == '1'){
				
				if (pointer == countlength-1){
					parent.rightChild = newNode;
				}
				current = current.rightChild;
			}
			pointer++;
		}
		
		
		
	}
	
	public void inOrderTraverse(Node current){
		if (current!= null){
			inOrderTraverse(current.leftChild);
			System.out.print(current.info+",");
			inOrderTraverse(current.rightChild);
		}
	}

}
