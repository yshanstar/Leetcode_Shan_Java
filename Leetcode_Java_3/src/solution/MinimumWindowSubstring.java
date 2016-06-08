package solution;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
		if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
			return s;
		}

		String res = "";

		int[] needToFind = new int[256];
		int[] hasFound = new int[256];

		for (char c : t.toCharArray()) {
			needToFind[c]++;
		}

		int start = 0;
		int end = 0;

		int count = 0;
		for (end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			if (needToFind[c] == 0) {
				continue;
			}

			hasFound[c]++;
			if (hasFound[c] <= needToFind[c]) {
				count++;
			}

			if (count == t.length()) {
				char startC = s.charAt(start);
				while (needToFind[startC] == 0 || hasFound[startC] > needToFind[startC]) {
					if (hasFound[startC] > needToFind[startC]) {
						hasFound[startC]--;
					}
					startC = s.charAt(++start);
				}

				int windowLen = end - start + 1;
				if (res.isEmpty() || windowLen < res.length()) {
					res = s.substring(start, end + 1);
				}
			}
		}

		return res;
	}

	public static String minWindow2(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();

		int[] needToFind = new int[256];
		for (char c : t.toCharArray()) {
			needToFind[c]++;
		}

		int[] hasFound = new int[256];
		int res = Integer.MAX_VALUE;
		int minStart = 0;
		int minEnd = 0;

		int count = 0;
		for (int start = 0, end = 0; end < sLen; end++) {
			char c = s.charAt(end);
			if (needToFind[c] == 0) {
				continue;
			}
			hasFound[c]++;
			if (hasFound[c] <= needToFind[c]) {
				count++;
			}

			if (count == tLen) {
				char startC = s.charAt(start);
				while (needToFind[startC] == 0 || hasFound[startC] > needToFind[startC]) {
					if (hasFound[startC] > needToFind[startC]) {
						hasFound[startC]--;
					}
					start++;
					startC = s.charAt(start);
				}

				int windowLen = end - start + 1;
				if (windowLen < res) {
					minStart = start;
					minEnd = end;
					res = windowLen;
				}
			}
		}

		return (count == tLen) ? s.substring(minStart, minEnd + 1) : "";
	}

	public static void main(String[] args) {
		System.out.println(minWindow("bccabccbbaaacbcbc", "aac"));
	}
}
