
public class StackArithmetic {
	public static void main(String[] args) {
		System.out.println("ANSWER:"+evaluate("3*12+4-5+10"));
		System.out.println("\n\nANSWER:"+evaluate("12/4+8*3-2+9"));

	}
	
	public static int evaluate(String expression){
		Stack numbers = new Stack();
		Stack operations = new Stack();
		char[] input = expression.toCharArray();
		int temp = 0;
		int digit = 0;
		for (int i = input.length-1; i>=0; i--){
			if ((int)input[i]< (int)'0' || (int)input[i]>(int)'9'){
				// is an operation
				digit = 0;
				numbers.push(new Node(temp));
				operations.push(new Node(input[i]));
				temp = 0;
			} else {
				// is a digit between 0 and 9
				temp = temp + (int)Math.pow(10, digit)*((int)input[i]-(int)'0');
				digit = 1;
			}
		}
		numbers.push(new Node(temp));
		
		System.out.println();
		System.out.println(numbers);
		System.out.println(operations);
		System.out.println();
		return calculate(operations, numbers);
		
	}
	
	public static int calculate (Stack sym, Stack num){
		Node curExp = sym.head;
		Stack tempSym = new Stack();
		Stack tempNum = new Stack();
		int ans = 0;
		if (curExp == null){
			return num.head.num;
		}
		while (curExp != null){
			char curSym = sym.pop().symbol;
//			System.out.println(curSym);
			if (curSym == '*'){
				int a = num.pop().num;
				int b = num.pop().num;
				ans = a*b;
				num.push(new Node(ans));
				System.out.println("Multiplied "+ a+" and "+b+", answer is now:"+ans);
			} else if (curSym =='/'){
				int a = num.pop().num;
				int b = num.pop().num;
				ans = a/b;
				num.push(new Node(ans));
				System.out.println("Divided "+ a+" and "+b+", answer is now:"+ans);
			} else {
				if (curExp.next != null && (curExp.next.symbol == '*' || curExp.next.symbol == '/')){
					char tempC = curSym;
					int tempN = num.pop().num;
					int tempAns = calculate(sym, num);
					num.push(new Node(tempAns));
					num.push(new Node(tempN));
					sym.push(new Node(tempC));
				} else if (curSym =='-'){
					int a = num.pop().num;
					int b = num.pop().num;
					ans = a-b;
					num.push(new Node(ans));
					System.out.println("Subtracted "+ a+" and "+b+", answer is now:"+ans);
				} else {
					int a = num.pop().num;
					int b = num.pop().num;
					ans = b+a;
					num.push(new Node(ans));
					System.out.println("Added "+ a+" and "+b+", answer is now:"+ans);
				}
				
			}
			curExp = sym.head;
				
		}
		
		return ans;
		
	}

}
