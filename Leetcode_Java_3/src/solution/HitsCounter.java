package solution;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
 * Write a counter for hits received in the past 15 minutes.
 */
public class HitsCounter {
	private int SIZE;
	private int SUM;
	private int lastPos;
	private int[] count;
	private long lastTime;

	public HitsCounter(int x) {
		this.SIZE = x;
		this.SUM = 0;
		this.lastPos = 0;
		this.count = new int[SIZE];
		this.lastTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
	}

	private void move() {
		long currentTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		int gap = Math.min((int) (currentTime - this.lastTime), SIZE);
		for (int i = 0; i < gap; i++) {
			this.lastPos = (this.lastPos + 1) % SIZE;
			this.SUM -= count[this.lastPos];
			count[this.lastPos] = 0;
		}
		this.lastTime = currentTime;
	}

	public void hit() {
		move();
		this.count[this.lastPos]++;
		this.SUM++;
	}

	public int getCount() {
		move();
		return this.SUM;
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
