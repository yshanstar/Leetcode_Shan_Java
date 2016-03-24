package solution;

/*
 * Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28 
 */
public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if (s == null || s.length() <= 0) {
			return 0;
		}

		char[] sChars = s.toUpperCase().toCharArray();
		int res = 0;

		for (int i = sChars.length - 1; i >= 0; i--) {
			if (sChars[i] < 'A' || sChars[i] > 'Z') {
				res = 0;
				return res;
			}

			int tmp = (sChars[i] - 'A') + 1;
			int base = (sChars.length - 1) - i;
			tmp = tmp * ((int) Math.pow(26, base));
			res += tmp;
		}

		return res;
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber test = new ExcelSheetColumnNumber();
		System.out.println(test.titleToNumber("AA"));
	}

}
