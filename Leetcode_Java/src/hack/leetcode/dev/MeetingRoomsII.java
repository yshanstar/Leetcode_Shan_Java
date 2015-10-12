package hack.leetcode.dev;

import hack.leetcode.ulti.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */
public class MeetingRoomsII {
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval lhs, Interval rhs) {
				if (lhs.start == rhs.start)
					return 0;
				return lhs.start > rhs.start ? 1 : -1;
			}
		});

		PriorityQueue<Integer> meetingQueue = new PriorityQueue<Integer>();
		meetingQueue.offer(intervals[0].end);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start >= meetingQueue.peek()) {
				meetingQueue.poll();
			}
			meetingQueue.offer(intervals[i].end);
		}

		return meetingQueue.size();

	}
}
