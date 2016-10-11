import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args){
		int[] test = {15, 2, 11, -4, -6, 13};
		selectionSort(test);
		System.out.println(Arrays.toString(test));
	}
	
	public static void selectionSort(int[] input){
		for (int left=0; left < input.length; left++){
			int min = left;
			for (int i = left; i<input.length; i++){
				if (input[i] < input[min]){
					min = i;
				}
			}
			int temp = input[left];
			input[left]=input[min];
			input[min] = temp;	
			System.out.print(Arrays.toString(input)+"-->");
		}
	}

}
