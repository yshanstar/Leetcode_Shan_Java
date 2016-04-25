package solution;

import java.util.concurrent.TimeUnit;

/*
 * Often used to restrict the rate at which some physical or logical resource is accessed. 
 * This is in contrast to Semaphore which restricts the number of concurrent accesses instead of the rate 
 * (note though that concurrency and rate are closely related, e.g. see Little's Law).
 */
public class RateLimiter {
	private TokenBucket tokenBucket;

	public RateLimiter(int rate, int interval) {
		tokenBucket = new TokenBucket(rate, TimeUnit.SECONDS);
	}

	public boolean grant() {
		return tokenBucket.grand();
	}

	public static void main(String[] args) throws InterruptedException {
		RateLimiter rl = new RateLimiter(6, 1);

		Thread.sleep(1000L);
		for (int i = 0; i < 10; i++) {
			System.out.println(rl.grant());
		}
	}
}

class TokenBucket {
	private final int capacity;
	private final int tokensPerSeconds;
	private int tokens = 0;
	private long timestamp;

	public TokenBucket(int tokensPerUnit, TimeUnit unit) {
		capacity = tokensPerSeconds = (int) (tokensPerUnit / unit.toSeconds(1L));
		timestamp = System.currentTimeMillis();
	}

	public boolean grand() {
		try {
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long now = System.currentTimeMillis();
		System.out.println("now : " + now);
		System.out.println("timestamp : " + timestamp);
		System.out.println("Diff : " + (int) (now - timestamp));
		tokens += (int) ((now - timestamp) * tokensPerSeconds / 1000);
		System.out.print(tokens);
		if (tokens > capacity) {
			tokens = capacity;
		}
		timestamp = now;
		if (tokens < 1) {
			return false;
		}
		tokens--;
		return true;
	}
}
