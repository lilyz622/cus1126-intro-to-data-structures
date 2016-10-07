import java.util.InputMismatchException;

/**
 * Project name: FindRecursiveHarmonicSum
 * Description: Finds harmonic sum using recursion with termination condition input = 1;
 * Date: Sept. 20, 2016
 * @author yzhan265
 *
 */
public class FindRecursiveHarmonicSum {
	public static void main(String[] args){
		System.out.println("The harmonic sum of "+1+" is:"+harmonicSum(1)); // returns 1.0
		System.out.println("The harmonic sum of "+2+" is:"+harmonicSum(2));	// returns 1.5
		System.out.println("The harmonic sum of "+50+" is:"+harmonicSum(50)); // returns 4.499205338329423
	}
	
	/**
	 * returns harmonic sum
	 * @param n input number
	 * @return double harmonic sum
	 */
	public static double harmonicSum(int n){
		if (n <= 0){
			throw new InputMismatchException("input cannot be less than 1.");
		}
		if (n == 1){
			return n;
		} 
		else {
			return (1.0/n + harmonicSum(n-1));
		}
	}

}
