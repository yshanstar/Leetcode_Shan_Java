package hack.leetcode.dev;

import java.util.Stack;

/*
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 */
public class MyQueue {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		stack1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (!stack2.isEmpty()) {
			stack2.pop();
		} else {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			if (!stack2.isEmpty()) {
				stack2.pop();
			}
		}
	}

	// Get the front element.
	public int peek() {
		if (!stack2.isEmpty()) {
			return stack2.peek();
		} else {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			if (!stack2.isEmpty()) {
				return stack2.peek();
			}
			return stack1.peek();
		}

	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}
