package solution;

/*
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

 Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

 Rectangle Area
 Assume that the total area is never beyond the maximum possible value of int.
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int total = (C - A) * (D - B) + (G - E) * (H - F);
		int I = Math.max(A, E);
		int J = Math.min(C, G);
		int K = Math.max(B, F);
		int L = Math.min(D, H);

		if (I > J || K > L) {
			return total;
		}

		int union = (J - I) * (L - K);

		return total - union;
	}
}
