package hack.leetcode.dev;

/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB 
 */

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		if (n < 1) {
			return "";
		}

		char t = (char) ('A' + (n - 1) % 26);
		return convertToTitle((n - 1) / 26) + t;
	}
}
