
public class StackImplementation {
	public static void main(String[] args){
		StackLinkedList stack = new StackLinkedList();
		stack.push(new Patient(2342, "Jack Doe", "Diabetes", "M", 55342, 1908));
		stack.push(new Patient(8966, "Mary Jane", "NONE", "F", 33434, 23938));
		stack.push(new Patient(2312, "Killer Joe", "Hepatitis B", "M", 48594, 23932));
		stack.push(new Patient(6547, "Nikki Semantic", "NONE", "F", 35783, 9845));
		
		System.out.println("Stack after initial insertions:\n"+stack);
		
		System.out.println("Popped from stack: "+stack.pop());
		System.out.println("Popped from stack: "+stack.pop());
		System.out.println("Peeking:"+stack.peek());
		System.out.println("Stack after 2 pops and a peek:\n"+stack);
		
		stack.push(new Patient (65434, "Jane Fresco", "Asthma", "F", 67883, 9834));
		stack.push(new Patient (42332, "Foo Fighter", "Bronchitis", "M", 23874, 64376));
		System.out.println("Stack after pushing Jand and Foo:\n"+stack);
		
		System.out.println("Popped from stack: "+stack.pop());
		System.out.println("Peeking:"+stack.peek());
		System.out.println("Stack after 1 pop and peek\n"+stack);
	}

}
