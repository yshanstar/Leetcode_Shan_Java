package hack.leetcode.dev;

import java.util.Stack;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();

	public void push(int x) {
		if (min.isEmpty()) {
			min.push(x);
		} else {
			int curMin = min.peek();
			if (x <= curMin) {
				min.push(x);
			}
		}
		stack.push(x);
	}

	public void pop() {
		if (!stack.isEmpty()) {
			int value = stack.pop();
			int curMin = min.peek();
			if (value == curMin) {
				min.pop();
			}
		}
		return;
	}

	public int top() {
		if (!stack.isEmpty()) {
			return stack.peek();
		}
		return -1;
	}

	public int getMin() {
		if(!min.isEmpty()){
			return min.peek();
		}
		return Integer.MAX_VALUE;
	}
}
