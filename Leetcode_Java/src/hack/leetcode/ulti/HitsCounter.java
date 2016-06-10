package hack.leetcode.ulti;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HitsCounter {
	private int[] buckets;
	private long lastTime;
	private int SIZE;
	private int SUM;
	private int lastPos;

	public HitsCounter(int x) {
		this.SIZE = x;
		this.buckets = new int[SIZE];
		this.SUM = 0;
		this.lastPos = 0;

		this.lastTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
	}

	public void hit() {
		move();
		buckets[this.lastPos]++;
		this.SUM++;

	}

	public int getCount() {
		move();
		return this.SUM;
	}

	private void move() {
		long currentTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		int gap = Math.min(SIZE, (int) (currentTime - this.lastTime));
		for (int i = 0; i < gap; i++) {
			this.lastPos = (this.lastPos + 1) % SIZE;
			this.SUM -= buckets[i];
			buckets[i] = 0;
		}
		this.lastTime = currentTime;
	}

	public static void main(String[] args) {
		HitsCounter hitCounter = new HitsCounter(10);
		Random rn = new Random();
		int count = 0;
		while (count < 40) {
			hitCounter.hit();
			System.out.println(count + " : " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
			System.out.println(hitCounter.getCount());
			count++;
			try {
				Thread.sleep(rn.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
