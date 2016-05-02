package solution;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {
	/** Initialize your data structure here. */
	Queue<Integer> nums;
	double avg;
	int capacity;

	public MovingAverageFromDataStream(int size) {
		nums = new LinkedList<Integer>();
		avg = 0.0;
		capacity = size;
	}

	public double next(int val) {
		if (nums.size() == 0) {
			avg = (double) val;
			nums.offer(val);
		} else {
			double total = avg * nums.size();
			if (nums.size() == this.capacity) {
				total -= nums.poll();
			}
			total += (double) val;
			nums.offer(val);
			avg = total / nums.size();
		}

		return avg;
	}
}
