package solution;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitionII {
	public int minCut(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}
		int[] minCuts = new int[s.length() + 1];
		for (int i = 0; i < minCuts.length; i++) {
			minCuts[i] = s.length() - i;
		}
		boolean[][] isPal = new boolean[s.length()][s.length()];

		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPal[i + 1][j - 1])) {
					isPal[i][j] = true;
					minCuts[i] = Math.min(minCuts[i], minCuts[j + 1] + 1);
				}
			}
		}

		return minCuts[0] - 1;
	}
}
