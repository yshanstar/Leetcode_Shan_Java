package hack.leetcode.dev;

/*
 * Write a function that takes an unsigned integer and returns the number of ��1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ��11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class Numberof1Bits {
	public int hammingWeight(int n) {
		int res = 0;
		int i = 0;
		while (i < 32) {
			res += n & 1;
			n = n >> 1;
			i++;
		}
		return res;
	}

	public int hammingWeight2(int n) {
		int res = 0;
		while (n > 0) {
			n &= n - 1;
			res++;
		}
		return res;
	}
}
