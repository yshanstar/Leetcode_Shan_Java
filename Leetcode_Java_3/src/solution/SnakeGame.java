package solution;

import java.util.Deque;
import java.util.LinkedList;

import javax.print.attribute.standard.MediaSize.NA;

/*
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:
Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */

/**
 * Your SnakeGame object will be instantiated and called as such: SnakeGame obj
 * = new SnakeGame(width, height, food); int param_1 = obj.move(direction);
 */
public class SnakeGame {

	Deque<Integer> snakeBody;
	int width;
	int height;
	int[][] food;
	int count = 0;
	boolean isGameOver = false;

	/**
	 * Initialize your data structure here.
	 * 
	 * @param width
	 *            - screen width
	 * @param height
	 *            - screen height
	 * @param food
	 *            - A list of food positions E.g food = [[1,1], [1,0]] means the
	 *            first food is positioned at [1,1], the second is at [1,0].
	 */
	public SnakeGame(int width, int height, int[][] food) {
		this.food = food;
		this.width = width;
		this.height = height;
		this.snakeBody = new LinkedList<Integer>();

		this.snakeBody.add(0);
	}

	/**
	 * Moves the snake.
	 * 
	 * @param direction
	 *            - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
	 * @return The game's score after the move. Return -1 if game over. Game
	 *         over when snake crosses the screen boundary or bites its body.
	 */
	public int move(String direction) {
		if (isGameOver) {
			return -1;
		}

		int curPos = this.snakeBody.getFirst();
		int tailPos = this.snakeBody.removeLast();

		int[] head = new int[2];
		head[0] = curPos / width;
		head[1] = curPos % width;

		switch (direction) {
		case "U":
			head[0]--;
			break;

		case "D":
			head[0]++;
			break;

		case "L":
			head[1]--;
			break;

		case "R":
			head[1]++;
			break;

		default:
			break;
		}

		if (head[0] < 0 || head[1] < 0 || head[0] >= height || head[1] >= width
				|| this.snakeBody.contains(valueOf(head))) {
			isGameOver = true;
			return -1;
		}

		this.snakeBody.addFirst(valueOf(head));

		if (count < food.length && food[count][0] == head[0] && food[count][1] == head[1]) {
			snakeBody.addLast(tailPos);
			count++;
		}

		return snakeBody.size() - 1;
	}

	private int valueOf(int[] head) {
		return head[0] * width + head[1];
	}
}
