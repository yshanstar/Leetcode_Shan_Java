package hack.leetcode.dev;

/*
 * Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1

https://discuss.leetcode.com/topic/58839/java-3ms-bit-manipulation-solution
 */

/*
 * For this problem, if we look at the binary form of each number, we can get the idea that for each '1' (except for the first '1') it counts to two steps, for each '0', it counts to one step.
So our goal is to use +1 or -1 to reduce steps.

For example,
13 = 1101
If we plus one, we can get 1110; if we reduce one, we can get 1100;
1110 needs 2+2+1 = 5 steps, while 1100 only needs 2+1+1 = 4 steps, so we choose n-1 in this step.

Use long to avoid overflow (if n is Integer.MAX_VALUE).
 */
public class IntegerReplacement {
	public int integerReplacement(int n) {
		long N = n;
		long small, big;
		int count = 0;

		while (N != 1) {
			small = (N & (N - 1));
			big = (N & N + 1);

			if ((N & 1) == 0) {
				N >>= 1;
			} else if ((small & (small - 1)) <= (big & (big - 1))) {
				N = N - 1;
			} else {
				N = N + 1;
			}
			count++;
		}

		return count;
	}
}
