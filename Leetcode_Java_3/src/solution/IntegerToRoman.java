package solution;

/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class IntegerToRoman {
	static String[] roman = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
	static int[] integers = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

	public String intToRoman(int num) {
		if (num < 1 || num > 3999) {
			return "";
		}

		int end = integers.length - 1;
		StringBuilder sb = new StringBuilder();
		while (num > 0 && end >= 0) {
			if (num >= integers[end]) {
				sb.append(roman[end]);
				num -= integers[end];
			} else {
				end--;
			}
		}

		return sb.toString();
	}
}
