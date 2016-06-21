package solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].
 */
public class SlidingWindowMaximum {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		List<Integer> res = new ArrayList<Integer>();

		if (nums == null || nums.length == 0 || k < 0) {
			return new int[0];
		}

		Deque<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < k; i++) {
			while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
				queue.removeLast();
			}
			queue.addLast(i);
		}

		for (int i = k; i < nums.length; i++) {
			res.add(nums[queue.peekFirst()]);

			while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
				queue.removeFirst();
			}

			while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
				queue.removeLast();
			}

			queue.addLast(i);
		}

		res.add(nums[queue.peekFirst()]);

		int[] finalRes = new int[res.size()];

		for (int i = 0; i < finalRes.length; i++) {
			finalRes[i] = res.get(i);
		}

		return finalRes;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		maxSlidingWindow(nums, 3);
	}
}
