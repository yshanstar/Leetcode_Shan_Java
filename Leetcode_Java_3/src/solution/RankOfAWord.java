package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Find the rank of the given word when it is arranged alphabetically

 Rank of the string bacd is 7 alphabetical arrangement of word is 
 abcd
 abdc
 acbd
 acdb
 adbc
 adcb
 bacd

 hence rank of the given string "bacd" is 7

 Find sam to find the rank of the given string

 http://www.cnblogs.com/theskulls/p/4881142.html
 */
public class RankOfAWord {

	public long findRankII(String str) {
		long rank = 1;
		long factor = 1;
		Map<Character, Integer> charCounts = new HashMap<Character, Integer>();

		for (int i = str.length() - 1; i >= 0; i--) {
			char x = str.charAt(i);

			int xCount = charCounts.containsKey(x) ? charCounts.get(x) + 1 : 1;
			charCounts.put(x, xCount);

			for (Entry<Character, Integer> e : charCounts.entrySet()) {
				if (e.getKey() < x) {
					rank += factor * e.getValue() / xCount;
				}
			}
			factor *= str.length() - i;
			factor /= xCount;
		}
		return rank;
	}

	public long findRankI(String str) {
		long rank = 1;
		long factor = 1;

		Set<Character> charSet = new HashSet<Character>();

		for (int i = str.length() - 1; i >= 0; i--) {
			char c = str.charAt(i);
			charSet.add(c);
			for (Character character : charSet) {
				if (character < c) {
					rank += factor;
				}
			}
			factor *= str.length() - i;
		}

		return rank;
	}

	public static void main(String[] args) {
		RankOfAWord rank = new RankOfAWord();
		String str = "badc";
		System.out.println(rank.findRankII(str));
		System.out.println(rank.findRankI(str));
	}
}
