package hack.leetcode.dev;

import java.util.ArrayList;

/*
 *  Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 *	You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 *	Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *	For the last line of text, it should be left justified and no extra space is inserted between words.
 *	For example,
 *	words: ["This", "is", "an", "example", "of", "text", "justification."]
 *	L: 16.
 * 	Return the formatted lines as:
	 [
		 "This    is    an",
		 "example  of text",
		 "justification.  "
	 ]
 */
public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		int n = words.length, start = 0;
		ArrayList<String> res = new ArrayList<String>();

		while (start < n) {
			int cur = start, count = words[cur].length();
			StringBuilder s = new StringBuilder(words[cur]);
			while (count <= L && cur < n) {
				cur++;
				if (cur < n)
					count += 1 + words[cur].length();
			}
			if (cur < n) {
				count -= 1 + words[cur].length();
				cur--;
				if (cur > start) {
					int a = (L - count + cur - start) / (cur - start), b = (L - count + cur - start) % (cur - start);
					for (int i = start + 1; i < start + 1 + b; i++) {
						for (int j = 0; j < a + 1; j++)
							s.append(" ");
						s.append(words[i]);
					}
					for (int i = start + 1 + b; i <= cur; i++) {
						for (int j = 0; j < a; j++)
							s.append(" ");
						s.append(words[i]);
					}
				} else {
					for (int i = 0; i < L - count; i++)
						s.append(" ");
				}
			} else {
				for (int i = start + 1; i < cur; i++) {
					s.append(" ");
					s.append(words[i]);
				}
				for (int i = 0; i < L - count; i++)
					s.append(" ");
			}
			start = cur + 1;
			res.add(s.toString());
		}
		return res;
	}
}
