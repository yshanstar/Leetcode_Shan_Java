package solution;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		} else if (s.length() == 1) {
			return (Integer.parseInt(s) == 0) ? 0 : 1;
		}
		int[] res = new int[2];
		res[0] = 1;
		res[1] = 1;
		for (int i = 0; i < s.length(); i++) {
			int tmp = 0;
			if (s.charAt(i) != '0') {
				tmp = res[1];
			}
			if (i > 0) {
				int a = Integer.parseInt(s.substring(i - 1, i + 1));
				if (s.charAt(i - 1) != '0' && a <= 26 && a >= 1) {
					tmp += res[0];
				}
			}
			res[0] = res[1];
			res[1] = tmp;
		}

		return res[1];
	}
}
