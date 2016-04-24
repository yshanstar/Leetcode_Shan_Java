package solution;

import java.util.Arrays;

/*
 * Consider a big party where a log register for guest’s entry and exit times is maintained. Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.

Example:

Input: arrl[] = {1, 2, 9, 5, 5}
       exit[] = {4, 5, 12, 9, 12}
First guest in array arrives at 1 and leaves at 4, 
second guest arrives at 2 and leaves at 5, and so on.

Output: 5
There are maximum 3 guests at time 5.  
 */
public class MostOverlapInterval {
	public int findMaxOverlapIntervals(int[] arrivals, int[] exits) {
		if (arrivals == null || arrivals.length == 0 || exits == null || exits.length == 0) {
			return 0;
		}

		int maxCustomer = 0;
		int numOfCustomer = 0;
		int i = 0;
		int j = 0;

		Arrays.sort(arrivals);
		Arrays.sort(exits);

		while (i < arrivals.length && j < exits.length) {
			if (arrivals[i] < exits[j]) {
				numOfCustomer++;

				if (numOfCustomer > maxCustomer) {
					maxCustomer = numOfCustomer;
				}
				i++;
			} else {
				numOfCustomer--;
				j++;
			}
		}

		return maxCustomer;
	}
}
