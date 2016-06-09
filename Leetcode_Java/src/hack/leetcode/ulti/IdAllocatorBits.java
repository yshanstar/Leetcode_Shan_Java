package hack.leetcode.ulti;

import java.util.BitSet;
import java.util.Random;

public class IdAllocatorBits {
	private static BitSet bitSet;

	public IdAllocatorBits(int max) {
		IdAllocatorBits.bitSet = new BitSet();
		for (int i = 0; i < max; i++) {
			bitSet.set(i);
		}
	}

	public static int alloc() {
		if (bitSet.isEmpty()) {
			System.out.println("No available Id");
			return -1;
		}
		int id = bitSet.nextSetBit(0);
		bitSet.flip(id);
		return id;
	}

	public static boolean free(int id) {
		if (id >= bitSet.size()) {
			System.out.println("id :" + id + " is not a valid id");
			return false;
		}

		if (bitSet.get(id)) {
			System.out.println("id :" + id + " is free");
			return true;
		}

		bitSet.flip(id);
		return true;
	}

	public static void main(String[] args) {
		IdAllocatorBits idAllocator = new IdAllocatorBits(1000);
		Random rm = new Random();
		for (int i = 0; i < 15; i++) {
			System.out.println("Assign Id : " + IdAllocatorBits.alloc());

			if (i > 0 && (i % 5 == 0 || i % 3 == 0)) {
				int id = rm.nextInt(i);
				System.out.println("Free Id : " + id);
				IdAllocatorBits.free(id);
			}
		}
	}
}
