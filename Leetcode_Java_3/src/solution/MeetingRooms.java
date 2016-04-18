package solution;

import java.util.Arrays;
import java.util.Comparator;

import util.Interval;

/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
 */
public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval arg0, Interval arg1) {
				// TODO Auto-generated method stub
				return arg0.start - arg1.start;
			}
		});

		int end = -1;
		for (Interval i : intervals) {
			if (i.start < end) {
				return false;
			}
			end = i.end;
		}

		return true;
	}
}
