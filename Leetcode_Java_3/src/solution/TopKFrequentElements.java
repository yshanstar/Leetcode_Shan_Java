package solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note: 
 You may assume k is always valid, 1 <= k <= number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
	class Node {
		int val;
		int feq;

		public Node(int val, int feq) {
			this.val = val;
			this.feq = feq;
		}
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0 || k <= 0) {
			return res;
		}

		Map<Integer, Node> numMap = new HashMap<Integer, Node>();

		for (int num : nums) {
			if (!numMap.containsKey(num)) {
				numMap.put(num, new Node(num, 1));
			} else {
				numMap.get(num).feq++;
			}
		}

		PriorityQueue<Node> queue = new PriorityQueue<Node>(k, new Comparator<Node>() {
			public int compare(Node a, Node b) {
				if (a.feq == b.feq) {
					return a.val - b.val;
				} else {
					return b.feq - a.feq;
				}
			}
		});

		for (Map.Entry<Integer, Node> entry : numMap.entrySet()) {
			queue.offer(entry.getValue());
		}

		for (int i = 0; i < k; i++) {
			res.add(queue.poll().val);
		}

		return res;
	}
}
