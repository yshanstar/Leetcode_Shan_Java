package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.List;

/*
 * Imagine we have an image where every pixel is white or black. We’ll represent this image as a simple 2D array (0 = black, 1 = white). With in this image are multiple solid black rectangles. Your goal is to find each rectangle and return its defining coordinates.

Here’s a sample “image” using JavaScript (feel free to rewrite in your language of choice):

var image = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 0, 1, 0, 0, 0, 1],
  [1, 0, 1, 1, 1, 1, 1],
  [1, 0, 1, 0, 0, 1, 1],
  [1, 1, 1, 0, 0, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
];
 */
public class BoxesinanImage {
	public static void main(String[] args) {
		BoxesinanImage test = new BoxesinanImage();

		int[][] image = new int[][] { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 0, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 0, 1, 1 }, { 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 } };

		List<Rectangle> boxes = test.findRectangles(image);

		for (Rectangle r : boxes) {
			System.out.println(r.ToString());
		}
	}

	public List<Rectangle> findRectangles(int[][] image) {
		List<Rectangle> res = new ArrayList<Rectangle>();

		if (image == null || image.length == 0 || image[0].length == 0) {
			return res;
		}

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				if (image[i][j] != 0) {
					continue;
				} else {
					Rectangle r = new Rectangle(new Point(i, j), new Point(i, j));
					int start = i + 1;

					while (start < image.length) {
						if (image[start][j] == 0) {
							image[start][j] = 2;
							start++;
						} else {
							break;
						}
					}

					r.rightBottom.x = start - 1;

					start = j + 1;
					while (start < image[0].length) {
						if (image[i][start] == 0) {
							image[i][start] = 2;
							start++;
						} else {
							break;
						}
					}

					r.rightBottom.y = start - 1;
					res.add(r);
					setVisited(image, r);

				}
			}
		}
		return res;
	}

	private void setVisited(int[][] image, Rectangle r) {
		if (r == null) {
			return;
		}

		for (int i = r.leftUpper.x; i <= r.rightBottom.x; i++) {
			for (int j = r.leftUpper.y; j <= r.rightBottom.y; j++) {
				image[i][j] = 2;
			}
		}
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Rectangle {
	Point leftUpper;
	Point rightBottom;

	public Rectangle(Point leftUpper, Point rightBottm) {
		this.leftUpper = leftUpper;
		this.rightBottom = rightBottm;
	}

	public String ToString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Rectangle Start x : " + leftUpper.x + ", Rectangle start y : " + leftUpper.y + ", ");
		sb.append("Rectangle End x : " + rightBottom.x + ", Rectangle end y : " + rightBottom.y);

		return sb.toString().trim();
	}
}
