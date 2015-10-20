package hack.leetcode.dev;

/*
 * Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		char[] A = new char[256];
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (A[s.charAt(i)] > 0) {
				A[s.charAt(i)]--;
				count--;
			} else {
				A[s.charAt(i)]++;
				count++;
			}
		}
		return count <= 1;
	}
}
