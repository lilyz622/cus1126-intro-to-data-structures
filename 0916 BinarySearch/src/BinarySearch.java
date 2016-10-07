
public class BinarySearch {
	public static void main(String[] args){
		int[] array = {1,6,8,10,14,22,30,50};
		int target = 30;
		System.out.println(target+" is found at index "+recursiveBinary(target, array, 0, array.length -1));
		
	}
	
	public static int recursiveBinary(int target, int[] array, int startIndex, int endIndex){

		int midpoint = (startIndex + endIndex)/2;
		
		// Termination condition.
		if (startIndex > endIndex){
			return -1;
		}
	
		//Condition if value found in binary search.
		System.out.println(array[midpoint]);
		if (target == array[midpoint]){
			return midpoint;
		}
		
		if (target < midpoint){
			System.out.println("Start:"+startIndex+"\tEnd:"+(midpoint-1));
			return recursiveBinary(target, array, startIndex, midpoint -1);
		} 
		
		if (target > midpoint){
			System.out.println("Start:"+(midpoint+1)+"\tEnd:"+endIndex);
			return recursiveBinary(target, array, midpoint+1, endIndex);
		}
		System.out.println(array[midpoint]);
		return -1;
	}
	
//	public static int iterativeBinary(int target, int[] array){
//		boolean found = false;
//		int midpoint
//		
//		while (!found){
//			currentI
//			if (target == array[currentIndex])
//		}
//		
//		return -1;
//	}

}
