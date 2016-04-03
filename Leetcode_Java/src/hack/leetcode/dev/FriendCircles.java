package hack.leetcode.dev;

import java.util.LinkedList;
import java.util.Queue;

/*
 * There are NN students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature, i.e., if AA is friend of BB and BB is friend of CC, then AA is also friend of CC. A friend circle is a group of students who are directly or indirectly friends.

 You are given a Matrix MM which consists of characters Y or N. If M[i][j]=YM[i][j]=Y, then ithith and jthjth students are friends with each other, otherwise not. You have to print the total number of friend circles in the class.

 Input Format 
 First line of the input contains an integer NN - (size of the matrix), followed by N lines each having N characters.

 Output Format 
 Print the maximum number of friend circles.

 Constraints 
 Each element of matrix friends will be Y or N. 
 Number of rows and columns will be equal in the matrix.

 M[i][i]=YM[i][i]=Y, where 0<N<N 
 M[i][j]M[i][j] = M[j][i]M[j][i], where 0<N<N 
 Sample Input#00

 4
 YYNN
 YYYN
 NYYN
 NNNY
 Sample Output

 2
 Explanation: There are two pairs of friends (0,1)(0,1) and (1,2)(1,2). So (0,2)(0,2) is also a pair of friends by transitivity. So first friend circle contains (0,1,2)(0,1,2), and second friend circle contains only student 33.

 Sample Input#01

 5
 YNNNN
 NYNNN
 NNYNN
 NNNYN
 NNNNY
 Sample Output#01

 5
 */
public class FriendCircles {
	static int TotalCircle = 0;

	public static int friendCircles(String[] friends) {
		if (friends == null || friends.length == 0) {
			return 0;
		}

		int circles = 0;
		int n = friends.length;
		boolean[] hasVisited = new boolean[n];

		Queue<Integer> peopleQueue = new LinkedList<Integer>();
		peopleQueue.offer(0);
		hasVisited[0] = true;

		while (!peopleQueue.isEmpty()) {
			int cur = peopleQueue.poll();
			char[] currFriends = friends[cur].toCharArray();

			for (int i = 0; i < currFriends.length; i++) {
				if (currFriends[i] == 'Y' && i != cur && !hasVisited[i]) {
					peopleQueue.offer(i);// i belongs the the circle with curr
					hasVisited[i] = true;
				}
			}

			if (peopleQueue.isEmpty()) {// find another component/circle
				circles++;
				for (int i = 0; i < n; i++) {// offer next unvisited friend to
												// the queue
					if (!hasVisited[i]) {
						peopleQueue.offer(i);// create a new component
						hasVisited[i] = true;
						break;
					}
				}
			}
		}
		return circles;
	}

	public static int friendCirclesII(String[] friends) {
		if (friends == null || friends.length == 0) {
			return 0;
		}

		int n = friends.length;
		TotalCircle = n;
		char[][] friend = new char[n][n];

		for (int i = 0; i < n; i++) {
			friend[i] = friends[i].toCharArray();
		}

		int[] parents = new int[n];

		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (friend[i][j] == 'Y' && !isConnected(parents, i, j)) {
					union(parents, i, j);
				}
			}
		}

		return TotalCircle;
	}

	private static boolean isConnected(int[] parents, int p1, int p2) {
		return parents[p1] == parents[p2];
	}

	private static void union(int[] parents, int p1, int p2) {
		int m = parents[p1];
		int n = parents[p2];

		for (int i = 0; i < parents.length; i++) {
			if (parents[i] == m) {
				parents[i] = n;
				TotalCircle--;
			}
		}
	}

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		// sc.nextLine();
		//
		// String[] friends = new String[n];
		// for (int i = 0; i < n; i++) {
		// friends[i] = sc.nextLine();
		// }

		String[] friends = new String[] { "YNNNN", "NYNNN", "NNYNN", "NNNYN",
				"NNNNY" };

		System.out.println(friendCircles(friends));
		System.out.println(friendCirclesII(friends));

		friends = new String[] { "YYNN", "YYYN", "NYYN", "NNNY" };

		System.out.println(friendCircles(friends));
		System.out.println(friendCirclesII(friends));

		friends = new String[] { "YYNY", "YYYN", "NYYN", "YNNY" };

		System.out.println(friendCircles(friends));
		System.out.println(friendCirclesII(friends));
	}
}
