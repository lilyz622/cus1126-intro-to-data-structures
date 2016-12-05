import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args){
		int[] even = {63,	40,	35,	77,	95,	77,	25,	25,	40,	35,	15,	24,	68,	69,	58,	37,	4,	29,	14,	90,	48,	53,	95,	79,	22,
				6,	94,	31,	66,	74,	16,	7,	12,	30,	68,	14,	17,	90,	53,	61,	91,	69,	41,	2};
		quickSort(even,0, even.length-1);
		System.out.println(Arrays.toString(even));
	}
	
	public static void quickSort(int[] input, int start, int end){
		if (start >= end){
			return;
		}
		int pivot = input[end];
		int left = 0;
		int right = 0;
		int pointer = start;
		while (pointer <end){
			if (input[pointer] > pivot){
				right++;
			} else {
				if (right > 0){
					int temp = input[left+start];
					input[left+start] = input[pointer];
					input[pointer]= temp;
				}
				left++;
			}
			pointer++;
		}
		
		int temp = input[left+start];
		input[left+start]= pivot;
		input[end]= temp;
//		System.out.println(Arrays.toString(input));
//		int[] leftArray = Arrays.copyOfRange(input, 0,left);
//		int[] rightArray = Arrays.copyOfRange(input, left+1, input.length);
//		System.out.println("Left Array:"+Arrays.toString(leftArray));
//		System.out.println("Right Array:"+Arrays.toString(rightArray));
		System.out.println("Pivot:"+(start+left)+"\tLeft:["+start+","+(start+left-1)+"]\tRight:["+(start+left+1)+","+end+"]");
		quickSort(input,start,start+left-1);
		quickSort(input,start+left+1,end);
		
		
	}

}
