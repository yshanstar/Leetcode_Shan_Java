package hack.leetcode.dev;

/*
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */
public class ImplementstrStr {
	public String strStr(String haystack, String needle) {
		assert (haystack != null && needle != null);
		if (needle.length() == 0)
			return haystack;

		int i = 0;
		while (i < haystack.length()) {
			if (haystack.length() - i < needle.length())
				break;
			if (haystack.charAt(i) == needle.charAt(0)) {
				int j = i;
				while (j - i < needle.length() && haystack.charAt(j) == needle.charAt(j - i))
					j++;
				if (j - i == needle.length())
					return haystack.substring(i);
			}
			i++;
		}
		return null;
	}
}
