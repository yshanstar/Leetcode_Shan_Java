package hack.leetcode.dev;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*
 * Given a stream of numbers, print average (or mean) of the stream at every point. For example, let us consider the stream as 10, 20, 30, 40, 50, 60, бн

  Average of 1 numbers is 10.00
  Average of 2 numbers is 15.00
  Average of 3 numbers is 20.00
  Average of 4 numbers is 25.00
  Average of 5 numbers is 30.00
  Average of 6 numbers is 35.00
 */
public class AverageOfStreamOfNumbers {
	static InputStream is = null;
	static DataInputStream dis = null;

	private static float getAvg(float tmpAvg, int newNumber, int n) {
		return (tmpAvg * n + newNumber) / (n + 1);
	}

	public static void calculateAvg() {
		// create file input stream
		try {
			is = new FileInputStream("Data/AverageOfStreamOfNumber.txt");
			// create new data input stream
			dis = new DataInputStream(is);
			int count = 0;
			float avg = 0;
			while (dis.available() > 0) {
				// read four bytes from data input, return int
				int k = Integer.parseInt(dis.readLine());
				System.out.println("Data is: " + k);
				avg = getAvg(avg, k, count);
				count++;
				// print int
				System.out.println("Avg is: " + avg);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		calculateAvg();
	}
}
