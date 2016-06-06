package hack.leetcode.dev;

import java.util.LinkedList;

/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 * For example:

 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */
public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0) {
			return null;
		}

		int[] result = new int[numCourses];
		int index = 0;

		if (prerequisites.length == 0 || prerequisites[0].length == 0) {
			while (index < numCourses) {
				result[index] = index++;
			}
			return result;
		}

		int len = prerequisites.length;

		int[] pCounter = new int[numCourses];
		for (int i = 0; i < len; i++) {
			pCounter[prerequisites[i][0]]++;
		}

		// store courses that have no prerequisites
		LinkedList<Integer> queue = new LinkedList<Integer>();
		LinkedList<Integer> res = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (pCounter[i] == 0) {
				queue.add(i);
			}
		}

		// number of courses that have no prerequisites
		int numNoPre = queue.size();

		while (!queue.isEmpty()) {
			int top = queue.remove();
			res.add(top);
			for (int i = 0; i < len; i++) {
				// if a course's prerequisite can be satisfied by a course in
				// queue
				if (prerequisites[i][1] == top) {
					pCounter[prerequisites[i][0]]--;
					if (pCounter[prerequisites[i][0]] == 0) {
						numNoPre++;
						queue.add(prerequisites[i][0]);
					}
				}
			}
		}

		if (numNoPre == numCourses) {
			for (int i = 0; i < res.size(); i++) {
				result[i] = res.get(i);
			}
			return result;
		}

		return new int[0];
	}

	public static void main(String[] args) {
		CourseScheduleII test = new CourseScheduleII();
		test.findOrder(4, new int[][] { { 3, 0 }, { 0, 1 } });
	}
}
