package solution;

/*
 * Adding two big integers represented as strings
 */
public class BigIntegerString {
	public static String sub(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		}

		if (b == null || b.length() == 0) {
			return a;
		}
		boolean swap = swap(a, b);

		if (!swap) {
			return subHelper(a, b);
		} else {
			return "-" + subHelper(b, a);
		}
	}

	private static boolean swap(String a, String b) {
		boolean swap = false;
		if (a.length() > b.length()) {
			swap = false;
		} else if (a.length() == b.length()) {
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) > b.charAt(i)) {
					swap = false;
					return swap;
				} else {
					continue;
				}
			}
			swap = true;
		} else {
			swap = true;
		}
		return swap;
	}

	private static String subHelper(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;
		StringBuilder sb = new StringBuilder();

		int carry = 0;
		while (i >= 0 && j >= 0) {
			int digit1 = Integer.parseInt(Character.toString(a.charAt(i)));
			int digit2 = Integer.parseInt(Character.toString(b.charAt(j)));

			int digit = carry + digit1 - digit2;
			if (digit < 0) {
				carry = -1;
				digit = digit + 10;
			} else {
				carry = 0;
			}
			sb.insert(0, digit);
			i--;
			j--;
		}

		while (i >= 0) {
			int digit1 = Integer.parseInt(Character.toString(a.charAt(i)));
			int digit = digit1 + carry;
			if (digit < 0) {
				carry = -1;
				digit = digit + 10;
			} else {
				carry = 0;
			}
			sb.insert(0, (digit % 10));
			i--;
		}

		if (carry > 0) {
			sb.insert(0, (carry));
		}
		return sb.toString();
	}

	public static String add(String a, String b) {
		StringBuilder sb = new StringBuilder();

		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;

		while (i >= 0 && j >= 0) {
			int digit1 = Integer.parseInt(Character.toString(a.charAt(i)));
			int digit2 = Integer.parseInt(Character.toString(b.charAt(j)));

			int digit = digit1 + digit2 + carry;
			carry = digit / 10;
			sb.insert(0, (digit % 10));
			i--;
			j--;
		}

		while (i >= 0) {
			int digit1 = Integer.parseInt(Character.toString(a.charAt(i)));
			int digit = digit1 + carry;
			carry = digit / 10;
			sb.insert(0, (digit % 10));
			i--;
		}

		while (j >= 0) {
			int digit1 = Integer.parseInt(Character.toString(b.charAt(j)));
			int digit = digit1 + carry;
			carry = digit / 10;
			sb.insert(0, (digit % 10));
			j--;
		}

		if (carry > 0) {
			sb.insert(0, (carry));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String a = "37868642";
		String b = "1233434323432454521";

		// System.out.println(add(a, b));

		a = "2";
		b = "0";
		System.out.println(sub(a, b));
	}
}
