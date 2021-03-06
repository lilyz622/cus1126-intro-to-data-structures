import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args){
		int[] test = {15, 2, 11, -4, -6, 13};
		insertionSort(test);
		System.out.print(Arrays.toString(test));
	}
	
	public static void insertionSort(int[] input){
		for (int next = 1; next < input.length; next++){
			int nextValue = input[next];
			int sorted = next;
			while ((sorted >0) && (nextValue < input[sorted-1])){
				input[sorted] = input[sorted-1];
				sorted--;
			}
			input[sorted]=nextValue;
			System.out.print(Arrays.toString(input)+"-->");
		}
	}

}
