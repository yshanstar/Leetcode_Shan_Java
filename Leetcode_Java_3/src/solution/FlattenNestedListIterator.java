package solution;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import util.NestedInteger;

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

public class FlattenNestedListIterator implements Iterator<Integer> {
	Stack<Iterator<NestedInteger>> iterators;
	Iterator<NestedInteger> cur;
	NestedInteger next;

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		iterators = new Stack<Iterator<NestedInteger>>();
		iterators.push(nestedList.iterator());
	}

	@Override
	public Integer next() {
		return next.getInteger();
	}

	@Override
	public boolean hasNext() {
		next = getNext();
		return next != null;
	}

	private NestedInteger getNext() {
		while (!iterators.isEmpty()) {
			cur = iterators.peek();
			while (cur.hasNext()) {
				NestedInteger next = cur.next();
				if (next.isInteger()) {
					return next;
				}
				iterators.push(next.getList().iterator());
				cur = iterators.peek();
			}
			if (!cur.hasNext()) {
				iterators.pop();
			}
		}

		return null;
	}
}
