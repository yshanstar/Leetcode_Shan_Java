package hack.leetcode.dev;

import java.util.Stack;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
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
				case '*':
					tmp = operand1 * operand2;
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
		return tokenStack.pop();
	}

	private boolean isOperator(String s) {
		if (s == null || s.trim().length() == 0) {
			return false;
		}
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}
}
