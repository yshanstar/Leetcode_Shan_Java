package solution;

/*
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True
 Example 2:

 Input: 14
 Returns: False
 */
public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if (num == 0 || num == 1) {
			return true;
		}

		int left = 0;
		int right = num;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (num % mid == 0 && num / mid == mid) {
				return true;
			} else if (mid <= num / mid) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return false;
	}
}
