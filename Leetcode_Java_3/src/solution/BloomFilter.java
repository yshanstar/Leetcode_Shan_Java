package solution;

import java.util.BitSet;

/*
 http://www.cnblogs.com/heaad/archive/2011/01/02/1924195.htmlb  
 */
public class BloomFilter {
	private static final int DEFAULT_SIZE = 1 << 25; // BitSet size 2^24 bit;

	private static final int[] seeds = new int[] { 5, 7, 11, 13, 31, 37, 61 }; // The
																				// seed
																				// for
																				// hash
																				// function.
																				// usually
																				// pick
																				// prime
																				// number

	private BitSet bits = new BitSet(DEFAULT_SIZE);

	private SimpleHash[] func = new SimpleHash[seeds.length];

	public BloomFilter() {
		for (int i = 0; i < seeds.length; i++) {
			func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
		}
	}

	public void add(String str) {
		for (SimpleHash f : func) {
			bits.set(f.hash(str), true);
		}
	}

	public boolean contains(String value) {
		if (value == null) {
			return false;
		}
		boolean ret = true;
		for (SimpleHash f : func) {
			ret = ret && bits.get(f.hash(value));
		}
		return ret;
	}
}

class SimpleHash {
	private int cap;
	private int seed;

	public SimpleHash(int cap, int seed) {
		this.cap = cap;
		this.seed = seed;
	}

	public int hash(String value) {
		int result = 0;
		int len = value.length();
		for (int i = 0; i < len; i++) {
			result = seed * result + value.charAt(i);
		}
		return (cap - 1) & result;
	}
}
