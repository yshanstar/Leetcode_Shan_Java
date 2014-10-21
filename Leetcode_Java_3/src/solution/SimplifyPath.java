package solution;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		if (path == null || path.trim().isEmpty()) {
			return "/";
		}

		path = path.trim();

		Stack<String> stack = new Stack<String>();
		String[] splits = path.split("/");

		for (String s : splits) {
			if (s == null || s.length() == 0 || s.equals(".")) {
				// do nothing
			} else if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(s);
			}
		}

		if (stack.isEmpty()) {
			return "/";
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
			sb.insert(0, "/");
		}

		return sb.toString();
	}
}
