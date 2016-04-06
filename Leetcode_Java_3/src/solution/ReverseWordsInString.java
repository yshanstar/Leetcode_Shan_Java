package solution;

/*
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
 */
public class ReverseWordsInString {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		s = s.trim();
		char[] strArray = s.toCharArray();

		// reverse the whole string
		swap(strArray, 0, strArray.length - 1);

		int i = 0;
		int n = strArray.length;
		StringBuilder sb = new StringBuilder();
		while (i < n) {
			while (i < n && strArray[i] == ' ') {
				i++;
			}

			while (i < n && strArray[i] != ' ') {
				i++;
			}

			int h = i - 1;
			if (strArray[h] == ' ') {
				break;
			}

			while (h >= 0 && strArray[h] != ' ') {
				sb.append(strArray[h--]);
			}
			sb.append(" ");
		}

		if (sb.length() > 0)
			sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

	private void swap(char[] chars, int start, int end) {
		while (start < end) {
			char c = chars[start];
			chars[start] = chars[end];
			chars[end] = c;
			start++;
			end--;
		}
	}
}
