package hack.game;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BattleShip {
	public static void main(String[] args) {
		int[][] board = new int[5][5];
		Ship[] ships = new Ship[3];
		Shot shoot = new Shot(-1, -1);

		int attempts = 0;
		int shotHits = 0;

		initBoard(board);
		initShip(ships, board.length);

		do {
			showBoard(board);
			shoot(shoot);
			attempts++;

			if (hit(shoot, ships)) {
				hint(shoot, ships, attempts);
				shotHits++;
			} else {
				hint(shoot, ships, attempts);
			}
			changeboard(shoot, ships, board);

		} while (shotHits != 3);

		showBoard(board);
	}

	private static void initBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], -1);
		}
	}

	private static void initShip(Ship[] ships, int bound) {
		Random random = new Random();
		for (int i = 0; i < ships.length; i++) {
			Ship ship = new Ship(random.nextInt(bound), random.nextInt(bound));
			ships[i] = ship;
			for (int j = 0; j < i; j++) {
				Ship ith = ships[j];
				if (ship.equals(ith)) {
					do {
						ship.x = random.nextInt(bound);
						ship.y = random.nextInt(bound);
					} while (ship.equals(ith));
				}
			}
		}
	}

	private static void showBoard(int[][] board) {
		System.out.println("\t1 \t2 \t3 \t4 \t5");
		System.out.println();

		for (int row = 0; row < board.length; row++) {
			System.out.print((row + 1) + "");
			for (int column = 0; column < board[row].length; column++) {
				if (board[row][column] == -1) {
					System.out.print("\t" + "~");
				} else if (board[row][column] == 0) {
					System.out.print("\t" + "*");
				} else if (board[row][column] == 1) {
					System.out.print("\t" + "X");
				}

			}
			System.out.println();
		}
	}

	public static void hint(Shot shoot, Ship[] ships, int attempt) {
		int row = 0, column = 0;

		for (int line = 0; line < ships.length; line++) {
			if (ships[line].x == shoot.x)
				row++;
			if (ships[line].y == shoot.y)
				column++;
		}

		System.out.printf("\nHint %d: \nRow %d -> %d ships\n" + "Column %d -> %d ships\n", attempt, shoot.x + 1, row,
				shoot.y + 1, column);
	}

	public static void shoot(Shot shoot) {
		Scanner input = new Scanner(System.in);

		System.out.print("Row: ");
		shoot.x = input.nextInt();
		shoot.x--;

		System.out.print("Column: ");
		shoot.y = input.nextInt();
		shoot.y--;
	}

	public static boolean hit(Shot shoot, Ship[] ships) {

		for (Ship ship : ships) {
			if (shoot.x == ship.x && shoot.y == ship.y) {
				System.out.printf("You hit a ship located in (%d,%d)\n", shoot.x + 1, shoot.y + 1);
				return true;
			}
		}
		return false;
	}

	public static void changeboard(Shot shoot, Ship[] ships, int[][] board) {
		if (hit(shoot, ships))
			board[shoot.x][shoot.y] = 1;
		else
			board[shoot.x][shoot.y] = 0;
	}

}

abstract class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Ship extends Point {
	public Ship(int x, int y) {
		super(x, y);
	}

	public boolean equals(Ship x) {
		return this.x == x.x && this.y == x.y;
	}
}

class Shot extends Point {
	public Shot(int x, int y) {
		super(x, y);
	}
}
