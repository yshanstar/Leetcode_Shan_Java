package solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import util.Interval;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 */
public class MeetingRoomsII {
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});

		PriorityQueue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.end - o2.end;
			}
		});

		queue.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval tmp = queue.poll();
			if (intervals[i].start >= tmp.end) {
				tmp.start = intervals[i].start;
				tmp.end = intervals[i].end;
			} else {
				queue.add(intervals[i]);
			}
			queue.offer(tmp);
		}

		return queue.size();
	}
}
