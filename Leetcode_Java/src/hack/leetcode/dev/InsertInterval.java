package hack.leetcode.dev;

import hack.leetcode.ulti.Interval;

import java.util.ArrayList;

/*
 *	Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *	You may assume that the intervals were initially sorted according to their start times.
 *	Example 1:
 *	Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 	Example 2:
 * 	Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 	This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
 */
public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<Interval>();

		int lenght = intervals.size();
		int i = 0;
		while (i < lenght) {
			Interval tmp = intervals.get(i);
			if (tmp.end < newInterval.start) {
				res.add(tmp);
			} else if (tmp.start > newInterval.end) {
				break;
			} else {
				newInterval.start = Math.min(tmp.start, newInterval.start);
				newInterval.end = Math.max(tmp.end, newInterval.end);
			}
			i++;
		}
		res.add(newInterval);

		while (i < lenght) {
			res.add(intervals.get(i));
			i++;
		}

		return res;
	}
}
