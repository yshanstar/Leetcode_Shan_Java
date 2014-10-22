package solution;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 12) {
			return res;
		}

		helper(res, s, 0, "");
		return res;
	}

	private void helper(List<String> res, String s, int idx, String curIP) {
		if (idx == 3) {
			if (s.length() > 0 && Long.parseLong(s) <= 255 && String.valueOf(Long.parseLong(s)).equals(s)) {
				res.add(curIP + s);
			}
		}

		for (int i = 1; i < 4; i++) {
			int length = s.length();
			if (length >= i && Long.parseLong(s.substring(0, i)) <= 255 && String.valueOf(Long.parseLong(s.substring(0, i))).equals(s.substring(0, i))) {
				helper(res, s.substring(i), idx + 1, curIP + s.subSequence(0, i) + ".");
			}
		}
	}
}
