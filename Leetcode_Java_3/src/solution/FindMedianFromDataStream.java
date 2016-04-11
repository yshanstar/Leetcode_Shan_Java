package solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 Examples: 
 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.
 For example:

 add(1)
 add(2)
 findMedian() -> 1.5
 add(3) 
 findMedian() -> 2
 */
public class FindMedianFromDataStream {
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
			new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(
			new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o1.compareTo(o2);
				}
			});

	// Adds a number into the data structure.
	public void addNum(int num) {
		int size1 = maxHeap.size(), size2 = minHeap.size();
		if (size1 == 0) {
			maxHeap.offer(num);
			return;
		} else if (size2 == 0) {
			if (num < maxHeap.peek()) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
			return;
		}

		int n1 = maxHeap.peek();
		int n2 = minHeap.peek();

		if (num < n1) {
			maxHeap.offer(num);
		} else if (num >= n1 && num <= n2) {
			if (size1 <= size2) {
				maxHeap.offer(num);
			} else {
				minHeap.offer(num);
			}
		} else {
			minHeap.offer(num);
		}

		if (maxHeap.size() + 2 == minHeap.size()) {
			maxHeap.add(minHeap.poll());
		} else if (maxHeap.size() == minHeap.size() + 2) {
			minHeap.add(maxHeap.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			int i = maxHeap.peek();
			int j = minHeap.peek();
			return ((double) (i + j)) / 2;
		} else if (maxHeap.size() > minHeap.size()) {
			return (double) maxHeap.peek();
		} else {
			return (double) minHeap.peek();
		}
	}

	public static void main(String[] args) {
		FindMedianFromDataStream test = new FindMedianFromDataStream();
		test.addNum(1);
		test.addNum(2);
		test.addNum(3);
		System.out.println(test.findMedian());
	}
}
