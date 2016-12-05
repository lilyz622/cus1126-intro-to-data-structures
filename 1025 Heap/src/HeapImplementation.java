
public class HeapImplementation {
	public static void main(String[] args){
		MinPriorityQueue queue = new MinPriorityQueue();
		queue.addNode(50);
		queue.addNode(100);
		queue.addNode(130);
		System.out.println(queue);
		queue.addNode(40);
		System.out.println(queue);
		queue.addNode(30);
		System.out.println(queue);
		queue.addNode(60);
		System.out.println(queue);
		queue.addNode(20);
		System.out.println(queue);
		queue.pull();
		System.out.println(queue);
		queue.addNode(10);
		System.out.println(queue);
		queue.addNode(110);
		queue.addNode(130);
		queue.addNode(140);
		queue.addNode(20);
		System.out.println(queue);
	}

}
