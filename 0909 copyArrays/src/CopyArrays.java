import java.util.Arrays;

/**
 * CopyArrays  copies elements from one source integer array of arbitrary size 
 * to another target array with twice the size if an overflow occurs.
 * Date: Sept. 9, 2016
 * @author yzhan265
 *
 */

public class CopyArrays {
	private static final int SOURCE_SIZE = 10; // size of initial array.
	private static final int[] SAMPLE_INPUT = {10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
	
	public static void main(String[] args){
		
		int[] sourceArray = new int[SOURCE_SIZE]; // source array
		int[] targetArray = new int[SOURCE_SIZE*2]; // target array
		int count = 0;
		
		System.out.println("You have an array of length:"+sourceArray.length);
		
		while (count < SAMPLE_INPUT.length){
			
			System.out.println("The "+(count+1)+" input is:"+SAMPLE_INPUT[count]);
			
			// if the input has reached the limit of the array size,
			// copy over the array into the new target array.
			if (count == sourceArray.length){
				System.out.println("Limit of the source array has been reached. Copying over array...");
				copyArrays(sourceArray, targetArray);
				targetArray[count] = SAMPLE_INPUT[count];
				System.out.println("Current array:"+Arrays.toString(targetArray));
			} else if (count < sourceArray.length){
				// if the input is less than the size of the source array, 
				// continue to add the input into the source array
				sourceArray[count] = SAMPLE_INPUT[count];
				System.out.println("Current array:"+Arrays.toString(sourceArray));
			} else if (count > sourceArray.length){
				// for the remaining inputs that are greater in size than the source array,
				// add these to the target array.
				targetArray[count] = SAMPLE_INPUT[count];
				System.out.println("Current array:"+Arrays.toString(targetArray));
			} else {
				System.out.println("There is an error in your code");
			}
			count++; //counter
		}
	}
	
	/**
	 * copies source array elements to the target array.
	 * @param source
	 * @param target
	 */
	public static void copyArrays (int[] source, int[] target){
		for (int i = 0; i<source.length; i++){
			target[i] = source[i];
		}
	}

}

/*
 * OUTPUT
 * You have an array of length:10
The 1 input is:10
Current array:[10, 0, 0, 0, 0, 0, 0, 0, 0, 0]
The 2 input is:11
Current array:[10, 11, 0, 0, 0, 0, 0, 0, 0, 0]
The 3 input is:12
Current array:[10, 11, 12, 0, 0, 0, 0, 0, 0, 0]
The 4 input is:13
Current array:[10, 11, 12, 13, 0, 0, 0, 0, 0, 0]
The 5 input is:14
Current array:[10, 11, 12, 13, 14, 0, 0, 0, 0, 0]
The 6 input is:15
Current array:[10, 11, 12, 13, 14, 15, 0, 0, 0, 0]
The 7 input is:16
Current array:[10, 11, 12, 13, 14, 15, 16, 0, 0, 0]
The 8 input is:17
Current array:[10, 11, 12, 13, 14, 15, 16, 17, 0, 0]
The 9 input is:18
Current array:[10, 11, 12, 13, 14, 15, 16, 17, 18, 0]
The 10 input is:19
Current array:[10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
The 11 input is:20
Limit of the source array has been reached. Copying over array...
Current array:[10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0]
The 12 input is:21
Current array:[10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 0, 0, 0, 0, 0, 0, 0, 0]
The 13 input is:22
Current array:[10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 0, 0, 0, 0, 0, 0, 0]
The 14 input is:23
Current array:[10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 0, 0, 0, 0, 0, 0]
The 15 input is:24
Current array:[10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 0, 0, 0, 0, 0]
The 16 input is:25
Current array:[10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 0, 0, 0, 0]
*/
