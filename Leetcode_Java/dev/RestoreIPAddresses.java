package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> res = restoreIPAddresses(s, 4);
		if (res == null) {
			res = new ArrayList<String>();
		}
		return res;
	}

	private ArrayList<String> restoreIPAddresses(String s, int k) {
		assert (k <= 4 && k >= 1);
		if (s == null || s.length() < k || s.length() > 3 * k) {
			return null;
		}
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < Math.min(s.length(), 3); i++) {
			String num = s.substring(0, i + 1);
			if ((i == 0 || num.charAt(0) > '0') && Integer.parseInt(num) <= 255) {
				if (k == 1) {
					if (i == s.length() - 1)
						res.add(num);
				} else {
					ArrayList<String> remain = restoreIPAddresses(s.substring(i + 1), k - 1);
					if (remain != null) {
						for (String r : remain) {
							String temp = num + '.' + r;
							res.add(temp);
						}
					}
				}
			} else
				break;
		}
		return res;
	}

}
