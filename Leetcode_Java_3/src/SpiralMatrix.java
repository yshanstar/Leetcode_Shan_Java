import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return res;
		}

		int row = matrix.length;
		int col = matrix[0].length;

		int x = 0;
		int y = 0;

		while (row > 0 && col > 0) {
			if (row == 1) {
				for (int i = 0; i < col; i++) {
					res.add(matrix[x][y++]);
				}
				break;
			} else if (col == 1) {
				for (int i = 0; i < row; i++) {
					res.add(matrix[x++][y]);
				}
				break;
			}

			for (int i = 0; i < col - 1; i++) {
				res.add(matrix[x][y++]);
			}

			for (int i = 0; i < row - 1; i++) {
				res.add(matrix[x++][y]);
			}

			for (int i = 0; i < col - 1; i++) {
				res.add(matrix[x][y--]);
			}

			for (int i = 0; i < row - 1; i++) {
				res.add(matrix[x--][y]);
			}

			x++;
			y++;
			row -= 2;
			col -= 2;
		}

		return res;
	}
}
