package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 
 https://leetcode.com/discuss/85141/java-6ms-topological-sort-solution-with-explanation
 */
public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];

		if (numCourses == 0) {
			return res;
		}

		if (prerequisites == null || prerequisites.length == 0) {
			for (int i = 0; i < numCourses; i++) {
				res[i] = i;
			}

			return res;
		}

		int[] counter = new int[numCourses];
		Queue<Integer> nonPreCourse = new LinkedList<Integer>();
		List<Integer> tmpRes = new ArrayList<Integer>();

		for (int[] prerequisite : prerequisites) {
			counter[prerequisite[0]]++;
		}

		for (int i = 0; i < counter.length; i++) {
			if (counter[i] == 0) {
				nonPreCourse.offer(i);
			}
		}

		// number of courses that have no prerequisites
		int numNoPre = nonPreCourse.size();

		while (!nonPreCourse.isEmpty()) {
			int course = nonPreCourse.poll();
			tmpRes.add(course);

			for (int[] prerequisite : prerequisites) {
				if (prerequisite[1] == course) {
					counter[prerequisite[0]]--;
					if (counter[prerequisite[0]] == 0) {
						numNoPre++;
						nonPreCourse.offer(prerequisite[0]);
					}
				}
			}
		}

		if (numNoPre == numCourses) {
			for (int i = 0; i < tmpRes.size(); i++) {
				res[i] = tmpRes.get(i);
			}
			return res;
		}

		return new int[0];
	}
}
