package hack.game;

import java.util.BitSet;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Elevator implements Runnable {

	private Direction direction = null;
	private Status status = Status.WAITING;
	private static int MIN_FLOOR;
	private static int INVALID_FLOOR;
	private int currentFloor;
	private int nextFloor;
	private final BitSet requests;

	/**
	 * Create with floor count. Floor starts from one. e.g 10 floors means
	 * 1..10.
	 * 
	 * @param floors
	 */
	public Elevator(int floors) {
		this.requests = new BitSet(floors);
		Elevator.MIN_FLOOR = 1;
		Elevator.INVALID_FLOOR = -1;
		this.currentFloor = 1;
		this.nextFloor = INVALID_FLOOR;
	}

	/**
	 * Receive floor request. Set next floor directly when stop, or try to
	 * insert next floor if current floor + 1 < request floor < original next
	 * floor.
	 * 
	 * @param floorNumber
	 *            floor number
	 */
	public void receiveRequest(int floorNumber) {
		requests.set(floorNumber);
		System.out.println(String.format("get floor request [%d]", floorNumber));
		if (nextFloor == INVALID_FLOOR) {
			setNextFloor(floorNumber);
		} else if ((currentFloor + 1 <= floorNumber) && floorNumber < nextFloor) {
			nextFloor = floorNumber;
		}
	}

	@Override
	public void run() {
		// return if not running, may be opening and closing door
		if (status != Status.RUNNING)
			return;
		// test if reach requested floor
		// if reached, open and close door, find next request floor
		canReachRequestFloor();
		// if no next floor found, don't move
		if (nextFloor == INVALID_FLOOR)
			return;
		// or simulate moving
		currentFloor += (direction == Direction.UP ? 1 : -1);
		// print status itself
		System.out.println(this);
	}

	private void setNextFloor(int floorNumber) {
		if (floorNumber == INVALID_FLOOR) {
			direction = null;
			nextFloor = INVALID_FLOOR;
			status = Status.WAITING;
		} else {
			direction = currentFloor < floorNumber ? Direction.UP : Direction.DOWN;
			nextFloor = floorNumber;
			status = Status.RUNNING;
		}
	}

	private void canReachRequestFloor() {
		if (currentFloor != nextFloor)
			return;
		System.out.println("reach floor " + currentFloor);
		openAndCloseDoor();
		requests.clear(currentFloor);
		setNextFloor(getNextRequestFloor());
	}

	private int getNextRequestFloor() {
		// when move upward, find upward then downward
		if (direction == Direction.UP) {
			int nextFloorUpward = findRequestFloorUpward(currentFloor + 1);
			if (nextFloorUpward != INVALID_FLOOR)
				return nextFloorUpward;
			return findRequestFloorDownward(currentFloor - 1);
		}
		// must be down
		// find downward then upward
		int nextFloorDownward = findRequestFloorDownward(currentFloor - 1);
		if (nextFloorDownward != INVALID_FLOOR)
			return nextFloorDownward;
		return findRequestFloorUpward(currentFloor + 1);
	}

	private int findRequestFloorUpward(int start) {
		for (int i = start; i < requests.size(); i++) {
			if (requests.get(i))
				return i;
		}
		return INVALID_FLOOR;
	}

	private int findRequestFloorDownward(int start) {
		for (int i = start; i >= MIN_FLOOR; i--) {
			if (requests.get(i))
				return i;
		}
		return INVALID_FLOOR;
	}

	private void openAndCloseDoor() {
		status = Status.OPEN;
		System.out.println("open door");
		status = Status.CLOSE;
		System.out.println("close door");
	}

	@Override
	public String toString() {
		return String.format("Elevator [direction=%s, status=%s, currentFloor=%s, nextFloor=%s, requests=%s]", direction, status, currentFloor, nextFloor, requests);
	}

	public static void main(String[] args) throws InterruptedException {
		int floors = 10;
		Elevator elevator = new Elevator(floors); // 1..10
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		executorService.scheduleAtFixedRate(elevator, 0, 1, TimeUnit.SECONDS);
		Random random = new Random();
		for (int i = 0; i < floors; i++) {
			elevator.receiveRequest(random.nextInt(floors - 1) + 1);
			Thread.sleep(1000L);
		}
	}

}

enum Direction {
	UP, DOWN;
}

enum Status {
	WAITING, RUNNING, OPEN, CLOSE;
}