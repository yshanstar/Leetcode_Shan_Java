package solution;

import java.util.Stack;

/*
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculator {
	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int res = 0, val = 0, sign = 1;
		Stack<Integer> stack = new Stack<Integer>();

		s.trim();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				val += sum * sign;
			} else if (c == '+') {
				sign = 1;
			} else if (c == '-') {
				sign = -1;
			} else if (c == '(') {
				stack.push(val);
				stack.push(sign);
				val = 0;
				sign = 1;
			} else if (c == ')') {
				val = val * stack.pop() + stack.pop();
			}
		}
		return val;
	}
}
