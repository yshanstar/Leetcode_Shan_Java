package solution;

import java.util.Stack;

/*
 * Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
You may assume that the given expression is always valid.
Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
 */
public class BasicCalculatorII {
	public int calculate(String s) {
		if (s == null || (s.length() == 0)) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}
			if (!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i) || (i == s.length() - 1)) {
				if (sign == '-') {
					stack.push(-num);
				}
				if (sign == '+') {
					stack.push(num);
				}
				if (sign == '*') {
					stack.push(stack.pop() * num);
				}
				if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = s.charAt(i);
				num = 0;
			}
		}
		int re = 0;
		for (int i : stack) {
			re += i;
		}
		return re;
	}

	public static void main(String[] args) {
		BasicCalculatorII test = new BasicCalculatorII();
		test.calculate("0+0");
	}
}
