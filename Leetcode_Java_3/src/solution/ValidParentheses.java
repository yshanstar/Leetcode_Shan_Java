package solution;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
				stack.push(c);
				break;
			case '[':
				stack.push(c);
				break;
			case '{':
				stack.push(c);
				break;
			case ')':
				if (stack.isEmpty() || !stack.peek().equals('(')) {
					return false;
				}
				stack.pop();
				break;
			case '}':
				if (stack.isEmpty() || !stack.peek().equals('{')) {
					return false;
				}
				stack.pop();
				break;
			case ']':
				if (stack.isEmpty() || !stack.peek().equals('[')) {
					return false;
				}
				stack.pop();
				break;
			default:
				return false;
			}
		}
		return stack.isEmpty();
	}
}
