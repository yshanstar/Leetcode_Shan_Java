package hack.leetcode.dev;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses2 {
	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
				stack.push(c);
				break;
			case '{':
				stack.push(c);
				break;
			case '[':
				stack.push(c);
				break;
			case ')':
				if (stack.empty() || (!stack.empty() && !stack.pop().equals('('))) {
					return false;
				}
				break;
			case '}':
				if (stack.empty() || (!stack.empty() && !stack.pop().equals('{'))) {
					return false;
				}
				break;
			case ']':
				if (stack.empty() || (!stack.empty() && !stack.pop().equals('['))) {
					return false;
				}
				break;
			}
		}
		return stack.empty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("(){}[]"));
	}
}
