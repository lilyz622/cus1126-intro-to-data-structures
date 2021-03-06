import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author yzhan265
 *
 */
public class InsertionSortingArraysTry {
	private final static int RANDOM_RANGE = 10000;	
	private static ArrayList<ArrayList<Long>> records;
	
	public static void main(String[] args) throws InterruptedException{	
		// I created an arraylist of to record the runtime results.
		// each index of records corresponds with the power of ten 
		// in that position. i.e. records.get(3) records the results
		// to sort a random array of size 10^3
		
		records = new ArrayList<ArrayList<Long>>();
		for (int i = 0; i<=5; i++){
			records.add(new ArrayList<Long>());
		}
		
		/*int[] ten = createRandomArray(10); 
		int[] hundred = createRandomArray(100); 
		int[] thousand = createRandomArray(1000); 
		int[] tenThousand = createRandomArray(10000); 
		int[] hundredThousand = createRandomArray(100000); 
		insertionSort(ten);
		insertionSort(hundred);
		insertionSort(thousand);
		insertionSort(tenThousand);
		insertionSort(hundredThousand);
		*/
		// I tried to write a method to run the sorting method multiple times in a loop
		// in order to get a more accurate average runtime,
		// however, each time the method ran, the time it took to ran decreased, and 
		// sometimes it took 0 seconds to run. So I will only record the time it takes
		// to sort each array the first time.
	
		for (int i =0; i< 10; i++){ 
			int[] ten = createRandomArray(10); 
			int[] hundred = createRandomArray(100); 
			int[] thousand = createRandomArray(1000); 
			int[] tenThousand = createRandomArray(10000); 
			int[] hundredThousand = createRandomArray(100000); 
			insertionSort(ten);
			insertionSort(hundred);
			insertionSort(thousand);
			insertionSort(tenThousand);
			insertionSort(hundredThousand);
			System.out.println(i);
		}
		
		for (int i = 1; i<=5; i++){
			for (int j = 0; j<records.get(i).size(); j++){
				System.out.print(records.get(i).get(j)+", ");
			}
			System.out.println();
		}
		
		calcAvg(records);
		
	}
	
	/**
	 * Creates an array of random integers of size length
	 * @param length size of array
	 * @return random array of int
	 */
	public static int[] createRandomArray(int length){
		int[] output = new int[length];
		for(int i = 0; i< output.length; i++){
			output[i]= (int)(Math.random()*RANDOM_RANGE)+1;
		}
//		System.out.println("Random Array: "+Arrays.toString(output));
		return output;
	}
	
	/**
	 * insertionSort algorithm sorts and times the sorting, and adds this information to the records
	 * @param ar integers
	 */
	
	public static void insertionSort(int[] input)
	{
		long startTime = System.nanoTime();
		
		 for (int i = 1; i < input.length ; i++)
		 {
			 int index = input[i];
			 int j = i;
			 while(j>0 && input[j-1]>index)
			 {
				 input[j] = input[j-1];
				 j--;
			 }
			 input[j] = index;
		 }
		 
	 	long estimatedTime = System.nanoTime() -startTime;
	 	records.get((int) Math.log10(input.length)).add(estimatedTime);
//	 	System.out.println("The estimated time for array of length 10^"+Math.log10(input.length)+" is:"+estimatedTime);
//	 	System.out.println("Sorted Array:"+Arrays.toString(input));
	 } 
	
	/**
	 * calculates the average of the runtimes to sort each array size and prints it out.
	 * @param input recorded times of insertionSort
	 */
	public static void calcAvg(ArrayList<ArrayList<Long>> input){
		for (int j = 0; j < input.size(); j++) {
			if (input.get(j) != null) {
				double sum = 0;
				double count = 0;
				for (int k = 0; k<input.get(j).size(); k++){
					sum += input.get(j).get(k);
					count++;
				}
				System.out.println("Avg time to sort 10^"+j+" element array is "+(sum/count));
			} 
		}
	}

}

/*
2463, 
6979, 
65685, 
520962, 
4444393, */