package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * You're given an array of CSV strings representing search results. Results are sorted by a score initially. A given host may have several listings that show up in these results. Suppose we want to show 12 results per page, but we don't want the same host to dominate the results. Write a function that will reorder the list so that a host shows up at most once on a page if possible, but otherwise preserves the ordering. Your program should return the new array and print out the results in blocks representing the pages.

[
// "host_id,listing_id,score,city",
"1,28,300.1,San Francisco",
"4,5,209.1,San Francisco",
"20,7,208.1,San Francisco",
"23,8,207.1,San Francisco",
"16,10,206.1,Oakland",
"1,16,205.1,San Francisco",
"1,31,204.6,San Francisco",
"6,29,204.1,San Francisco",
"7,20,203.1,San Francisco",
"8,21,202.1,San Francisco",
"2,18,201.1,San Francisco",
"2,30,200.1,San Francisco",
"15,27,109.1,Oakland",
"10,13,108.1,Oakland",
"11,26,107.1,Oakland",
"12,9,106.1,Oakland",
"13,1,105.1,Oakland",
"22,17,104.1,Oakland",
"1,2,103.1,Oakland",
"28,24,102.1,Oakland",
"18,14,11.1,San Jose",
"6,25,10.1,Oakland",
"19,15,9.1,San Jose",
"3,19,8.1,San Jose",
"3,11,7.1,Oakland",
"27,12,6.1,Oakland",
"1,3,5.1,Oakland",
"25,4,4.1,San Jose",
"5,6,3.1,San Jose",
"29,22,2.1,San Jose",
"30,23,1.1,San Jose"
]
 */
public class SearchResultReorder {
	public static void reOrder(String[] data, int pageSize) {
		if (data == null || data.length <= 1) {
			return;
		}
		List<String> dataList = new ArrayList<String>();
		for (int i = 1; i < data.length; i++) {
			dataList.add(data[i]);
		}

		Set<String> keys = new HashSet<String>();

		while (!dataList.isEmpty()) {
			List<String> copy = new ArrayList<String>(dataList);
			System.out.println("Page Start");
			for (int i = 0; i < pageSize && i < dataList.size(); i++) {
				String[] record = dataList.get(i).split(",");
				String hostId = record[0];
				if (!keys.contains(hostId)) {
					System.out.println(dataList.get(i));
					keys.add(hostId);
					copy.remove(dataList.get(i));
				}
			}
			System.out.println("Page End");
			dataList = copy;
			keys.clear();
		}
	}

	public static void main(String[] args) {
		String[] data = new String[] { "host_id,listing_id,score,city", "1,28,300.1,San Francisco",
				"4,5,209.1,San Francisco", "20,7,208.1,San Francisco", "23,8,207.1,San Francisco",
				"16,10,206.1,Oakland", "1,16,205.1,San Francisco", "1,31,204.6,San Francisco",
				"6,29,204.1,San Francisco", "7,20,203.1,San Francisco", "8,21,202.1,San Francisco",
				"2,18,201.1,San Francisco", "2,30,200.1,San Francisco", "15,27,109.1,Oakland", "10,13,108.1,Oakland",
				"11,26,107.1,Oakland", "12,9,106.1,Oakland", "13,1,105.1,Oakland", "22,17,104.1,Oakland",
				"1,2,103.1,Oakland", "28,24,102.1,Oakland", "18,14,11.1,San Jose", "6,25,10.1,Oakland",
				"19,15,9.1,San Jose", "3,19,8.1,San Jose", "3,11,7.1,Oakland", "27,12,6.1,Oakland", "1,3,5.1,Oakland",
				"25,4,4.1,San Jose", "5,6,3.1,San Jose", "29,22,2.1,San Jose", "30,23,1.1,San Jose" };

		reOrder(data, 12);
	}

}
