package hack.leetcode.dev;

public class ReverseWordsinaString {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String[] sChar = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = sChar.length - 1; i >= 0; i--) {
			if (!sChar[i].equals("")) {
				sb.append(sChar[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}

	public static void main(String[] args) {
		ReverseWordsinaString test = new ReverseWordsinaString();
		test.reverseWords("a");
	}
}
