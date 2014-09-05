import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int max = 0;
		int last = -1;
		Stack<Integer> left = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left.push(i);
			} else {
				if (left.isEmpty()) {
					last = i;
				} else {
					left.pop();
					if (left.isEmpty()) {
						max = Math.max(max, i - last);
					} else {
						max = Math.max(max, i - left.peek());
					}
				}
			}
		}

		return max;

	}
}
