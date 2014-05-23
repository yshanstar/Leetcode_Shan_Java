package hack.leetcode.dev;

import java.util.Stack;

/*
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath2 {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "/";
		}
		Stack<String> stringStack = new Stack<String>();
		String[] splits = path.trim().split("/");
		for (String s : splits) {
			if (s == null || s.length() == 0 || s.equals(".")) {
				// do nothing
			} else if (s.equals("..")) {
				if (!stringStack.isEmpty()) {
					stringStack.pop();
				}
			} else {
				stringStack.push(s);
			}
		}

		if (stringStack.isEmpty()) {
			return "/";
		}

		StringBuilder sb = new StringBuilder();
		while (!stringStack.isEmpty()) {
			sb.insert(0, stringStack.pop());
			sb.insert(0, "/");
		}

		return sb.toString();
	}
}
