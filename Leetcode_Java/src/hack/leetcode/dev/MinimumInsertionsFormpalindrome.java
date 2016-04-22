package hack.leetcode.dev;

/*
 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.

 Before we go further, let us understand with few examples:
 ab: Number of insertions required is 1. bab
 aa: Number of insertions required is 0. aa
 abcd: Number of insertions required is 3. dcbabcd
 abcda: Number of insertions required is 2. adcbcda which is same as number of insertions in the substring bcd(Why?).
 abcde: Number of insertions required is 4. edcbabcde
 */

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
 */
public class MinimumInsertionsFormpalindrome {

	/*
	 * Let the input string be str[l……h]. The problem can be broken down into
	 * three parts: 
	 * 1. Find the minimum number of insertions in the substring str[l+1,…….h]. 
	 * 2. Find the minimum number of insertions in the substring str[l…….h-1]. 
	 * 3. Find the minimum number of insertions in the substring str[l+1……h-1].
	 * 
	 * Recursive Solution The minimum number of insertions in the string
	 * str[l…..h] can be given as: minInsertions(str[l+1…..h-1]) if str[l] is
	 * equal to str[h] min(minInsertions(str[l…..h-1]),
	 * minInsertions(str[l+1…..h])) + 1 otherwise
	 */
	public int findMinInsertions(String str) {
		if (str == null || str.length() == 1) {
			return 0;
		}

		return helper(str.toCharArray(), 0, str.length() - 1);
	}
	
	private int helper(char[] chars, int left, int right) {
		if (left > right) {
			return Integer.MAX_VALUE;
		}

		if (left == right) {
			return 0;
		}

		if (left == right - 1) {
			return (chars[left] == chars[right]) ? 0 : 1;
		}

		return (chars[left] == chars[right]) 
				? helper(chars, left + 1, right - 1) 
				: (Math.min(helper(chars, left + 1, right), helper(chars, left, right - 1)) + 1);
	}
	
	/*
	 * We can create a table to store results of subproblems so that they can be
	 * used directly if same subproblem is encountered again.
	 * 
	 * The below table represents the stored values for the string abcde.
	 * 
	 * a b c d e 
	 * ---------- 
	 * 0 1 2 3 4 
	 * 0 0 1 2 3 
	 * 0 0 0 1 2 
	 * 0 0 0 0 1 
	 * 0 0 0 0 0
	 * 
	 * How to fill the table? The table should be filled in diagonal fashion.
	 * For the string abcde, 0….4, the following should be order in which the
	 * table is filled:
	 * 
	 * Gap = 1: (0, 1) (1, 2) (2, 3) (3, 4)
	 * 
	 * Gap = 2: (0, 2) (1, 3) (2, 4)
	 * 
	 * Gap = 3: (0, 3) (1, 4)
	 * 
	 * Gap = 4: (0, 4)
	 */
	public int findMinInsertionsDP(String str) {
		if (str == null || str.length() == 1) {
			return 0;
		}
		int len = str.length();
		char[] chars = str.toCharArray();
		int[][] dp = new int[len][len];

		int left = 0;
		int right = 0;

		for (int step = 1; step < len; step++) {
			for (left = 0, right = step; right < len; left++, right++) {
				dp[left][right] = (chars[left] == chars[right]) 
						? dp[left + 1][right - 1] 
						: Math.min(dp[left][right - 1], dp[left + 1][right]) + 1;
			}
		}
		
		return dp[0][len-1];
	}

	
	
	public static void main(String[] args){
		MinimumInsertionsFormpalindrome test = new MinimumInsertionsFormpalindrome();
		System.out.println(test.findMinInsertions("abcd"));
		System.out.println(test.findMinInsertionsDP("aabcd"));
	}
}
