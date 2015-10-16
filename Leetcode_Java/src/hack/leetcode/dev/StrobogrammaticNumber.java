package hack.leetcode.dev;

/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		if (num == null || num.length() == 0) {
			return true;
		}

		int i = 0;
		int j = num.length() - 1;

		while (i < j) {
			char c = num.charAt(i);
			switch (c) {
			case '0':
				if (num.charAt(num.length() - 1 - i) != c) {
					return false;
				}
				break;
			case '1':
				if (num.charAt(num.length() - 1 - i) != c) {
					return false;
				}
				break;
			case '6':
				if (num.charAt(num.length() - 1 - i) != '9') {
					return false;
				}
				break;
			case '9':
				if (num.charAt(num.length() - 1 - i) != '6') {
					return false;
				}
				break;
			case '8':
				if (num.charAt(num.length() - 1 - i) != c) {
					return false;
				}
				break;
			default:
				return false;
			}
			
			i++;
			j--;
		}

		if (i == j) {
			if (num.charAt(i) != '1' && num.charAt(i) != '8'
					&& num.charAt(i) != '0') {
				return false;
			}
		}

		return true;
	}
}
