package hack.leetcode.dev;

import hack.leetcode.ulti.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 */
public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return true;
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval lhs, Interval rhs) {
				if (lhs.start == rhs.start)
					return 0;
				return lhs.start > rhs.start ? 1 : -1;
			}
		});

		List<Interval> res = new ArrayList<Interval>();
		Interval meeting = intervals[0];
		res.add(meeting);

		for (int i = 1; i < intervals.length; i++) {
			Interval tmp = res.get(res.size() - 1);
			Interval current = intervals[i];

			if (isOverlap(tmp, current)) {
				return false;
			} else {
				res.add(current);
			}
		}

		return true;
	}

	private static boolean isOverlap(Interval i, Interval j) {
		if (i.equals(j)) {
			return true;
		}

		return (i.start < j.end) && (j.start < i.end);
	}
}
