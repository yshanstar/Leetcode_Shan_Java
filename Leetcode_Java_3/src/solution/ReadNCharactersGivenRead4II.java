package solution;

/*
 * The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.

Show Company Tags
Show Tags
Show Similar Problems

 */
public class ReadNCharactersGivenRead4II {

	private char[] readed = new char[4];
	private int readLoc = 0;
	private int writeLoc = 0;

	public int read(char[] buf, int n) {
		for (int i = 0; i < n; i++) {
			if (readLoc == writeLoc) {
				writeLoc = read4(readed);
				readLoc = 0;
				if (writeLoc == 0)
					return i;
			}
			buf[i] = readed[readLoc];
			readLoc++;
		}
		return n;
	}

	int read4(char[] buf) {
		return Integer.MIN_VALUE;
	}
}
