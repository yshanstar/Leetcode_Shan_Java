package solution;

import java.math.BigDecimal;

public class StringtoInteger {
	public int atoi(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		boolean isPositive = true;
		str = str.trim();
		int i = 0;
		int res = 0;

		if (str.charAt(i) == '-') {
			isPositive = false;
			i++;
		} else if (str.charAt(i) == '+') {
			isPositive = true;
			i++;
		} else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
			return 0;
		} else if (str.charAt(i) == '0') {
			i++;
		}

		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if (isPositive) {
				BigDecimal tmp = BigDecimal.valueOf((double) res).multiply(new BigDecimal(10)).add(new BigDecimal(str.charAt(i) - '0'));
				if (tmp.subtract(new BigDecimal(Integer.MAX_VALUE)).compareTo(BigDecimal.ZERO) >= 0) {
					return Integer.MAX_VALUE;
				} else {
					res = tmp.intValue();
				}
			} else {
				BigDecimal tmp = BigDecimal.valueOf((double) res).multiply(new BigDecimal(10)).subtract(new BigDecimal(str.charAt(i) - '0'));
				if (tmp.subtract(new BigDecimal(Integer.MIN_VALUE)).compareTo(BigDecimal.ZERO) <= 0) {
					return Integer.MIN_VALUE;
				} else {
					res = tmp.intValue();
				}
			}
			i++;
		}

		return res;
	}

	public static void main(String[] args) {
		StringtoInteger test = new StringtoInteger();
		System.out.println(test.atoi("-2147483648"));
	}
}
