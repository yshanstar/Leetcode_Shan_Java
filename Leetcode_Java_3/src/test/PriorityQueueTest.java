package test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(
				new Comparator<Integer>() {
					public int compare(Integer i1, Integer i2) {
						return i1.intValue() - i2.intValue();
					}
				});

		int[] nums = new int[] { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };

		for (int i : nums) {
			minHeap.offer(i);
		}

		while (minHeap.size() > 0) {
			System.out.print(minHeap.poll() + ", ");
		}

		System.out.println();

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
				new Comparator<Integer>() {
					public int compare(Integer i1, Integer i2) {
						return i2.intValue() - i1.intValue();
					}
				});

		for (int i : nums) {
			maxHeap.offer(i);
		}

		while (maxHeap.size() > 0) {
			System.out.print(maxHeap.poll() + ", ");
		}
	}
}
