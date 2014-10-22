package solution;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		if (n == 0) {
			res.add(0);
			return res;
		}
		res.add(0);
		res.add(1);

		for (int i = 1; i < n; i++) {
			int num = 1 << i;
			List<Integer> tmp = new ArrayList<Integer>(res);
			for (int j = res.size() - 1; j >= 0; j--) {
				tmp.add(tmp.get(j) + num);
			}
			res = tmp;
		}
		return res;
	}
}
