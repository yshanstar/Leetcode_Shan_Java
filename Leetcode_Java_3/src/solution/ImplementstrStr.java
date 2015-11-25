package solution;

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
}
