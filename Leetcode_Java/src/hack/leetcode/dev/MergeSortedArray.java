package hack.leetcode.dev;

/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		if (n == 0) {
			return;
		}
		if (m == 0) {
			for (int i = 0; i < n; i++) {
				A[i] = B[i];
			}
			return;
		}

		int idxA = m - 1;
		int idxB = n - 1;
		int idx = m + n - 1;
		while (idxA >= 0 && idxB >= 0) {
			if (A[idxA] >= B[idxB]) {
				A[idx] = A[idxA];
				idxA--;
			} else {
				A[idx] = B[idxB];
				idxB--;
			}
			idx--;
		}

		while (idxA >= 0) {
			A[idx--] = A[idxA--];
		}

		while (idxB >= 0) {
			A[idx--] = B[idxB--];
		}

	}
}
