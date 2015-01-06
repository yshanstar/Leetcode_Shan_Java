package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (nRows <= 1 || s.length() < 2) {
			return s;
		}
		ArrayList<StringBuilder> res = new ArrayList<StringBuilder>();
		for (int k = 0; k < nRows; k++) {
			res.add(new StringBuilder());
		}

		int count = 2 * (nRows - 1);
		for (int i = 0; i < s.length(); i++) {
			res.get(nRows - 1 - Math.abs(nRows - 1 - (i % count))).append(s.charAt(i));
		}

		StringBuilder sb = new StringBuilder();
		for (StringBuilder subSB : res) {
			sb.append(subSB.toString());
		}
		return sb.toString();
	}
}
