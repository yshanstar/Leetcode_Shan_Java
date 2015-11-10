package hack.leetcode.dev;

/*
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

 For example, given the following image:

 [
 "0010",
 "0110",
 "0100"
 ]
 and x = 0, y = 2,
 Return 6.
 */
public class SmallestRectangleEnclosingBlackPixels {
	int xMin, xMax;
	int yMin, yMax;

	public int minArea(char[][] image, int x, int y) {
		if (image == null || image.length == 0 || image[0].length == 0
				|| image[x][y] != '1') {
			return 0;
		}

		xMin = xMax = x;
		yMin = yMax = y;

		dfsHelper(image, x, y);

		return (xMax - xMin + 1) * (yMax - yMin + 1);
	}

	private void dfsHelper(char[][] image, int x, int y) {
		if (x < 0 || x >= image.length || y < 0 || y >= image[0].length
				|| image[x][y] != '1') {
			return;
		}

		if (image[x][y] == '1') {
			image[x][y] = '*';
			xMin = Math.min(xMin, x);
			xMax = Math.max(xMax, x);
			yMin = Math.min(yMin, y);
			yMax = Math.max(yMax, y);
		}

		dfsHelper(image, x - 1, y);
		dfsHelper(image, x + 1, y);
		dfsHelper(image, x, y - 1);
		dfsHelper(image, x, y + 1);

		return;
	}

	public static void main(String[] args) {
		SmallestRectangleEnclosingBlackPixels test = new SmallestRectangleEnclosingBlackPixels();
		char[][] image = new char[][] {{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
		test.dfsHelper(image, 0, 2);
	}
}
