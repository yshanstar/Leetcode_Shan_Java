package hack.leetcode.ulti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;

public class FileProcessorI {
	static HashMap<String, String> map = new HashMap<String, String>();
	static HashMap<String, String> map2 = new HashMap<String, String>();

	public static void readFile(String filePath) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			// read file line by line
			String line = null;
			Scanner scanner = null;
			int index = 0;
			while ((line = reader.readLine()) != null) {
				scanner = new Scanner(line);
				scanner.useDelimiter(",");
				String state = "";
				String full = "";
				while (scanner.hasNext()) {
					String data = scanner.next();
					if (index == 0) {
						state = data;
					} else if (index == 1) {
						full = data;
						map.put(state.toUpperCase(), full.toLowerCase().trim());
						map2.put(full.toLowerCase().trim(), state.toUpperCase());
					}
					index++;
				}
				index = 0;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void updateFile(String fileToRead, String outFiles) {
		try {

			File fout = new File(outFiles);
			FileOutputStream fos = new FileOutputStream(fout);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

			BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
			// read file line by line

			String line = null;
			Scanner scanner = null;
			int index = 0;
			while ((line = reader.readLine()) != null) {
				String[] lines = line.split("\t");
				scanner = new Scanner(line);
				scanner.useDelimiter("\t");
				while (scanner.hasNext()) {
					String data = scanner.next();
					if (index == 4) {
						String state = data;
						if (state != null && state.length() == 2) {
							if (map.containsKey(state.toUpperCase())) {
								lines[6] = "True";
							} else {
								lines[6] = "False";
							}
						} else if (state != null) {
							state = state.replaceAll("\"", "").trim().toLowerCase();
							if (map2.containsKey(state)) {
								lines[5] = "True";
							} else {
								lines[5] = "False";
							}
						}

						break;
					}
					index++;
				}
				index = 0;

				bw.write(toLines(lines));
				bw.newLine();
			}

			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String toLines(String[] array) {
		StringBuilder sb = new StringBuilder();
		for (String s : array) {
			sb.append(s).append("\t");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		readFile("C:\\Users\\shye\\OneDrive\\Project\\Leetcode\\Leetcode_Shan_Java\\Leetcode_Java\\Data\\ValidINState.csv");
		updateFile("C:\\Users\\shye\\OneDrive\\Project\\Leetcode\\Leetcode_Shan_Java\\Leetcode_Java\\Data\\INRGlobalTenantStateCode.txt", "INRGlobalTenantStateCodeUpdated.txt");
	}
}
