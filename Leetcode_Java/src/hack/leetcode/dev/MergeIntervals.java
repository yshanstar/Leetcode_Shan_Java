package hack.leetcode.dev;

import hack.leetcode.ulti.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 	Given a collection of intervals, merge all overlapping intervals.
 *	For example,
 *	Given [1,3],[2,6],[8,10],[15,18],
 *	return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals.size() <= 1) {
			return intervals;
		}
		ArrayList<Interval> res = new ArrayList<Interval>();

		Collections.sort(intervals, START_COMPAR);
		int lenght = intervals.size();
		int i = 1;
		Interval newInterval = intervals.get(0);

		while (i < lenght) {
			Interval tmp = intervals.get(i);

			if (tmp.end < newInterval.start || tmp.start > newInterval.end) {
				res.add(newInterval);
				newInterval = tmp;
			} else {
				newInterval.start = Math.min(tmp.start, newInterval.start);
				newInterval.end = Math.max(tmp.end, newInterval.end);
			}
			i++;
		}
		res.add(newInterval);
		return res;
	}

	static final Comparator<Interval> START_COMPAR = new Comparator<Interval>() {

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return new Integer(o1.start).compareTo(new Integer(o2.start));
		}
	};
}
