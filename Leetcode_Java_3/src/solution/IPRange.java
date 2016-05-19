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
	public static long ipToLong(String ip) {
		String[] address = ip.split("\\.");
		long result = 0;
		for (String octet : address) {
			result <<= 8;
			result |= Integer.parseInt(octet) & 0xff;
		}
		return result;
	}

	public static long ipToLong2(String ip) {
		String[] address = ip.split("\\.");
		long result = 0;
		for (int i = 0; i < address.length; i++) {
			result += Integer.parseInt(address[i]) * Math.pow(256, (3 - i));
		}
		return result;
	}

	public static void inRange(String ip1, String ip2, String target) {
		long ipLo = ipToLong(ip1);
		long ipHi = ipToLong(ip2);
		long ipToTest = ipToLong(target);

		System.out.println(ipToTest >= ipLo && ipToTest <= ipHi);
	}

	public static void main(String[] args) {
		String ip = "131.107.159.46";
		System.out.println(ipToLong(ip));
		System.out.println(ipToLong2(ip));
	}
}
