package solution;

/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
public class CountSay {
	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		if (n == 1) {
			return "1";
		}
		return helper("1", n - 1);
	}

	private String helper(String str, int n) {
		if (n == 0) {
			return str;
		}

		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				count++;
			} else {
				sb.append(count);
				sb.append(str.charAt(i - 1));
				count = 1;
			}
		}
		sb.append(count);
		sb.append(str.charAt(str.length() - 1));
		return helper(sb.toString(), n - 1);
	}
}
