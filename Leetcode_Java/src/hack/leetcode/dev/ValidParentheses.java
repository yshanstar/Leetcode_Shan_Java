package hack.leetcode.dev;

import java.util.Stack;

/*
 *	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *	The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() < 2) {
			return false;
		}
		char[] strArray = s.toCharArray();
		Stack<Character> parenthesesS = new Stack<Character>();
		for (char c : strArray) {
			switch (c) {
			case '(':
				parenthesesS.push(c);
				break;
			case '{':
				parenthesesS.push(c);
				break;
			case '[':
				parenthesesS.push(c);
				break;
			case ')':
				if (parenthesesS.empty() || !parenthesesS.pop().equals('(')) {
					return false;
				}
				break;
			case '}':
				if (parenthesesS.empty() || !parenthesesS.pop().equals('{')) {
					return false;
				}
				break;
			case ']':
				if (parenthesesS.empty() || !parenthesesS.pop().equals('[')) {
					return false;
				}
				break;
			default:
				break;
			}
		}
		return parenthesesS.empty();
	}
}
