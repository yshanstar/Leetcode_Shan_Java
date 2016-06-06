package hack.leetcode.dev;

import hack.leetcode.ulti.Point;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsonaLine {
	public int maxPoints(Point[] points) {
		HashMap<Line, Set<Integer>> pointCount = new HashMap<Line, Set<Integer>>();
		HashMap<Point, Set<Integer>> samePoints = new HashMap<Point, Set<Integer>>();
		int result = 2;
		Set<Integer> pointsLine = null;
		if (points.length < result + 1) {
			return points.length;
		}
		for (int i = 0; i < points.length; i++) {
			Point first = points[i];
			for (int j = points.length - 1; j > i; j--) {
				Point second = points[j];
				if (first.x == second.x && first.y == second.y) {
					if (samePoints.containsKey(first)) {
						pointsLine = samePoints.get(first);
						pointsLine.add(i);
						pointsLine.add(j);
						samePoints.put(first, pointsLine);
						result = result < pointsLine.size() ? pointsLine.size() : result;
					} else {
						pointsLine = new HashSet<Integer>();
						pointsLine.add(i);
						pointsLine.add(j);
						samePoints.put(first, pointsLine);
					}
				} else {
					Line current = new Line(first, second);
					if (pointCount.containsKey(current)) {
						pointsLine = pointCount.get(current);
						pointsLine.add(i);
						pointsLine.add(j);
						pointCount.put(current, pointsLine);
						result = result < pointsLine.size() ? pointsLine.size() : result;
					} else {
						pointsLine = new HashSet<Integer>();
						pointsLine.add(i);
						pointsLine.add(j);
						pointCount.put(current, pointsLine);
					}
				}
			}
		}

		return result;
	}

	class Line {

		int a;
		int b;
		int c;

		Line() {
			a = 0;
			b = 0;
			c = 0;
		}

		Line(Point p1, Point p2) {
			a = p2.y - p1.y; // use p2.y - p1.y
			b = p1.x - p2.x;
			c = p2.x * p1.y - p1.x * p2.y;
			int gcd = gcd();
			a = a / gcd;
			b = b / gcd;
			c = c / gcd;
			if (a < 0 || a == 0 && b < 0) { // normalized a to be non-negative or b to be non-negative when a is 0
				a = -a;
				b = -b;
				c = -c;
			}
		}

		@Override
		public boolean equals(Object object) {
			if (object instanceof Line) {
				Line temp = (Line) object;
				return (this.a == temp.a && this.b == temp.b && this.c == temp.c);
			} else {
				return false;
			}

		}

		@Override
		public int hashCode() {
			return this.a ^ this.b * this.c;
		}

		public int gcd() {
			BigInteger int1 = new BigInteger(Integer.toString(a));
			BigInteger int2 = new BigInteger(Integer.toString(b));
			BigInteger int3 = new BigInteger(Integer.toString(c));
			BigInteger gcd0 = int1.gcd(int2);
			BigInteger gcd = gcd0.gcd(int3);
			return gcd.intValue();
		}
	}

	public static void main(String[] args) {
		Point[] points = new Point[15];
		points[0] = new Point(0, -12);
		points[1] = new Point(5, 2);
		points[2] = new Point(2, 5);
		points[3] = new Point(0, -5);
		points[4] = new Point(1, 5);
		points[5] = new Point(2, -2);
		points[6] = new Point(5, -4);

		points[7] = new Point(3, 4);
		points[8] = new Point(-2, 4);
		points[9] = new Point(-1, 4);
		points[10] = new Point(0, -5);
		points[11] = new Point(0, -8);
		points[12] = new Point(-2, -1);
		points[13] = new Point(0, -11);
		points[14] = new Point(0, -9);

		MaxPointsonaLine test = new MaxPointsonaLine();
		System.out.println(test.maxPoints(points));
	}
}
