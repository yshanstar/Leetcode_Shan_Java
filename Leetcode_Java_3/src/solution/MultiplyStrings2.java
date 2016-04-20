package solution;

/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note:
 The numbers can be arbitrarily large and are non-negative.
 Converting the input string to integer is NOT allowed.
 You should NOT use internal library such as BigInteger.
 */
public class MultiplyStrings2 {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null || num1.length() == 0
				|| num2.length() == 0) {
			return "";
		}

		int num[] = new int[num1.length() + num2.length()];

		char[] num1Chars = num1.toCharArray();
		char[] num2Chars = num2.toCharArray();

		int i = num1Chars.length - 1;

		StringBuilder sb = new StringBuilder();

		while (i >= 0) {
			int carrier = 0;
			int a = num1Chars[i] - '0';
			for (int j = num2.length() - 1; j >= 0; j--) {
				int b = num2Chars[j] - '0';
				num[i + j + 1] += carrier + a * b;
				carrier = num[i + j + 1] / 10;
				num[i + j + 1] %= 10;
			}
			num[i] += carrier;
			i--;
		}
		
		i = 0;
		while (i < num.length && num[i] == 0) {
			i++;
		}
		while (i < num.length) {
			sb.append(num[i++]);
		}
		if (sb.toString().isEmpty()) {
			return "0";
		}
		return sb.toString();
	}
}
