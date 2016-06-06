package solution;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carrier = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			int num = digits[i];
			int newNum = (i == digits.length - 1) ? (num + 1 + carrier)
					: (num + carrier);
			digits[i] = newNum % 10;
			carrier = newNum / 10;
		}
		if (carrier == 0) {
			return digits;
		}

		int[] newNums = new int[digits.length + 1];
		newNums[0] = carrier;
		for (int i = 1; i <= digits.length; i++) {
			newNums[i] = digits[i - 1];
		}
		return newNums;
	}
}
