package hack.leetcode.dev;

import java.util.Arrays;
import java.util.Random;

/*
 * 从1到n个数字中依次随机抽取一个数字，并放到一个新序列的尾端（该算法通过互换数字实现），逐渐形成一个新的 序列。
 * 计算一下概率：如果某个元素被放入第i（1<=i<=n）个位置，就必须是在前 i-1 次选取中都没有选到它，并且第 i 次恰好选中它。其概率为：
 * 洗牌算法（等概率随机排列数组，Fisher–Yates <wbr>shuffling）
 * 算法中只有一个从1到N-1的循环，循环内操作为常数步，因而算法总的时间复杂度为O(N)，空间复杂度为O(1)
 */
public class FisherYatesShuffle {
	public static void shuffle(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}

		int n = nums.length;
		Random r = new Random();

		while (n > 1) {
			n--;
			int k = r.nextInt(n + 1);
			int value = nums[k];
			nums[k] = nums[n];
			nums[n] = value;
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };

		int i = 10;
		do {
			shuffle(nums);
			System.out.println(Arrays.toString(nums));
			i--;
		} while (i > 0);

	}
}
