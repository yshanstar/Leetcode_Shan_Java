package hack.leetcode.dev;

import java.util.Stack;

/*
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {
	public static String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "/";
		}

		Stack<String> stringStack = new Stack<String>();
		String[] splits = path.trim().split("/");
		for (String s : splits) {
			if (s == null || s.length() == 0 || s.equals(".")) {
				// Do nothing
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

		StringBuffer buf = new StringBuffer();
		while (!stringStack.isEmpty()) {
			buf.insert(0, stringStack.pop());
			buf.insert(0, "/");
		}

		return buf.toString();
	}

	public static void main(String[] args) {
		System.out.println(simplifyPath("../a"));
	}
}
