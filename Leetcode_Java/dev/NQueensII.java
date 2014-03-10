package hack.leetcode.dev;

/*
 * 	Follow up for N-Queens problem.
 *	Now, instead outputting board configurations, return the total number of distinct solutions.0
 */
public class NQueensII {
	int res = 0;

	public int totalNQueens(int n) {
		res = 0;
		int[] A = new int[n];
		nQueens(A, 0, n);
		return res;
	}

	private void nQueens(int[] A, int idx, int n) {
		if (idx == n) {
			res++;
			return;
		} else {
			for (int i = 0; i < n; i++) {
				boolean ok = true;
				A[idx] = i;
				for (int j = 0; j < idx; j++) {
					if (Math.abs(idx - j) == Math.abs(A[idx] - A[j]) || A[idx] == A[j]) {
						ok = false;
						break;
					}
				}
				if (ok) {
					nQueens(A, idx + 1, n);
				}
			}
		}
	}
}
