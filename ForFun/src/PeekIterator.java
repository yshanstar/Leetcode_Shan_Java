import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekIterator<T> implements Iterator<T> {
	private final Iterator<T> iterator;
	private T nextItem;

	public PeekIterator(Iterator<T> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasNext() {
		if (nextItem != null) {
			return true;
		}

		if (iterator.hasNext()) {
			nextItem = iterator.next();
		}

		return nextItem != null;
	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw (new NoSuchElementException("Iterator has no element left"));
		}

		T toReturn = nextItem;
		nextItem = null;
		return toReturn;
	}

	public T peek() {
		if (!hasNext()) {
			throw (new NoSuchElementException("Iterator has no element left"));
		}

		return nextItem;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		Iterator<Integer> it = list.iterator();
		PeekIterator<Integer> peekIterator = new PeekIterator<Integer>(it);

		System.out.println(peekIterator.hasNext());
		System.out.println(peekIterator.peek());
		System.out.println(peekIterator.peek());
		System.out.println(peekIterator.next());
		System.out.println(peekIterator.hasNext());
		System.out.println(peekIterator.peek());
		System.out.println(peekIterator.peek());
		System.out.println(peekIterator.next());

	}
}
