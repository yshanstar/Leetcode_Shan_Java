package hack.leetcode.dev;

/*
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = A.length, n = B.length;
		assert (m + n > 0);

		if (m == 0)
			return n % 2 == 1 ? B[n / 2] : (double) (B[n / 2 - 1] + B[n / 2]) / 2.;
		if (n == 0)
			return m % 2 == 1 ? A[m / 2] : (double) (A[m / 2 - 1] + A[m / 2]) / 2.;

		int temp = findKthPosition(A, B, (m + n) / 2 + 1);
		if (temp < 0) {
			temp = findKthPosition(B, A, (m + n) / 2 + 1);
			temp = B[temp];
		} else {
			temp = A[temp];
		}
		int temp1 = temp;
		if ((m + n) % 2 == 0) {
			temp1 = findKthPosition(A, B, (m + n) / 2);
			if (temp1 < 0) {
				temp1 = findKthPosition(B, A, (m + n) / 2);
				temp1 = B[temp1];
			} else {
				temp1 = A[temp1];
			}
		}
		return (double) (temp + temp1) / 2.;
	}

	public int findKthPosition(int A[], int B[], int k) {
		int start = 0, end = A.length - 1;
		while (start <= end) {
			int cur = (start + end) / 2;
			if (cur < k && k <= B.length + cur + 1 && (k == cur + 1 || A[cur] >= B[k - 2 - cur]) && (k > cur + B.length || A[cur] <= B[k - 1 - cur])) {
				return cur;
			} else if (cur >= k || (k <= cur + B.length && A[cur] > B[k - 1 - cur])) {
				end = cur - 1;
			} else {
				start = cur + 1;
			}
		}
		return -1;
	}
}
