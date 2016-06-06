package hack.leetcode.dev;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".

 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
	public static String minWindow(String S, String T) {
		int sLen = S.length();
		int tLen = T.length();
		int[] needToFind = new int[256];

		for (int i = 0; i < tLen; i++) {
			needToFind[T.charAt(i)]++;
		}

		int[] hasFound = new int[256];
		int minWindowLen = Integer.MAX_VALUE;
		int minWindowBegin = 0;
		int minWindowEnd = 0;

		int count = 0;
		for (int start = 0, end = 0; end < sLen; end++) {
			if (needToFind[S.charAt(end)] == 0) {
				continue;
			}
			hasFound[S.charAt(end)]++;
			if (hasFound[S.charAt(end)] <= needToFind[S.charAt(end)]) {
				count++;
			}

			if (count == tLen) {
				while (needToFind[S.charAt(start)] == 0 || hasFound[S.charAt(start)] > needToFind[S.charAt(start)]) {
					if (hasFound[S.charAt(start)] > needToFind[S.charAt(start)])
						hasFound[S.charAt(start)]--;
					start++;
				}
				int windowLen = end - start + 1;
				if (windowLen < minWindowLen) {
					minWindowBegin = start;
					minWindowEnd = end;
					minWindowLen = windowLen;
				}
			}
		}
		return (count == tLen) ? S.substring(minWindowBegin, minWindowEnd + 1) : "";
	}

	public static void main(String[] args) {
		System.out.println(minWindow("aa", "aa"));
	}
}
