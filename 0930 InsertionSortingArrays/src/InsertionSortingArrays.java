import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author yzhan265
 *
 */
public class InsertionSortingArrays {
	private final static int RANDOM_RANGE = 1000000000;	
	private static ArrayList<ArrayList<Long>> records;
	
	public static void main(String[] args){	
		records = new ArrayList<ArrayList<Long>>();
		for (int i = 0; i<=5; i++){
			records.add(new ArrayList<Long>());
		}
		
		for (int i =0; i< 1000; i++){
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
		}
		
		for (int i = 1; i<=5; i++){
			for (int j = 0; j<records.get(i).size(); j++){
				System.out.print(records.get(i).get(j)+", ");
			}
			System.out.println();
		}
		
		calcAvg(records);
		
	}
	
	public static int[] createRandomArray(int length){
		int[] output = new int[length];
		for(int i = 0; i< output.length; i++){
			output[i]= (int)Math.random()*RANDOM_RANGE;
		}
		return output;
	}
	
	public static void insertionSort(int ar[])
	{
		long startTime = System.nanoTime();
		
		 for (int i = 1; i < ar.length ; i++)
		 {
			 int index = ar[i];
			 int j = i;
			 while(j>0 && ar[j-1]>index)
			 {
				 ar[j] = ar[j-1];
				 j--;
			 }
			 ar[j] = index;
		 }
		 
	 	long estimatedTime = System.nanoTime() -startTime;
	 	records.get((int) Math.log10(ar.length)).add(estimatedTime);
//	 	System.out.println("The estimated time is :"+estimatedTime);
	 	
	 } 
	
	public static void calcAvg(ArrayList<ArrayList<Long>> input){
		for (int j = 0; j < input.size(); j++) {
			if (input.get(j) != null) {
				double sum = 0;
				double count = 0;
				for (int k = 5; k<input.get(j).size(); k++){
					sum += input.get(j).get(k);
					count++;
				}
				System.out.println("Avg time to sort 10^"+j+" element array is "+(sum/count));
			} 
		}
	}

}