package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import util.Interval;

/*
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return res;
		}

		if (intervals.size() == 1) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		int length = intervals.size();
		int i = 1;
		Interval newInterval = intervals.get(0);

		while (i < length) {
			Interval tmp = intervals.get(i);
			if (tmp.start > newInterval.end || tmp.end < newInterval.start) {
				res.add(newInterval);
				newInterval = tmp;
			} else {
				newInterval.start = Math.min(newInterval.start, tmp.start);
				newInterval.end = Math.max(newInterval.end, tmp.end);
			}
			i++;
		}

		res.add(newInterval);

		return res;
	}
}
