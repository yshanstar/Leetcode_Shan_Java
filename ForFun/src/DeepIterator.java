import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class DeepIterator implements Iterator<Integer> {
	private Stack<Iterator> iteratorStack = new Stack<Iterator>();
	private Integer top = null;

	public DeepIterator(Iterable iterable) {
		this.iteratorStack.push(iterable.iterator());
	}

	@Override
	public boolean hasNext() {
		if (this.top != null) {
			return true;
		}

		while (!iteratorStack.isEmpty()) {
			Iterator tmpIter = iteratorStack.peek();
			if (tmpIter.hasNext()) {
				Object tmp = tmpIter.next();
				if (tmp instanceof Integer) {
					this.top = (Integer) tmp;
					return true;
				} else if (tmp instanceof Iterable) {
					this.iteratorStack.push(((Iterable) tmp).iterator());
				} else {
					throw (new RuntimeException("Unsupported data types"));
				}
			} else {
				iteratorStack.pop();
			}
		}

		return false;
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			throw (new NoSuchElementException("Iterator has no element left"));
		}
		Integer toReturn = this.top;
		this.top = null;
		return toReturn;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("This is not supported right now.");
	}

	public static void main(String[] args) {
		List list1 = new LinkedList();
		list1.add(0);
		list1.add(new LinkedList<Integer>());
		list1.add(1);
		list1.add(new LinkedList<Integer>());
		List list2 = new LinkedList();
		list2.add(list1);
		list2.add(2);

		List<Integer> newList = new LinkedList<Integer>();
		DeepIterator di = new DeepIterator(list2);

		while (di.hasNext()) {
			newList.add(di.next());
		}

		// Use assert if you want
		System.out.println(String.format("newList size is %d, expcted 3", newList.size()));

		list1 = new LinkedList();
		newList = new LinkedList<Integer>();
		di = new DeepIterator(list1);
		while (di.hasNext()) {
			newList.add(di.next());
		}

		// assertTrue(newList.size() == 0);
		System.out.println(String.format("newList size is %d, expcted 0", newList.size()));

		list1 = new LinkedList();
		list1.add(new LinkedList<Integer>());
		list1.add(1);
		list1.add(new LinkedList<Integer>());
		list2 = new LinkedList();
		list2.add(list1);
		list2.add(2);
		List<Integer> list3 = new LinkedList<Integer>();
		list3.add(3);
		list3.add(4);
		list3.add(5);
		List list4 = new LinkedList();
		list4.add(list2);
		list4.add(list3);

		newList = new LinkedList<Integer>();

		di = new DeepIterator(list4);
		while (di.hasNext()) {
			newList.add(di.next());
		}

		// assertTrue(newList.size() == 5);
		System.out.println(String.format("newList size is %d, expcted 5", newList.size()));

		list3 = new LinkedList<Integer>();
		list3.add(3);

		list2 = new LinkedList<Integer>();
		list2.add(2);
		list2.add(list3);
		list2.add(4);

		list1 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(list2);
		list1.add(5);
		list1.add(6);
		newList = new LinkedList<Integer>();
		di = new DeepIterator(list1);
		while (di.hasNext()) {
			newList.add(di.next());
		}
		System.out.println(String.format("newList size is %d, expcted 6", newList.size()));
	}
}
