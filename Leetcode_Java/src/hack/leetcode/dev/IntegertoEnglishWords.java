package hack.leetcode.dev;

/*
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class IntegertoEnglishWords {
	private final String[] ones = { "", "One", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine" };
	private final String[] lessThan20 = { "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };
	private final String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty",
			"Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	private final String[] thousands = { "", "Thousand", "Million", "Billion" };

	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		int i = 0;
		String words = "";

		while (num > 0) {
			if (num % 1000 != 0)
				words = helper(num % 1000) + thousands[i] + " " + words;
			num = num / 1000;
			i++;
		}

		return words.trim();
	}

	private String helper(int num) {
		if (num == 0)
			return "";
		else if (num < 10)
			return ones[num] + " ";
		else if (num < 20)
			return lessThan20[num - 10] + " ";
		else if (num < 100)
			return tens[num / 10] + " " + helper(num % 10);
		else
			return ones[num / 100] + " Hundred " + helper(num % 100);
	}
}
