package hack.leetcode.dev;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Implement an iterator to flatten a 2d vector.
 For example,
 Given 2d vector =

 [
 [1,2],
 [3],
 [4,5,6]
 ]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */

public class Vector2D {
	Queue<Iterator<Integer>> queue;
	Iterator<Integer> current = null;

	public Vector2D(List<List<Integer>> vec2d) {
		queue = new LinkedList<Iterator<Integer>>();
		for (int i = 0; i < vec2d.size(); i++) {
			queue.offer(vec2d.get(i).iterator());
		}
		current = queue.poll();
	}

	public int next() {
		if (!current.hasNext()) {
			return -1;
		}
		return current.next();
	}

	public boolean hasNext() {
		if (current == null) {
			return false;
		}

		while (!current.hasNext()) {
			if (!queue.isEmpty()) {
				current = queue.poll();
			} else
				return false;
		}

		return true;
	}
}
