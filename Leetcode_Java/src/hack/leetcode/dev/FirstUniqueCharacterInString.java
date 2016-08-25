package hack.leetcode.dev;

/*
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 */
public class FirstUniqueCharacterInString {
	public int firstUniqChar(String s) {
		if (s == null || s.isEmpty()) {
			return -1;
		}

		int len = s.length();
		if (len == 1) {
			return 0;
		}

		char[] cc = s.toCharArray();
		int slow = 0;
		int fast = 1;

		int[] count = new int[256];
		count[cc[slow]]++;

		while (fast < len) {
			count[cc[fast]]++;

			while (slow < len && count[cc[slow]] > 1) {
				slow++;
			}

			if (slow >= len) {
				return -1;
			}

			fast++;
		}

		return slow;
	}
}
