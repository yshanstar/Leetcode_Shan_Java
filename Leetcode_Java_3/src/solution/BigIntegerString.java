package solution;

/*
 * Adding two big integers represented as strings
 */
public class BigIntegerString {
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

		System.out.println(add(a, b));
	}
}
