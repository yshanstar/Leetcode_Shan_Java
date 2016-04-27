package solution;

import java.util.LinkedList;
import java.util.Queue;

/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0 || numCourses == 0) {
			return true;
		}

		int[] counter = new int[numCourses];

		for (int[] prerequisite : prerequisites) {
			counter[prerequisite[0]]++;
		}

		Queue<Integer> nonPreCourse = new LinkedList<Integer>();
		for (int i = 0; i < counter.length; i++) {
			if (counter[i] == 0) {
				nonPreCourse.offer(i);
			}
		}

		int numOfNonPre = nonPreCourse.size();

		while (!nonPreCourse.isEmpty()) {
			int course = nonPreCourse.poll();

			for (int[] prerequisite : prerequisites) {
				if (prerequisite[1] == course) {
					counter[prerequisite[0]]--;

					if (counter[prerequisite[0]] == 0) {
						numOfNonPre++;
						nonPreCourse.offer(prerequisite[0]);
					}
				}
			}
		}

		return (numOfNonPre == numCourses);
	}
}
