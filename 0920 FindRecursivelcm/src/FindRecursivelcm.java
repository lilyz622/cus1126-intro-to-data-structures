import java.util.Arrays;

/**
 * Project name: FindRecursivelcm
 * Description: Finds the least common multiple of two integers using recursion.
 * Date: Sept. 20, 2016
 * @author yzhan265
 *
 */
public class FindRecursivelcm {
	public static void main(String[] args){
		int[][] testSet = {
				{5,10}, // return 10
				{0,10}, // return 0
				{6,6}, // return 6
				{1,4}, // return 4
				{100,64} // return 1600
		};
		
		for( int i = 0; i< testSet.length; i++){
			System.out.println("The lcm of "+Arrays.toString(testSet[i])+ " is:"+lcm(testSet[i][0], testSet[i][1]));
		}
		
	}
	
	/**
	 * Calculates least common multiple of two integers.
	 * @param j first integer
	 * @param k second integer
	 * @return least common multiple of the two integers.
	 */
	public static int lcm(int j, int k){
		// determine which integer is bigger.
		if ( j >= k){
			return helpLcm(k,j, j);
		} else {
			return helpLcm(j,k, k);
		}
	}
	
	/**
	 * Calculates lcm based on smaller and larger integer.
	 * @param smaller input
	 * @param bigger input
	 * @param target trial lcm
	 * @return lcm
	 */
	public static int helpLcm(int smaller, int bigger, int target){
		if (smaller == 0){
			return 0;
		}
		
		if (smaller <= 0){
			throw new IllegalArgumentException("Cannot calculate lcm of numbers less than 0");
		}
		
		if (target%smaller == 0){
			return target;
		}
		else {
			return helpLcm(smaller, bigger, (bigger+target));
		}
	}

}
