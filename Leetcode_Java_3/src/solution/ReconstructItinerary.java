package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

 Note:
 If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 All airports are represented by three capital letters (IATA code).
 You may assume all tickets form at least one valid itinerary.
 Example 1:
 tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 Example 2:
 tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
		List<String> res = new ArrayList<String>();
		if (tickets == null || tickets.length == 0 || tickets[0].length == 0) {
			return res;
		}

		Map<String, PriorityQueue<String>> ticketMap = new HashMap<String, PriorityQueue<String>>();

		for (String[] ticket : tickets) {
			String start = ticket[0];
			String end = ticket[1];

			if (ticketMap.containsKey(start)) {
				ticketMap.get(start).offer(end);
			} else {
				PriorityQueue<String> toQueue = new PriorityQueue<String>();
				toQueue.offer(end);
				ticketMap.put(start, toQueue);
			}
		}

		int loc = 0;
		String start = "JFK";
		while (res.size() <= tickets.length) {
			if (loc == 0 || !start.equals(res.get(loc - 1))) {
				res.add(loc++, start);
			}

			PriorityQueue<String> endQueue = ticketMap.get(start);
			if (endQueue == null || endQueue.size() == 0) {
				start = res.get(loc - 2);
				loc--;
			} else {
				start = endQueue.poll();
			}
		}

		return res;
	}

	public static void main(String[] args) {
		ReconstructItinerary test = new ReconstructItinerary();
		test.findItinerary(new String[][] { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } });
	}
}
