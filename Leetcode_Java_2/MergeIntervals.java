/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
*/
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> res = new ArrayList<Interval>();	        
		if(intervals == null || intervals.size() <= 1 ){
			return intervals;
		}

		Collections.sort(intervals, STARTCOMPAR);
		Interval inter = intervals.get(0);

		int n = intervals.size();
		int i = 1;

		while(i<n){
			Interval tmp = intervals.get(i);
			if(tmp.end < inter.start || tmp.start > inter.end){
				res.add(inter);
				inter = tmp;
			}else{
				inter.start = Math.min(inter.start, tmp.start);
				inter.end = Math.max(inter.end, tmp.end);
			}
			i++;
		}

		res.add(inter);
		return res;

    }

    static final Comparator<Interval> STARTCOMPAR = new Comparator<Interval>(){
    	public int compare(Interval o1, Interval o2){
    		return o1.start - o2.start;
    	}
    };
}