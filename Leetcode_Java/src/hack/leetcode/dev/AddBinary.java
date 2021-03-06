package hack.leetcode.dev;

/*
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
	public static String addBinary(String a, String b) {
		if (a == null && b == null) {
			return "";
		}
		if (a == null || a.length() == 0) {
			return b;
		}
		if (b == null || b.length() == 0) {
			return a;
		}
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int isNext = 0;
		for (i = 0; i < Math.min(a.length(), b.length()); i++) {
			char aChar = a.charAt(a.length() - 1 - i);
			char bChar = b.charAt(b.length() - 1 - i);
			int sum = Character.getNumericValue(aChar) + Character.getNumericValue(bChar) + isNext;
			if (sum < 2) {
				sb.insert(0, sum);
				isNext = 0;
			} else if (sum == 2) {
				sb.insert(0, "0");
				isNext = 1;
			} else if (sum == 3) {
				sb.insert(0, "1");
				isNext = 1;
			}
		}
		while (i < a.length()) {
			char aChar = a.charAt(a.length() - 1 - i);
			int sum = Character.getNumericValue(aChar) + isNext;
			if (sum < 2) {
				sb.insert(0, sum);
				isNext = 0;
			} else if (sum == 2) {
				sb.insert(0, "0");
				isNext = 1;
			}
			i++;
		}
		while (i < b.length()) {
			char bChar = b.charAt(b.length() - 1 - i);
			int sum = Character.getNumericValue(bChar) + isNext;
			if (sum < 2) {
				sb.insert(0, sum);
				isNext = 0;
			} else if (sum == 2) {
				sb.insert(0, "0");
				isNext = 1;
			}
			i++;
		}
		if (isNext > 0) {
			sb.insert(0, isNext);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.print(addBinary("0", "1"));
	}
}
