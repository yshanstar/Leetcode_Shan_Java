package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:
 Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

 Return: [1,2],[1,4],[1,6]

 The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 Example 2:
 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

 Return: [1,1],[1,1]

 The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 Example 3:
 Given nums1 = [1,2], nums2 = [3],  k = 3 

 Return: [1,3],[2,3]

 All possible pairs are returned from the sequence:
 [1,3],[2,3]
 */
public class FindKPairsWithSmallestSums {
	int[][] direction = new int[][] { { 0, 1 }, { 1, 0 } };

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<int[]>();

		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
			return res;
		}

		int m = nums1.length;
		int n = nums2.length;

		boolean[][] visited = new boolean[m][n];
		PriorityQueue<Pair> queue = new PriorityQueue<FindKPairsWithSmallestSums.Pair>();
		queue.offer(new Pair(0, 0, nums1[0] + nums2[0]));
		visited[0][0] = true;

		while (k > 0 && !queue.isEmpty()) {
			Pair p = queue.poll();
			res.add(new int[] { nums1[p.i], nums2[p.j] });
			k--;

			for (int[] dir : direction) {
				int ii = p.i + dir[0];
				int jj = p.j + dir[1];
				if (ii < 0 || ii >= m || jj < 0 || jj >= n || visited[ii][jj]) {
					continue;
				}

				visited[ii][jj] = true;
				queue.offer(new Pair(ii, jj, nums1[ii] + nums2[jj]));
			}
		}

		return res;
	}

	class Pair implements Comparable<Pair> {
		int i;
		int j;
		int val;

		public Pair(int i, int j, int v) {
			this.i = i;
			this.j = j;
			this.val = v;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return val - o.val;
		}
	}
}
