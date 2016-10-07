
public class LinearSearch {
	public static void main(String[] args){
		int[] trial= {10,7,1,3,-4,2,20};
		int searchInt = 4;
		System.out.println(searchInt+" is at index "+linearSearch(searchInt, trial));
	}
	
	public static int linearSearch(int target, int[] input){
		
		for (int i = 0; i < input.length; i++){
			if (input[i]==target){
				return i;
			}
		}
		
		return -1;
	}

}
