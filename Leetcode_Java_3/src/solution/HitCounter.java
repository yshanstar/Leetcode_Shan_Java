package solution;

/*
 * Design a hit counter which counts the number of hits received in the past 5 minutes.

 Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

 It is possible that several hits arrive roughly at the same time.

 Example:
 HitCounter counter = new HitCounter();

 // hit at timestamp 1.
 counter.hit(1);

 // hit at timestamp 2.
 counter.hit(2);

 // hit at timestamp 3.
 counter.hit(3);

 // get hits at timestamp 4, should return 3.
 counter.getHits(4);

 // hit at timestamp 300.
 counter.hit(300);

 // get hits at timestamp 300, should return 4.
 counter.getHits(300);

 // get hits at timestamp 301, should return 3.
 counter.getHits(301); 
 Follow up:
 What if the number of hits per second could be very large? Does your design scale?
 */
public class HitCounter {

	private int[] count;
	private int lastTime;
	private int SIZE;
	private int lastPos;
	private int SUM;

	/** Initialize your data structure here. */
	public HitCounter() {
		this.SIZE = 300;
		this.count = new int[this.SIZE];
		this.SUM = 0;
		this.lastPos = 0;
		this.lastTime = 0;
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		move(timestamp);
		count[this.lastPos]++;
		this.SUM++;
	}

	private void move(int timestamp) {
		int currentTime = timestamp;
		int gap = Math.min(SIZE, (int) (currentTime - this.lastTime));

		for (int i = 0; i < gap; i++) {
			this.lastPos = (this.lastPos + 1) % SIZE;
			this.SUM -= count[this.lastPos];
			count[this.lastPos] = 0;
		}

		this.lastTime = timestamp;
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		move(timestamp);
		return this.SUM;
	}

	public static void main(String[] args) {
		HitCounter hc = new HitCounter();
		hc.hit(1);
		hc.hit(2);
		hc.hit(3);
		hc.getHits(4);
		hc.hit(300);
		hc.getHits(300);
		hc.getHits(301);
	}
}
