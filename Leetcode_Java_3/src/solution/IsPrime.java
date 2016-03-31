package solution;

import java.util.ArrayList;
import java.util.List;

/*
 * Check if the number is prime number or not
 */
public class IsPrime {
	public boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		// fast even test.
		if (n > 2 && (n & 1) == 0) {
			return false;
		}

		// only odd factors need to be tested up to n^0.5
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;

	}

	public static void main(String[] args) {
		IsPrime test = new IsPrime();
		int total = 3000;
		List<Integer> primes = test.getPrimes(total);

		for (int i = 0; i <= total; i++) {
			if (primes.contains(i)) {
				if (!test.isPrime(i)) {
					System.out.println(i + " is not prime");
				}
			} else {
				if (test.isPrime(i)) {
					System.out.println(i + " is prime");
				}
			}
		}
	}

	public List<Integer> getPrimes(int n) {
		List<Integer> res = new ArrayList<Integer>();

		if (n <= 1) {
			return res;
		}

		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++) {
			primes[i] = true;
		}

		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
			if (primes[i]) {
				for (int j = i * i; j < n; j += i) {
					primes[j] = false;
				}
			}
		}

		for (int i = 2; i < n; i++) {
			if (primes[i]) {
				res.add(i);
			}
		}

		return res;
	}
}
