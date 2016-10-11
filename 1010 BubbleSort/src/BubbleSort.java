import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] arg){
		int[] test = {5,9,2,-2,0,4};
		bubbleSort(test);
		System.out.println(Arrays.toString(test));
	}
	
	public static void bubbleSort(int[] input){
		for (int each=0; each < input.length; each++){
			for (int other = each +1; other < input.length; other ++){
				if (input[each] > input[other]){
					int temp = input[other];
					input[other]= input[each];
					input[each]= temp;
				}
			}
		}
	}

}
