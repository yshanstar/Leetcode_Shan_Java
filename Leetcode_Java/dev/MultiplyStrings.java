package hack.leetcode.dev;

/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
	public static String multiply(String num1, String num2) {
		int[] num = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			int carrier = 0;
			int a = num1.charAt(i) - '0';
			for (int j = num2.length() - 1; j >= 0; j--) {
				int b = num2.charAt(j) - '0';
				num[i + j + 1] += carrier + a * b;
				carrier = num[i + j + 1] / 10;
				num[i + j + 1] %= 10;
			}
			num[i] += carrier;
		}
		int i = 0;
		while (i < num.length && num[i] == 0) {
			i++;
		}
		StringBuilder temp = new StringBuilder("");
		while (i < num.length) {
			temp.append((char) ('0' + num[i++]));
		}
		if (temp.toString().isEmpty()) {
			return "0";
		}
		return temp.toString();
	}

	public static void main(String[] args) {
		System.out.println(multiply("323", "34"));
	}
}
