package solution;

/*
 * Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		int[] nums = new int[256];
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (nums[c] > 0) {
				nums[c]--;
				count--;
			} else {
				nums[c]++;
				count++;
			}
		}

		return count <= 1;
	}
}
