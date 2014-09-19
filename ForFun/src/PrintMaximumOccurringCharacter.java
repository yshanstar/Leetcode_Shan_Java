/*
 * 	Given a string, print the character which appears the maximum number of times in the string. 
	The string will contain only ascii characters. If there is a tie in the maximum number 
	of times a character appears in the string, print the character which appears first in the string. 
	
	Notes: 
	1. The length of the string will be between 1 and 10000, inclusive. 
	2. Make sure you don't print anything other than a single character in the function. Otherwise, your solution will be marked wrong. 
	3. You only need to complete the function printMaximumOccurringCharacter. 
	
	Sample Input #00 
	helloworld 
	Sample Output #00 
	l 
	
	Sample Input #01 
	aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz 
	Sample Output #01 
	a 
	
	Sample Input #02 
	abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz 
	Sample Output #02 
	a 
 */
public class PrintMaximumOccurringCharacter {
	public static String printMaximumOccurringCharacter(String s) {
		if (s == null || s.length() > 10000) {
			return "Given string size is out of bounds";
		}
		int[] charsCount = new int[256];
		int[] charsFirstOccir = new int[256];
		for (int i = 0; i < charsFirstOccir.length; i++) {
			charsFirstOccir[i] = -1;
		}
		int maxOccur = 0;
		int maxIdxinString = -1;

		for (int i = 0; i < s.length(); i++) {
			int value = s.charAt(i);
			charsCount[value]++;
			if (charsFirstOccir[value] == -1) {
				charsFirstOccir[value] = i;
			}
			if (charsCount[value] > maxOccur) {
				maxOccur = charsCount[value];
				maxIdxinString = charsFirstOccir[value];
			} else if (charsCount[value] == maxOccur) {
				maxIdxinString = Math.min(charsFirstOccir[value], maxIdxinString);
			}
		}

		System.out.println(s.charAt(maxIdxinString));

		return "Success";
	}

	public static void main(String[] agrs) {
		printMaximumOccurringCharacter("aabbccccabb");
	}
}
