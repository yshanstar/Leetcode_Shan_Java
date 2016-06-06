package hack.leetcode.dev;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if (s == null || s.trim().length() == 0) {
			return 0;
		}
		int res = 0;
		int length = s.length() - 1;
		for (int i = 0; i <= length; i++) {
			res += (s.charAt(i) - 'A' + 1) * Math.pow(26, (length - i));
		}

		return res;
	}
}
