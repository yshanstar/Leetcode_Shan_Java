package hack.leetcode.dev;

/*
 * 	The count-and-say sequence is the sequence of integers beginning as follows:
 *	1, 11, 21, 1211, 111221, ...
 *	1 is read off as "one 1" or 11.
 *	11 is read off as "two 1s" or 21.
 *	21 is read off as "one 2, then one 1" or 1211.
 *	Given an integer n, generate the nth sequence.
 *	Note: The sequence of integers will be represented as a string.
 */
public class CountandSay {
	public static String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		if (n == 1) {
			return "1";
		}

		return countC("1", n - 1);
	}

	private static String countC(String s, int n) {
		if (n == 0) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				count++;
			} else {
				sb.append(count);
				sb.append(s.charAt(i - 1));
				count = 1;
			}
		}
		sb.append(count);
		sb.append(s.charAt(s.length() - 1));
		return countC(sb.toString(), n - 1);
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}
}
