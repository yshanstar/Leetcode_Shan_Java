package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/*
 *Given an array of arrays, implement an iterator class to allow the client to traverse and remove elements in the array list.  This iterator should provide three public class member functions:

 boolean hasNext()
 return true or false if there is another element in the set
 int next()
 return the value of the next element in the array
 void remove()
 remove the last element returned by the iterator.  That is, remove the element that the previous next() returned
 This method can be called only once per call to next(), otherwise, an exception will be thrown

 */
public class ArrayIterator implements Iterator<Integer> {
	private Iterator<List<Integer>> listsIter;
	private Iterator<Integer> curIter;

	@Override
	public boolean hasNext() {
		if (curIter == null) {
			return false;
		}
		if (curIter.hasNext()) {
			return true;
		}
		hop();
		if (curIter == null) {
			return false;
		}
		return true;
	}

	@Override
	public Integer next() {
		if (curIter == null) {
			throw new NoSuchElementException();
		}
		if (curIter.hasNext()) {
			return curIter.next();
		}
		hop();
		if (curIter == null) {
			throw new NoSuchElementException();
		}
		return curIter.next();
	}

	@Override
	public void remove() {
		if (curIter == null) {
			throw new IllegalStateException();
		}
		curIter.remove();
		if (!curIter.hasNext()) {
			hop();
		}
	}

	private void hop() {
		curIter = null;
		if (listsIter == null) {
			return;
		}
		while (listsIter.hasNext()) {
			List<Integer> list = listsIter.next();
			// Here is the flattening
			if (list == null || list.isEmpty()) {
				listsIter.remove();
			} else {
				curIter = list.iterator();
				break;
			}
		}
	}

	public ArrayIterator(List<List<Integer>> lists) {
		if (lists != null) {
			listsIter = lists.iterator();
		}
		hop();
	}

	public static void main(String[] args) {
		List<List<Integer>> test1 = new ArrayList<List<Integer>>();
		test1.add(null);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		test1.add(list);
		test1.add(Collections.<Integer> emptyList());
		list = new LinkedList<Integer>();
		list.add(3);
		list.add(4);
		test1.add(list);
		ArrayIterator iterator = new ArrayIterator(test1);

		while (iterator.hasNext()) {
			int i = iterator.next();
			System.out.println(i);
			if (i % 2 == 0)
				iterator.remove();
		}

		iterator = new ArrayIterator(test1);
		while (iterator.hasNext()) {
			int i = iterator.next();
			System.out.println(i);
		}
	}
}
