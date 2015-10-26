package hack.leetcode.dev;

import java.util.HashMap;

/*
 * Design and implement a TwoSum class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.

 For example,
 add(1); add(3); add(5);
 find(4) -> true
 find(7) -> false
 */
public class TwoSumIII {

	private HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();

	// Add the number to an internal data structure.
	public void add(int number) {
		maps.put(number, maps.containsKey(number) ? 2 : 1);
	}

	// Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		for (int key : maps.keySet()) {
			int res = value - key;
			if (maps.containsKey(res)
					&& (res != key || (res == key && maps.get(res) == 2))) {
				return true;
			}
		}
		return false;
	}
}
