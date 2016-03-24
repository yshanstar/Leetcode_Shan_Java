package solution;

import java.util.LinkedList;
import java.util.Queue;

/*
 * mplement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
 */
public class MyStack {
	Queue<Integer> first = new LinkedList<Integer>();
	Queue<Integer> second = new LinkedList<Integer>();
	int topElement;

	// Push element x onto stack.
	public void push(int x) {
		first.offer(x);
		topElement = x;
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (!first.isEmpty()) {
			int n = first.size();
			for (int i = 0; i < n - 1; i++) {
				if (i == n - 2) {
					topElement = first.peek();
				}
				second.offer(first.poll());
			}
			first.poll();
		}
		Queue<Integer> tmp = second;
		second = first;
		first = tmp;

	}

	// Get the top element.
	public int top() {
		return topElement;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return first.isEmpty() && second.isEmpty();
	}

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		System.out.println(myStack.top());
		myStack.pop();
		System.out.println(myStack.top());
		myStack.pop();
		System.out.println(myStack.top());
		myStack.pop();
	}
}

class MyStackTwo {
	Queue<Integer> q = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		q.offer(x);
		for(int i=1; i<q.size(); i++){
			q.offer(q.poll());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		q.poll();

	}

	// Get the top element.
	public int top() {
		return q.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q.isEmpty();
	}
}
