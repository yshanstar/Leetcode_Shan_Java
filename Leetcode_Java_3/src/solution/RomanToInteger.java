package solution;

/*
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
	public int romanToInt(String s) {
		if (s == null || s.trim().length() == 0) {
			return 0;
		}

		int res = 0;
		int prev = getDigit(s.charAt(s.length() - 1));
		res += prev;

		for (int i = s.length() - 2; i >= 0; i--) {
			int d = getDigit(s.charAt(i));
			if (d < prev) {
				res -= d;
			} else if (d >= prev) {
				res += d;
			}
			prev = d;
		}
		return res;
	}

	private int getDigit(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
}
