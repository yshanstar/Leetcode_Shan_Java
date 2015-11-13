package solution;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "0";
		}

		int max = 0;
		String res = "";
		String[] numsStrs = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			numsStrs[i] = nums[i] + "";
		}

		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		};

		Arrays.sort(numsStrs, comparator);

		for (int i = 0; i < numsStrs.length; i++) {
			res += numsStrs[i];
		}

		return max == 0 ? "0" : res.trim();
	}
}
