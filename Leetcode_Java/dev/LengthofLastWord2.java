package hack.leetcode.dev;

/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 */
public class LengthofLastWord2 {
	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int i = s.length() - 1;
		while (i >= 0 && s.charAt(i) == ' ') {
			i--;
		}
		if (i < 0) {
			return 0;
		}
		int j = i;
		while (j - 1 >= 0 && s.charAt(j - 1) != ' ') {
			j--;
		}
		return i - j + 1;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("b a "));
	}
}
