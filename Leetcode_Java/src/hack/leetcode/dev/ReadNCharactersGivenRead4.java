package hack.leetcode.dev;

/*
 * The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note:
 The read function will only be called once for each test case.
 */
public class ReadNCharactersGivenRead4 {
	public int read(char[] buf, int n) {
		char[] tmp = new char[4];
		int total = 0;
		boolean eof = false;

		while (!eof && total < n) {
			int count = read4(tmp);

			eof = count < 4;

			count = Math.min(count, n - total);

			for (int i = 0; i < count; i++) {
				buf[total++] = tmp[i];
			}
		}

		return total;
	}

	int read4(char[] buf) {
		return Integer.MIN_VALUE;
	}
}
