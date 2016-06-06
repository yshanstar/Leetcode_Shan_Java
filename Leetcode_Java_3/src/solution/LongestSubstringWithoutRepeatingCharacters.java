package solution;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		char[] chars = new char[256];
		int start = 0;
		int end = 0;
		int max = 0;
		for (end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			if (chars[c] > 0) {
				max = Math.max(max, end - start);
				for (int k = start; k < end; k++) {
					if (s.charAt(k) == c) {
						start = k + 1;
						break;
					}
					chars[s.charAt(k)] = 0;
				}
			} else {
				chars[c]++;
			}
		}
		max = Math.max(max, s.length() - start);
		return max;
	}
}
