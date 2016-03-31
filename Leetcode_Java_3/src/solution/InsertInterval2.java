package solution;

import java.util.ArrayList;
import java.util.List;

import util.Interval;

/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval2 {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (newInterval == null) {
			return intervals;
		}

		List<Interval> res = new ArrayList<Interval>();
		int length = intervals.size();
		int i = 0;

		while (i < length) {
			Interval tmp = intervals.get(i);
			if (tmp.end < newInterval.start) {
				res.add(tmp);
			} else if (tmp.start > newInterval.end) {
				break;
			} else {
				newInterval.start = Math.min(newInterval.start, tmp.start);
				newInterval.end = Math.max(newInterval.end, tmp.end);
			}
			i++;
		}

		res.add(newInterval);

		while (i < length) {
			res.add(intervals.get(i++));
		}

		return res;
	}
}
