package hack.leetcode.dev;

/*
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {
	public int singleNumber(int[] A) {
		int once = 0;
		int twice = 0;
		for (int i = 0; i < A.length; i++) {
			twice |= once & A[i];
			once ^= A[i];
			int not_three = ~(once & twice);
			once = not_three & once;
			twice = not_three & twice;
		}
		return once;
	}

	public static int singleNumber2(int[] A) {
		int[] B = new int[32];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				B[j] += (A[i] >> j) & (1);
				B[j] %= 3;
			}
		}
		int ret = 0;
		for (int j = 0; j < B.length; j++) {
			ret += (B[j] << j);
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] A = { 2, 2, 3, 2 };
		System.out.println(singleNumber2(A));
	}
}
