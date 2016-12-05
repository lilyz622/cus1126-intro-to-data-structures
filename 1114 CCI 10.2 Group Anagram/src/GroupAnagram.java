import java.util.Arrays;

public class GroupAnagram {

	public static void main(String[] args) {
//		char a = 'a';
//		int a0 = (int) a;
//
//		System.out.println(a0 + "," + ((int) 'A'));
//
//		String abc = "abc";
//		int abc0 = abc.hashCode();
//		int bac0 = "bac".hashCode();
//		System.out.println(abc0 + "," + bac0);
		
		String[] a = {
				"abbc",
				"shfdsf",
				"cat",
				"that",
				"bbac",
				"ffdssh"
		};
		
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}

	static int getHashCode(String s) {
		int current = 0;
		int hash = 0;
		while (current < s.length()) {
			// anagrams get assigned the same hashcode.
			hash += getHashCode(s.charAt(current));
			current++;
		}
		System.out.println(s+":"+hash);
		return hash;
	}

	static int getHashCode(char c) {
		int offset = (int) 'z' - (int) 'a';
		// we assume that the maximum number of times a letter is //repeated is
		// 10.
		int hash = 31 * ((int) c - offset);
		return hash;
	}

	static void mergeSort(String[] a) {
		String[] helper = new String[a.length];
		mergeSort(a, helper, 0, a.length - 1);
	}

	static void mergeSort(String[] a, String[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergeSort(a, helper, low, middle);
			mergeSort(a, helper, middle + 1, high);
			merge(a, helper, low, middle, high);
		}
	}

	static void merge(String[] a, String[] helper, int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = a[i];
		}
		int left = low;
		int right = middle + 1;
		int current = low;
		while (left <= middle && right <= high) {
			int rightHash = getHashCode(helper[right]);
			int leftHash = getHashCode(helper[left]);
			if (rightHash < leftHash) {
				a[current] = helper[right];
				right++;
			} else {
				a[current] = helper[left];
				left++;
			}
			current++;
		}

		int remaining = middle-left;
		for (int i = 0; i <= remaining; i++) {
			a[i+current] = helper[i+left];
		}
	}

}
