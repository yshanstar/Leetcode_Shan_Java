package hack.leetcode.dev;

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
 You may assume all tickets may form at least one valid itinerary.
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

		Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
		for (String[] ticket : tickets) {
			String from = ticket[0];
			String to = ticket[1];

			if (map.containsKey(from)) {
				map.get(from).add(to);
			} else {
				PriorityQueue<String> queue = new PriorityQueue<String>();
				queue.add(to);
				map.put(from, queue);
			}
		}

		String start = "JFK";
		int loc = 0; // To track where of the arraylist to insert into
		while (res.size() <= tickets.length) {
			if (loc == 0 || start.equals(res.get(loc - 1)) == false) {
				res.add(loc, start);
				loc++;
			}

			PriorityQueue<String> destinationsQueue = map.get(start);

			if (destinationsQueue == null || destinationsQueue.size() == 0) {
				start = res.get(loc - 2);
				loc--;
			} else {
				start = destinationsQueue.poll();
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String[][] tickets = new String[][] { { "JFK", "KUL" },
				{ "JFK", "NRT" }, { "NRT", "JFK" } };

		ReconstructItinerary test = new ReconstructItinerary();

		test.findItinerary(tickets);
	}
}
