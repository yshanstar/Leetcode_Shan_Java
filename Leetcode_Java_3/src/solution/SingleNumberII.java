package solution;

public class SingleNumberII {
	public int singleNumber(int[] A) {
		int[] count = new int[32];
		int res = 0;
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (((A[j] >> i) & 1) > 0) {
					count[i]++;
				}
			}
			res |= ((count[i] % 3)) << i;
		}
		return res;
	}
}
