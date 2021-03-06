import java.util.Arrays;

public class SortingComparator {
	private final static int RANDOM_RANGE = 10000;

	public static void main(String[] args) {
		// creates two 2D ragged arrays
		// from experience, the threshold should be reached within arrays of
		// size 200 or smaller.
		int[][] testArrayMerge = createVariousArrays(1, 1, 200);
		int[][] testArrayInsertion = createVariousArrays(1, 1, 200);
		int threshold=-1;
		
		// the below loops through the first couple of arrays to demonstrate that the sorting 
		// methods work.
		for (int array = 1; array < 4; array++){
			System.out.println("Length "+testArrayMerge[array].length+":"+Arrays.toString(testArrayMerge[array]));
			long mergeSortTime = mergeSortHelp(testArrayMerge[array]);
			System.out.println("MERGE Sorted array:"+Arrays.toString(testArrayMerge[array]));
			System.out.println("MERGE Sorted time:"+mergeSortTime+"\n");
			
			System.out.println("Length "+testArrayInsertion[array].length+":"+Arrays.toString(testArrayInsertion[array]));
			long insertionSortTime = insertionSortHelp(testArrayInsertion[array]);
			System.out.println("INSERTION Sorted array:"+Arrays.toString(testArrayInsertion[array]));
			System.out.println("INSERTION Sorted time:"+insertionSortTime+"\n");
			
			// if the sort time for an array of a particular length is faster in merge
			// sort than in insertion sort, the threshold has been reached and we can
			// break out of the loop.
			if (isMergeFaster(mergeSortTime,insertionSortTime)){
				threshold = testArrayMerge[array].length;
				break;
			}
			
		}
		
		// the below tests for the threshold of when merge sort outperforms insertion sort.
		for (int array = 4; array < testArrayMerge.length; array++) {
			long mergeSortTime = mergeSortHelp(testArrayMerge[array]);
			long insertionSortTime = insertionSortHelp(testArrayInsertion[array]);
			
			System.out.println("Array size:" + testArrayMerge[array].length + "\tMergeSort:" + mergeSortTime
					+ "\tInsertionSort:" + insertionSortTime);
			
			// if the sort time for an array of a particular length is faster in merge
			// sort than in insertion sort, the threshold has been reached and we can
			// break out of the loop.
			if (isMergeFaster(mergeSortTime,insertionSortTime)){
				threshold = testArrayMerge[array].length;
				break;
			}
		}
		
		System.out.println("MergeSort is faster than InsertionSort for arrays greater than or equal to:"+threshold);
		
	}

	/**
	 * creates ragged 2D arrays of random integers starting with an array of size
	 * 'smallest' and incrementing size until the maximum size is reached.
	 * @param smallest array size
	 * @param increment array sizes
	 * @param max array size
	 * @return output ragged 2D array
	 */
	public static int[][] createVariousArrays(int smallest, int increment, int max) {
		// creates a [limit][n] array, where n will be the length of the random arrays
		// the two sorting methods will be testing.
		int currentSize = smallest;
		int limit = max / increment;
		int[][] output = new int[limit][]; 
		int count = 0;
		while (currentSize <= max) {
			output[count] = createRandomArray(currentSize);
			currentSize += increment;
			count++;
		}
		return output;
	}

	/**
	 * Creates an array of random integers of size length
	 * 
	 * @param length size of array
	 * @return random array of int
	 */
	public static int[] createRandomArray(int length) {
		int[] output = new int[length];
		for (int i = 0; i < output.length; i++) {
			output[i] = (int) (Math.random() * RANDOM_RANGE);
		}
		return output;
	}
	
	/**
	 * compares the merge and insertion sort times.
	 * @param mergeTime
	 * @param insertionTime
	 * @return whether mergesort was faster than insertionsort
	 */
	public static boolean isMergeFaster(long mergeTime, long insertionTime){
		if (mergeTime < insertionTime){
			return true;
		} else {
			return false;
		}
	}
	
	

	/*
	 * MERGE SORT
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static long mergeSortHelp(int[] input) {
		long startTime = System.nanoTime();
		mergeSort(input, 0, input.length - 1);
		long estimatedTime = System.nanoTime() - startTime;
		return estimatedTime;
	}

	public static void mergeSort(int input[], int low, int high) {
		if (low == high)
			return;
		int length = high - low + 1;
		int pivot = (low + high) / 2;
		mergeSort(input, low, pivot);
		mergeSort(input, pivot + 1, high);
		int working[] = new int[length];
		for (int i = 0; i < length; i++)
			working[i] = input[low + i];
		int m1 = 0;
		int m2 = pivot - low + 1;
		for (int i = 0; i < length; i++) {
			if (m2 <= high - low)
				if (m1 <= pivot - low)
					if (working[m1] > working[m2])
						input[i + low] = working[m2++];
					else
						input[i + low] = working[m1++];
				else
					input[i + low] = working[m2++];
			else
				input[i + low] = working[m1++];
		}
	}

	/*
	 * INSERTION SORT
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	/**
	 * insertionSort algorithm sorts and times the sorting, and adds this
	 * information to the records
	 * 
	 * @param ar
	 *            integers
	 */

	public static long insertionSortHelp(int[] input) {
		long startTime = System.nanoTime();
		insertionSort(input);
		long estimatedTime = System.nanoTime() - startTime;
		return estimatedTime;

	}

	public static void insertionSort(int[] input) {

		for (int i = 1; i < input.length; i++) {
			int index = input[i];
			int j = i;
			while (j > 0 && input[j - 1] > index) {
				input[j] = input[j - 1];
				j--;
			}
			input[j] = index;
		}

	}

}
