package solution;

/*
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 Update (2015-02-10):
 The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 */
public class StringInteger {
	public int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		boolean positive = true;
		str = str.trim();
		int i = 0;
		int ret = 0;
		if (i < str.length() && str.charAt(i) == '-') {
			positive = false;
			i++;
		} else if (i < str.length() && str.charAt(i) == '+') {
			i++;
		} else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
			return 0;
		}
		int count = 0;
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if (positive) {
				if (count == 10
						|| (count == 9 && ret == 214748364 && str.charAt(i) >= '7')) {
					return Integer.MAX_VALUE;
				}
				ret = ret * 10 + (str.charAt(i) - '0');
			} else {
				if (count == 10
						|| (count == 9 && ret == -214748364 && str.charAt(i) >= '8')) {
					return Integer.MIN_VALUE;
				}
				ret = ret * 10 - (str.charAt(i) - '0');
			}
			i++;
			count++;
		}
		return ret;
	}

	public static void main(String[] args) {
		StringInteger test = new StringInteger();
		System.out.println(test.myAtoi("010"));
	}
}
