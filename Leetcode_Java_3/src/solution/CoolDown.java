package solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * # Tasks: 1, 1, 2, 1
# Recovery interva (cooldown): 2
# Output: 7  (order is 1 _ _ 1 2 _ 1). 
# Example 2
# Tasks: 1, 2, 3, 1, 2, 3
# Recovery interval (cooldown): 3
# Output: 7  (order is 1 2 3 _ 1 2 3)

# Example 3
# Tasks: 1, 2, 3 ,4, 5, 6, 2, 4, 6, 1, 2, 4
# Recovery interval (cooldown): 6
# Output: 18  (1 2 3 4 5 6 _ _ 2 _ 4 _ 6 1 _ 2 _ 4)
*/
public class CoolDown {
	public static List<String> Printer(int[] tasks, int cooldown) {
		List<String> res = new LinkedList<String>();
		if (tasks == null) {
			return res;
		}

		if (cooldown == 0) {
			for (int i : tasks) {
				res.add(String.valueOf(i));
			}

			return res;
		}

		Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
		int idx = 0;
		for (int i = 0; i < tasks.length; i++) {
			while (maps.containsKey(tasks[i]) && maps.get(tasks[i]) + cooldown >= idx) {
				res.add("_");
				idx++;
			}
			res.add(String.valueOf(tasks[i]));
			maps.put(tasks[i], idx);
			idx++;
		}

		return res;
	}

	public static void main(String[] args) {
		List<String> res = Printer(new int[] { 1, 1, 2, 1 }, 2);
		printList(res);

		res = Printer(new int[] { 1, 2, 3, 1, 2, 3 }, 3);
		printList(res);

		res = Printer(new int[] { 1, 2, 3, 4, 5, 6, 2, 4, 6, 1, 2, 4 }, 6);
		printList(res);
	}

	private static void printList(List<String> res) {
		for (String s : res) {
			System.out.print(s);
		}

		System.out.println();
	}
}
