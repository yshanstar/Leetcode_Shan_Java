package hack.leetcode.dev;

import hack.leetcode.ulti.Ultitool;

import java.util.Stack;

/*
 * Implement a basic calculator to evaluate a simple expression string.
 *  The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.

 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 */
public class BasicCalculatorII {
	public int calculate(String s) {
		if (s == null || s.trim().isEmpty()) {
			return 0;
		}
		return evalRPN(toRPN(s));
	}

	private int evalRPN(String rpn) {
		String[] tokens = rpn.split("\\s+");
		if (tokens == null || tokens.length == 0) {
			return 0;
		}

		Stack<Long> tokenStack = new Stack<Long>();
		long tmp = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (!isOperator(tokens[i])) {
				tokenStack.push(Long.parseLong(tokens[i]));
			} else {
				long operand1 = tokenStack.pop();
				long operand2 = tokenStack.pop();
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
				case '*':
					tmp = operand2 * operand1;
					tokenStack.push(tmp);
					break;
				case '/':
					tmp = operand2 / operand1;
					tokenStack.push(tmp);
					break;
				default:
					break;
				}
			}
		}
		return tokenStack.pop().intValue();
	}

	private String toRPN(String s) {
		char[] in = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < in.length; i++) {
			char c = in[i];
			switch (c) {
			case '+':
			case '-':
				while (!stack.isEmpty()) {
					sb.append(' ');
					sb.append(stack.pop());
				}
				sb.append(' ');
				stack.push(c);
				break;
			case '*':
			case '/':
				while (!stack.isEmpty() && (stack.peek() != '+' && stack.peek() != '-')) {
					sb.append(' ');
					sb.append(stack.pop());
				}
				sb.append(' ');
				stack.push(c);
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

	private boolean isOperator(String s) {
		if (s == null || s.trim().length() == 0) {
			return false;
		}
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}

	public static void main(String[] args) {
		BasicCalculatorII test = new BasicCalculatorII();
		Ultitool.print(test.calculate("3+2*2"));
	}
}
