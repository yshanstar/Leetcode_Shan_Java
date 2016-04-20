package solution;

public class ValidNumber {
	public static boolean isNumber(String s) {
		if (s == null) {
			return false;
		}
		s = s.trim();
		if (s.length() == 0) {
			return false;
		}

		boolean hasNum = false;
		boolean canSign = true;
		boolean canDot = true;
		boolean canE = false;
		boolean hasE = false;

		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i++);

			if (c == ' ') {
				return false;
			}

			if (c == '+' || c == '-') {
				if (!canSign) {
					return false;
				}
				canSign = false;
				continue;
			}

			if (c == '.') {
				if (!canDot) {
					return false;
				}
				canDot = false;
				canSign = false;
				continue;
			}

			if (c == 'e') {
				if (!canE || hasE) {
					return false;
				}
				canE = false;
				hasE = true;
				hasNum = false;
				canDot = false;
				canSign = true;
				continue;
			}

			if (c >= '0' && c <= '9') {
				hasNum = true;

				if (!canE && !hasE) {
					canE = true;
				}

				canSign = false;

			} else {
				return false;
			}
		}

		return hasNum;
	}
	
	public static void main(String[] args) {
		System.out.println(isNumber("e9"));
	}
}
