package solution;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> min = new Stack<Integer>();

	public void push(int x) {
		int curMin = min.isEmpty() ? Integer.MAX_VALUE : min.peek();
		if (x <= curMin) {
			min.push(x);
		}
		stack.push(x);
	}

	public void pop() {
		int v = stack.pop();
		if (v == min.peek()) {
			min.pop();
		}
		return;
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min.peek();
	}
}
