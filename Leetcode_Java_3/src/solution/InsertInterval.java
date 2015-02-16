package solution;

import java.util.ArrayList;
import java.util.List;

import util.Interval;

public class InsertInterval {
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
				newInterval.start = Math.min(tmp.start, newInterval.start);
				newInterval.end = Math.max(tmp.end, newInterval.end);
			}
			i++;
		}
		res.add(newInterval);
		
		while (i < length) {
			res.add(intervals.get(i));
			i++;
		}

		return res;
	}

}
