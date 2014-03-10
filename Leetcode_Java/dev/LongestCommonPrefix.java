package hack.leetcode.dev;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		int i = 0;
		for (i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0].substring(0, i);
	}

	public static void main(String[] args) {
		String[] arg = { "aaaac", "aaaaa", "aa" };
		System.out.println(longestCommonPrefix(arg));
	}
}
