package solution;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int num[] = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			int carrier = 0;
			int a = num1.charAt(i) - '0';
			for (int j = num2.length() - 1; j >= 0; j--) {
				int b = num2.charAt(j) - '0';
				num[i + j + 1] += carrier + a * b;
				carrier = num[i + j + 1] / 10;
				num[i + j + 1] %= 10;
			}
			num[i] += carrier;
		}

		int i = 0;
		while (i < num.length && num[i] == 0) {
			i++;
		}
		StringBuilder sb = new StringBuilder();
		while (i < num.length) {
			sb.append(num[i++]);
		}
		if (sb.toString().isEmpty()) {
			return "0";
		}
		return sb.toString();
	}
}
