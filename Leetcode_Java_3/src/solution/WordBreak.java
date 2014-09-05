package solution;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		boolean[] canBreak = new boolean[s.length() + 1];
		canBreak[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (canBreak[j] && dict.contains(s.substring(j, i))) {
					canBreak[i] = true;
					break;
				}
			}
		}

		return canBreak[s.length()];
	}
}
