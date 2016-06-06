package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].

 https://leetcode.com/discuss/24595/short-java-rolling-hash-solution
 */
public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {

		Set<String> checked = new HashSet<String>();
		Set<String> repeated = new HashSet<String>();

		for (int i = 0; i + 9 < s.length(); i++) {
			String ten = s.substring(i, i + 10);
			if (!checked.add(ten)) {
				repeated.add(ten);
			}
		}

		return new ArrayList<String>(repeated);

	}
}
