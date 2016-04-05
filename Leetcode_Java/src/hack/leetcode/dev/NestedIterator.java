package hack.leetcode.dev;

import hack.leetcode.ulti.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

 Example 2:
 Given the list [1,[4,[6]]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */
public class NestedIterator implements Iterator<Integer> {
	Queue<Integer> queue;

	public NestedIterator(List<NestedInteger> nestedList) {
		queue = new LinkedList<Integer>();
		fill(queue, nestedList);
	}

	@Override
	public Integer next() {
		if (hasNext()) {
			return queue.poll();
		}
		return null;
	}

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	private void fill(Queue<Integer> queue, List<NestedInteger> list) {
		for (NestedInteger ele : list) {
			if (ele.isInteger()) {
				queue.offer(ele.getInteger());
			} else {
				fill(queue, ele.getList());
			}
		}
	}

}
