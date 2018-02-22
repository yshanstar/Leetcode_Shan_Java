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
import java.util.HashSet;
import java.util.Scanner;

public class FileProcessorII {
	static HashMap<String, String> map = new HashMap<String, String>();
	static HashMap<String, String> map2 = new HashMap<String, String>();
	static HashSet<String> set = new HashSet<String>();
	
	public static boolean checkFile(String filePath) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			// read file line by line
			String line = null;
			Scanner scanner = null;
			int index = 0;
			while ((line = reader.readLine()) != null) {
				if (index == 0) {
					index++;
					continue;
				}
				String[] lines = line.split("\t");

				String ctpOfferId = lines[2].toLowerCase();
				String targetOfferId = lines[3].toLowerCase();
				
				if(!map.containsKey(ctpOfferId) || !map.get(ctpOfferId).equals(targetOfferId)){
					System.out.println(ctpOfferId + " : " + targetOfferId);
					return false;
				}
				index++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static void getOfferMapping(String filePath) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			// read file line by line
			String line = null;
			int index = 0;
			while ((line = reader.readLine()) != null) {
				if (index == 0) {
					index++;
					continue;
				}
				String[] lines = line.split(",");
				if (lines.length != 4) {
					System.out.println("Data is incorrect");
				}

				String oldCtpOffer = lines[3].toLowerCase();
				String newCtpOffer = lines[1].toLowerCase();
				map.put(oldCtpOffer, newCtpOffer);
				map2.put(newCtpOffer, oldCtpOffer);
				index++;
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
			int index = 0;
			while ((line = reader.readLine()) != null) {
				String[] lines = line.split(",");
				if(index == 0){
					bw.write(toLines(lines));
					bw.newLine();
					index++;
					continue;
				}
				
				String ctpOfferId = lines[2].toLowerCase();
				String newCtpOfferId = map.get(ctpOfferId);
				if(newCtpOfferId != null){
					lines[3] = newCtpOfferId.toLowerCase();
				}
				if(map2.containsKey(ctpOfferId)){
					lines[3] = "new offer already";
				}
				bw.write(toLines(lines));
				bw.newLine();
				index++;
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
	
	public static void check(String file1, String file2){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file1));
			// read file line by line
			String line = null;
			while ((line = reader.readLine()) != null) {
				set.add(line.toLowerCase());
			}
			
			reader = new BufferedReader(new FileReader(file2));
			line = null;
			File fout = new File("outcome.txt");
			FileOutputStream fos = new FileOutputStream(fout);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

			while ((line = reader.readLine()) != null) {
				if(!set.contains(line.toLowerCase())){
					bw.write(line.toLowerCase());
					bw.newLine();
				}
			}
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	public static void main(String[] args) {
//		check("C:\\Users\\shye\\OneDrive\\Project\\Leetcode\\Leetcode_Shan_Java\\Leetcode_Java\\Data\\1", "C:\\Users\\shye\\OneDrive\\Project\\Leetcode\\Leetcode_Shan_Java\\Leetcode_Java\\Data\\2");
		
		getOfferMapping("C:\\Users\\shye\\OneDrive\\Project\\Leetcode\\Leetcode_Shan_Java\\Leetcode_Java\\Data\\QualIssueFixMap.csv");
//		System.out.println(checkFile("C:\\Users\\shye\\OneDrive\\Project\\Leetcode\\Leetcode_Shan_Java\\Leetcode_Java\\Data\\CTPSubConversionFinal.txt"));
		updateFile("C:\\Users\\shye\\OneDrive\\Project\\Leetcode\\Leetcode_Shan_Java\\Leetcode_Java\\Data\\aa.csv", 
				"C:\\Users\\shye\\OneDrive\\Project\\Leetcode\\Leetcode_Shan_Java\\Leetcode_Java\\Data\\OfferConversion.txt");
	}
}
