package hack.leetcode.dev;

/*
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		final int I = Math.max(A, E);
		final int J = Math.max(B, F);
		final int K = Math.min(C, G);
		final int L = Math.min(D, H);

		int total = (C - A) * (D - B) + (G - E) * (H - F);

		if (I > K || J > L) {
			return total;
		}

		int union = (K - I) * (L - J);
		return total - union;
	}
}
