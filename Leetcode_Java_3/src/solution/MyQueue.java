package solution;

import java.util.Stack;

/*
 * Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
 */
public class MyQueue {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		s1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (!s2.isEmpty()) {
			s2.pop();
		} else {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			if (!s2.isEmpty()) {
				s2.pop();
			}
		}
	}

	// Get the front element.
	public int peek() {
		if (!s2.isEmpty()) {
			return s2.peek();
		} else {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			if (!s2.isEmpty()) {
				return s2.peek();
			}
			return s1.peek();
		}
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}
}

class MyQueueTwo {
	Stack<Integer> s = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		s.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		Stack<Integer> tmp = new Stack<Integer>();
		while (!s.isEmpty()) {
			tmp.push(s.pop());
		}
		tmp.pop();
		while (!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
	}

	// Get the front element.
	public int peek() {
		Stack<Integer> tmp = new Stack<Integer>();
		while (!s.isEmpty()) {
			tmp.push(s.pop());
		}
		int res = tmp.peek();
		while (!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
		return res;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return s.isEmpty();
	}
}
