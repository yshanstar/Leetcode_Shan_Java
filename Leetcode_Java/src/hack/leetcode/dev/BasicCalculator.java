package hack.leetcode.dev;

import hack.leetcode.ulti.Ultitool;

import java.util.Stack;

/*
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 */

public class BasicCalculator {
	public int calculate(String s) {
		if (s == null || s.trim().isEmpty()) {
			return 0;
		}
		return evalRPN(toRPN(s));
	}

	public int evalRPN(String rpn) {
		String[] tokens = rpn.split("\\s+");
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		Stack<Integer> tokenStack = new Stack<Integer>();
		int tmp = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (!isOperator(tokens[i])) {
				tokenStack.push(Integer.parseInt(tokens[i]));
			} else {
				int operand1 = tokenStack.pop();
				int operand2 = tokenStack.pop();
				char operator = tokens[i].charAt(0);
				switch (operator) {
				case '+':
					tmp = operand1 + operand2;
					tokenStack.push(tmp);
					break;
				case '-':
					tmp = operand2 - operand1;
					tokenStack.push(tmp);
					break;
				default:
					break;
				}
			}
		}
		return tokenStack.pop();
	}

	private boolean isOperator(String s) {
		if (s == null || s.trim().length() == 0) {
			return false;
		}
		return s.equals("+") || s.equals("-");
	}

	public String toRPN(String s) {
		char[] in = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < in.length; i++) {
			char c = in[i];
			switch (c) {
			case '+':
			case '-':
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(' ');
					sb.append(stack.pop());
				}
				sb.append(' ');
				stack.push(c);
				break;
			case '(':
				stack.push(c);
				break;
			case ')':
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(' ');
					sb.append(stack.pop());
				}
				stack.pop();
				break;
			case ' ':
				break;
			default:
				sb.append(c);
				break;
			}
		}

		while (!stack.isEmpty()) {
			sb.append(' ');
			sb.append(stack.pop());

		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		BasicCalculator test = new BasicCalculator();
		String rpn = test.toRPN("5+(2-1)");
		Ultitool.print(rpn);
		Ultitool.print(test.evalRPN(rpn));
	}
}
