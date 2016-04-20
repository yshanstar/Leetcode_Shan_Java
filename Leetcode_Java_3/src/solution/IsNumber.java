package solution;

/*
 * Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
public class IsNumber {
	public static boolean isNumber(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}

		s = s.trim();
		if (s.length() == 0) {
			return false;
		}

		boolean canDot = true;
		boolean canSign = true;
		boolean canE = false;
		boolean hasE = false;
		boolean hasNum = false;

		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i++);

			if (c == '+' || c == '-') {
				if (canSign) {
					canSign = false;
					continue;
				} else {
					return false;
				}
			}

			if (c == '.') {
				if (canDot) {
					canDot = false;
					canSign = false;
					continue;
				} else {
					return false;
				}
			}

			if (c == 'e' || c == 'E') {
				if (canE && !hasE) {
					canE = false;
					hasE = true;
					hasNum = false;
					canDot = false;
					canSign = true;
					continue;
				} else {
					return false;
				}
			}

			if (Character.isDigit(c)) {
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
