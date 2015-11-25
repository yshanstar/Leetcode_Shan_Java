package solution;

import java.util.List;

/*
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if (needle == null || needle.isEmpty()) {
			return 0;
		}

		int m = haystack.length();
		int n = needle.length();

		for (int i = 0; i < m - n + 1; i++) {
			int j = 0;
			for (; j < n; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == n) {
				return i;
			}
		}

		return -1;
	}

	// strStr KMP
	public static int strStrKMP(String haystack, String needle) {
		if (needle == null || needle.isEmpty()) {
			return 0;
		}

		int m = haystack.length();
		int n = needle.length();

		int[] lps = processPattern(needle);

		for (int i = 0, j = 0; i < m;) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			}

			if (j == n) {
				return i - j;
			}

			if (i < m && haystack.charAt(i) != needle.charAt(j)) {
				if (j != 0) {
					i = (i-j) + j - lps[j-1];
					j = 0;
				} else {
					i++;
					j = 0;
				}
			}
		}

		return -1;
	}

	public static int[] processPattern(String pattern) {
		int length = pattern.length();

		int[] res = new int[length];
		if (length == 0) {
			return res;
		}

		int len = 0;
		int i = 1;
		res[0] = 0;

		while (i < length) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				res[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = res[len - 1];
				} else {
					res[i] = 0;
					i++;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String s = "mississippi";
		String pattern = "issip";
		int[] res = ImplementstrStr.processPattern(pattern);
		for (int i : res) {
			System.out.print(i);
		}

		System.out.println(ImplementstrStr.strStrKMP(s, pattern));
	}
}
