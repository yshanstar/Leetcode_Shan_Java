package hack.leetcode.dev;

import hack.leetcode.ulti.Point;

/*
 * Given a polygon and a point ‘p’, find if ‘p’ lies inside the polygon or not. The points lying on the border are considered inside.

 We strongly recommend to see the following post first.
 How to check if two given line segments intersect?

 Following is a simple idea to check whether a point is inside or outside.

 1) Draw a horizontal line to the right of each point and extend it to infinity

 1) Count the number of times the line intersects with polygon edges.

 2) A point is inside the polygon if either count of intersections is odd or
 point lies on an edge of polygon.  If none of the conditions is true, then 
 point lies outside.

 How to handle point ‘g’ in the above figure?
 Note that we should returns true if the point lies on the line or same as one of the vertices of the given polygon. To handle this, after checking if the line from ‘p’ to extreme intersects, we check whether ‘p’ is colinear with vertices of current line of polygon. If it is coliear, then we check if the point ‘p’ lies on current side of polygon, if it lies, we return true, else false.
 */
public class CheckPointsInPolygon {
	public boolean isInside(Point[] polygon, Point p) {
		if (polygon == null || polygon.length < 3) {
			return false;
		}

		Point infiniti = new Point(Integer.MAX_VALUE, p.y);

		int count = 0;
		int i = 0;
		do {
			int next = (i + 1) % polygon.length;
			if (hasIntersect(polygon[i], polygon[next], p, infiniti)) {

				// If the point 'p' is colinear with line segment 'i-next',
				// then check if it lies on segment. If it lies, return true,
				// otherwise false
				if (orientation(polygon[i], p, polygon[next]) == 0) {
					return onSegment(polygon[i], p, polygon[next]);
				}
				count++;
			}
			i = next;
		} while (i != 0);

		return count % 2 == 1;
	}

	// Given 3 colinear points
	// Check if point q is on segment pr
	private boolean onSegment(Point p, Point q, Point r) {
		if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x)
				&& q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) {
			return true;
		}

		return false;
	}

	// To find orientation of ordered triplet (p, q, r).
	// Math was (y2-y1)/(x2-x1) - (y3-y2)/(x3-x2)
	// Convert to (y2-y1)*(x3-x2) - (y3-y2)*(x2-x1)
	// 0 coliner
	// 1 clockwise
	// 2 counter clock wise
	private int orientation(Point p, Point q, Point r) {
		int val = (q.y - p.y) * (r.x - q.x) - (r.y - q.y) * (q.x - p.x);

		if (val == 0) {
			return 0;
		}

		return (val > 0) ? 1 : 2;
	}

	// The function that returns true if line segment 'p1q1'
	// and 'p2q2' intersect.
	private boolean hasIntersect(Point p1, Point q1, Point p2, Point q2) {
		int o1 = orientation(p1, q1, p2);
		int o2 = orientation(p1, q1, q2);
		int o3 = orientation(p2, q2, p1);
		int o4 = orientation(p2, q2, q1);

		if (o1 != o2 && o3 != o4) {
			return true;
		}

		if (o1 == 0 && onSegment(p1, p2, q1)) {
			return true;
		}

		if (o2 == 0 && onSegment(p1, q2, q1)) {
			return true;
		}

		if (o3 == 0 && onSegment(p2, p1, q2)) {
			return true;
		}

		if (o4 == 0 && onSegment(p2, q1, q2)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		CheckPointsInPolygon test = new CheckPointsInPolygon();

		Point[] polygon = { new Point(0, 0), new Point(10, 0),
				new Point(10, 10), new Point(0, 10) };

		Point p = new Point(20, 20);

		System.out.println(test.isInside(polygon, p));

		p = new Point(5, 5);

		System.out.println(test.isInside(polygon, p));

		Point[] polygon2 = { new Point(0, 0), new Point(5, 5), new Point(5, 0) };
		p = new Point(3, 3);
		System.out.println(test.isInside(polygon2, p));

		p = new Point(5, 1);
		System.out.println(test.isInside(polygon2, p));

		p = new Point(8, 1);
		System.out.println(test.isInside(polygon2, p));

		Point[] polygon3 = { new Point(0, 0), new Point(10, 0),
				new Point(10, 10), new Point(0, 10) };
		p = new Point(-1, 10);
		System.out.println(test.isInside(polygon3, p));

	}
}
