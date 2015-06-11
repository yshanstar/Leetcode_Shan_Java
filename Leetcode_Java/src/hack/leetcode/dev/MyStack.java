package hack.leetcode.dev;

import hack.leetcode.ulti.Ultitool;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	int topElement;

	// Push element x onto stack.
	public void push(int x) {
		q1.add(x);
		topElement = x;
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (!q1.isEmpty()) {
			for (int i = 0; i < q1.size() - 1; i++) {
				if (i == q1.size() - 2) {
					topElement = q1.peek();
				}
				q2.add(q1.poll());
			}
			q1.poll();
		}
		Queue<Integer> tmp = q2;
		q2 = q1;
		q1 = tmp;
	}

	// Get the top element.
	public int top() {
		return topElement;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return (q1.size() == 0 && q2.size() == 0);
	}

	public static void main(String[] args) {
		MyStack test = new MyStack();
		test.push(1);
		Ultitool.print(test.top());
		Ultitool.print(test.empty());
	}

}