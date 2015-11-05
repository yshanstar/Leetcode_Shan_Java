package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

 Note: The input string may contain letters other than the parentheses ( and ).

 Examples:
 "()())()" -> ["()()()", "(())()"]
 "(a)())()" -> ["(a)()()", "(a())()"]
 ")(" -> [""]
 */
public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<String>();
		if (s == null) {
			return res;
		}

		Queue<String> queues = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();

		queues.offer(s);
		visited.add(s);

		boolean found = false;

		while (!queues.isEmpty()) {
			String tmp = queues.poll();

			if (isValidParentheses(tmp)) {
				res.add(tmp);
				found = true;
			}

			if (found)
				continue;

			for (int i = 0; i < tmp.length(); i++) {
				if (tmp.charAt(i) != '(' && tmp.charAt(i) != ')') {
					continue;
				}

				String t = tmp.substring(0, i) + tmp.substring(i + 1);

				if (!visited.contains(t)) {
					visited.add(t);
					queues.add(t);
				}
			}
		}

		return res;
	}

	private boolean isValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			} else if (s.charAt(i) == ')') {
				if (count == 0) {
					return false;
				}
				count--;
			}
		}
		return count == 0;
	}

	public static void main(String[] args) {
		RemoveInvalidParentheses test = new RemoveInvalidParentheses();
		test.removeInvalidParentheses("))");
	}
}
