package solution;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
		ArrayList<String> res = new ArrayList<String>();
		if (words.length == 0) {
			return res;
		}
		if (L == 0) {
			res.add("");
			return res;
		}

		String spaces[] = new String[L + 1];
		spaces[0] = "";
		for (int i = 1; i < spaces.length; i++) {
			spaces[i] = spaces[i - 1] + " ";
		}

		int buffer = -1;
		int start = 0;
		int end = 0;
		while (end < words.length) {
			if (buffer + words[end].length() + 1 <= L) {
				buffer += words[end].length() + 1;
				end++;
				if (end != words.length) {
					continue;
				}
			}
			int len = 0;
			for (int i = start; i < end; i++) {
				len += words[i].length();
			}
			int averLen = L - len;
			int notEven = 0;
			if (start + 1 < end) {
				averLen = (L - len) / (end - start - 1);
				notEven = (L - len) - averLen * (end - start - 1);
			}

			StringBuilder sb = new StringBuilder();
			sb.append(words[start]);
			for (int i = start + 1; i < end; i++) {
				if (i <= start + notEven) {
					sb.append(spaces[1]);
				}
				sb.append(spaces[averLen]).append(words[i]);
			}

			if (start + 1 == end) {
				sb.append(spaces[L - words[start].length()]);
			}
			res.add(sb.toString());

			start = end;
			buffer = -1;
		}

		while (res.get(res.size() - 1).contains("  ")) {
			res.set(res.size() - 1, res.get(res.size() - 1).replace("  ", " "));
		}
		res.set(res.size() - 1,
				res.get(res.size() - 1)
						+ spaces[L - res.get(res.size() - 1).length()]);
		return res;
	}

	public static void main(String[] args) {
		TextJustification test = new TextJustification();
		String[] words = { "Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first." };
		System.out.println(test.fullJustify(words, 30));
	}
}
