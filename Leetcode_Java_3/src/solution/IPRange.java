package solution;

import java.net.InetAddress;

/*
 * I want to be able to return true/false depending on an IP being in range of two other IPs.

For instance:

ip 192.200.3.0

range from 192.200.0.0

range to 192.255.0.0

should result to true.

Other examples:

assert 192.200.1.0 == true
assert 192.199.1.1 == false
assert 197.200.1.0 == false
 */
public class IPRange {
	public static long ipToLong(InetAddress ip) {
		byte[] address = ip.getAddress();
		long result = 0;
		for (byte octet : address) {
			result <<= 8;
			result |= octet & 0xff;
		}
		return result;
	}

	public static void inRange(InetAddress ip1, InetAddress ip2, InetAddress target) {
		long ipLo = ipToLong(ip1);
		long ipHi = ipToLong(ip2);
		long ipToTest = ipToLong(target);

		System.out.println(ipToTest >= ipLo && ipToTest <= ipHi);
	}
}
