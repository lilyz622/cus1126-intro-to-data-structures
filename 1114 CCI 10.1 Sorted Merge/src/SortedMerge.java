import java.util.Arrays;

public class SortedMerge {
	public static void main(String[] args){
		int[] a = {1,2,3,4,4,7,8,8,0,0,0,0,0,0};
		int[] b = {2,3,5,6,8,9};
		int aLength = a.length- b.length;
		mergeSort(a,b,aLength);
		System.out.println(Arrays.toString(a));
		
		
	}
	
	static void mergeSort(int[] a, int[] b, int aLength) {
		merge(a, b, aLength, aLength - 1, b.length - 1, a.length - 1);
	}

	static void merge(int[] a, int[] b, int aLength, int pa, int pb, int current) {
		while (pb >= 0 && pa >= 0) {
			if (b[pb] > a[pa]) {
				a[current] = b[pb];
				pb--;
			} else {
				a[current] = a[pa];
				pa--;
			}
			current--;
		}

		while (pb >= 0) {
			a[current] = b[pb];
			pb--;
		}
	}

}
