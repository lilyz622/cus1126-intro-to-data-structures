import java.util.ArrayList;
public class MinPriorityQueue {
	public Node root;
	
	public ArrayList<Node> queue = new ArrayList<Node>();
	
	public void addNode(int num){
		Node newNode = new Node();
		newNode.info = num;
		if (queue.isEmpty()){
			queue.add(null);
			queue.add(newNode);
			return;
		}
		queue.add(newNode);
		int newIndex = queue.size()-1;
		int currentIndex = newIndex;
		while (getParent(currentIndex)!= 0 && queue.get(currentIndex).info < queue.get(getParent(currentIndex)).info){
			// switch node at current index with node at parent index
			Node temp = queue.get(getParent(currentIndex));
			queue.set(getParent(currentIndex), queue.get(currentIndex));
			queue.set(currentIndex, temp);
			currentIndex = getParent(currentIndex);
			
		}
	}
	
	public int getParent(int currentIndex){
		return (currentIndex)/2;
	}
	
	public Node pull(){
		Node temp = queue.get(1);
		queue.set(1, queue.get(queue.size()-1));
		queue.remove(queue.size()-1);
		Node current = queue.get(1);
		int curIndex = 1;
		while (current != null){
			
			if (((int) Math.pow(2, curIndex) + 1) <= queue.size()-1) {
				Node leftChild = queue.get((int) Math.pow(2, curIndex));
				Node rightChild = queue.get((int) Math.pow(2, curIndex) + 1);
				if (leftChild.info < rightChild.info) {
					if (current.info > leftChild.info) {
						queue.set((int) Math.pow(2, curIndex), current);
						queue.set(curIndex, leftChild);
						curIndex = 2 * curIndex;
					}
				} else {
					if (current.info > rightChild.info) {
						queue.set((int) Math.pow(2, curIndex)+1, current);
						queue.set(curIndex, rightChild);
						curIndex = 2 * curIndex + 1;
					}
				}
				current = queue.get(curIndex);
			}
			else if (((int) Math.pow(2, curIndex)) <= queue.size()-1){
				Node leftChild = queue.get((int) Math.pow(2, curIndex));
				if (current.info > leftChild.info) {
					queue.set((int) Math.pow(2, curIndex), current);
					queue.set(curIndex, leftChild);
					curIndex = 2 * curIndex;
				}
				break;
			} else {
				break;
			}
			
		}
		return temp;
		
	}
	
	public String toString(){
		return queue.toString();
	}

}
