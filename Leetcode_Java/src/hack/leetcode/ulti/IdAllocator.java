package hack.leetcode.ulti;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class IdAllocator {
	private static int x;
	private static int max;
	private static Queue<Integer> freeId;

	public IdAllocator(int max) {
		IdAllocator.x = 0;
		IdAllocator.max = max;
		IdAllocator.freeId = new LinkedList<Integer>();
	}

	public static int alloc() {
		if (freeId.isEmpty()) {
			if (x == max) {
				System.out.println("No id available");
				return -1;
			}
			int id = x++;
			return id;
		} else {
			int id = freeId.poll();
			return id;
		}
	}

	public static boolean free(int id) {
		if (id >= x) {
			System.out.println("id: " + id + " has not been assigned");
			return false;
		}

		if (freeId.contains(id)) {
			System.out.println("id: " + id + " has not been free before");
			return true;
		}

		freeId.offer(id);
		return true;
	}

	public static void main(String[] args) {
		IdAllocator idAllocator = new IdAllocator(Integer.MAX_VALUE);
		Random rm = new Random();
		for (int i = 0; i < 15; i++) {
			System.out.println("Assign Id : " + IdAllocator.alloc());

			if (i > 0 && (i % 5 == 0 || i % 3 == 0)) {
				int id = rm.nextInt(i);
				System.out.println("Free Id : " + id);
				IdAllocator.free(id);
			}
		}
	}
}
