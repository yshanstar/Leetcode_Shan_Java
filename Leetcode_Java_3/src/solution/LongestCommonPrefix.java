package solution;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}

		String target = strs[0];
		int targetIdx = 0;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < target.length()) {
				target = strs[i];
				targetIdx = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < target.length(); i++) {
			char c = target.charAt(i);
			for (int j = 0; j < strs.length; j++) {
				if (j == targetIdx) {
					continue;
				}
				if (strs[j].charAt(i) != c) {
					return sb.toString();
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LongestCommonPrefix test = new LongestCommonPrefix();
		String[] testStrs = new String[] { "flower", "flow", "flight" };
		System.out.println(test.longestCommonPrefix(testStrs));
	}
}
