package solution;

/*
 *  for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */
public class HIndexII {
	public int hIndex(int[] citations) {
		int left = 0;
		int right = citations.length - 1;

		int length = citations.length;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (citations[length - mid - 1] > mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}
}
