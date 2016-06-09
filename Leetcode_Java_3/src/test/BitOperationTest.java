package test;

import java.util.BitSet;

public class BitOperationTest {
	public static void main(String[] args) {
		TestBitSet();
	}

	public static void TestBitSet() {
		BitSet set = new BitSet(1000);
		for (int i = 0; i < 1000; i++) {
			set.set(i);
		}
		System.out.println(set.cardinality());
		System.out.println(set);
		
		for (int i = 0; i < 1000; i++) {
			if (i % 5 != 0) {
				set.set(i, false);
			}
		}
		System.out.println(set);
		System.out.println(set.cardinality());
	}

	public static long convertIPtoLong(String Ip) {
		if (Ip == null || Ip.isEmpty()) {
			return 0;
		}

		String[] segment = Ip.split("\\.");
		long value = 0;
		for (int i = 0; i < segment.length; i++) {
			value = value << 8;
			value |= Integer.parseInt(segment[i]);
		}

		return value;
	}

	public static long ipToLong(String ip) {
		String[] address = ip.split("\\.");
		long result = 0;
		for (String octet : address) {
			result <<= 8;
			result |= Integer.parseInt(octet) & 0xff;
		}
		return result;
	}
}
