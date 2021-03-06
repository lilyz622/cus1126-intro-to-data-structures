import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortingArraysTry {
	private final static int RANDOM_RANGE = 10000;
	private static ArrayList<ArrayList<Long>> records;

	public static void main(String[] args) throws InterruptedException {
		// I created an arraylist of to record the runtime results.
		// each index of records corresponds with the power of ten
		// in that position. i.e. records.get(3) records the results
		// to sort a random array of size 10^3

		records = new ArrayList<ArrayList<Long>>();
		for (int i = 0; i <= 5; i++) {
			records.add(new ArrayList<Long>());
		}

		int[] ten = createRandomArray(10);
		int[] hundred = createRandomArray(100);
		int[] thousand = createRandomArray(1000);
		int[] tenThousand = createRandomArray(10000);
		int[] hundredThousand = createRandomArray(100000);
		mergeSortHelp(ten);
		mergeSortHelp(hundred);
		mergeSortHelp(thousand);
		mergeSortHelp(tenThousand);
		mergeSortHelp(hundredThousand);

		/*
		 * for (int i = 0; i < 100; i++) { int[] ten = createRandomArray(10);
		 * int[] hundred = createRandomArray(100); int[] thousand =
		 * createRandomArray(1000); int[] tenThousand =
		 * createRandomArray(10000); int[] hundredThousand =
		 * createRandomArray(100000); quickSortHelp(ten);
		 * quickSortHelp(hundred); quickSortHelp(thousand);
		 * quickSortHelp(tenThousand); quickSortHelp(hundredThousand); }
		 */

		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < records.get(i).size(); j++) {
				System.out.print(records.get(i).get(j) + ", ");
			}
			System.out.println();
		}
		calcAvg(records);

	}

	public static void mergeSortHelp(int[] input) {
		long startTime = System.nanoTime();
		mergeSort(input, 0, input.length - 1);
		long estimatedTime = System.nanoTime() - startTime;
		records.get((int) Math.log10(input.length)).add(estimatedTime);
		// System.out.println("The estimated time for array of length
		// 10^"+Math.log10(ar.length)+" is:"+estimatedTime);
	}

	public static void mergeSort(int a[], int low, int high) {
		if (low == high)
			return;
		int length = high - low + 1;
		int pivot = (low + high) / 2;
		mergeSort(a, low, pivot);
		mergeSort(a, pivot + 1, high);
		int working[] = new int[length];
		for (int i = 0; i < length; i++)
			working[i] = a[low + i];
		int m1 = 0;
		int m2 = pivot - low + 1;
		for (int i = 0; i < length; i++) {
			if (m2 <= high - low)
				if (m1 <= pivot - low)
					if (working[m1] > working[m2])
						a[i + low] = working[m2++];
					else
						a[i + low] = working[m1++];
				else
					a[i + low] = working[m2++];
			else
				a[i + low] = working[m1++];
		}
	}

	/**
	 * Creates an array of random integers of size length
	 * 
	 * @param length
	 *            size of array
	 * @return random array of int
	 */
	public static int[] createRandomArray(int length) {
		int[] output = new int[length];
		for (int i = 0; i < output.length; i++) {
			output[i] = (int) (Math.random() * RANDOM_RANGE);
		}
		System.out.println("Random Array: "+Arrays.toString(output));
		return output;
	}

	/**
	 * calculates the average of the runtimes to sort each array size and prints
	 * it out.
	 * 
	 * @param input
	 *            recorded times of insertionSort
	 */
	public static void calcAvg(ArrayList<ArrayList<Long>> input) {
		for (int j = 0; j < input.size(); j++) {
			if (input.get(j) != null) {
				double sum = 0;
				double count = 0;
				for (int k = 0; k < input.get(j).size(); k++) {
					sum += input.get(j).get(k);
					count++;
				}
				System.out.println("Avg time to sort 10^" + j + " element array is " + (sum / count));
			}
		}
	}

}

/*
 * 9032, 22169, 399856, 1163440, 10560874,
 */