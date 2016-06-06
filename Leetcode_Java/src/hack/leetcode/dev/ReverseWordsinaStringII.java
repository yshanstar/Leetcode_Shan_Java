package hack.leetcode.dev;

/*
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?
 */
public class ReverseWordsinaStringII {
	public void reverseWords(char[] s) {
		int start = 0;
		int end = s.length - 1;

		swap(s, start, end);

		start = 0;
		end = -1;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				end = i - 1;
				swap(s, start, end);
				start = i + 1;
			}
		}
		swap(s, start, s.length - 1);
	}

	private void swap(char[] s, int start, int end) {
		while (start < end) {
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;

			start++;
			end--;
		}
	}
}
