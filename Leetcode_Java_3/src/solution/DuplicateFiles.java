package solution;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/*
 * Find all Duplicate files under the folder and subFolders
 */
public class DuplicateFiles {
	public Map<String, List<String>> findDuplicateFiles(String path) throws NoSuchAlgorithmException {
		Map<String, List<String>> res = new HashMap<String, List<String>>();
		if (path == null || path.length() == 0) {
			return res;
		}

		File f = new File(path);
		if (f.isFile()) {
			return res;
		}

		Stack<File> allFiles = new Stack<File>();
		getFiles(f, allFiles);

		Map<Long, Map<String, List<String>>> maps = new HashMap<Long, Map<String, List<String>>>();
		while (!allFiles.isEmpty()) {
			File tmp = allFiles.pop();
			long key = tmp.length();

			if (!maps.containsKey(key)) {
				maps.put(key, new HashMap<String, List<String>>());
			}

			Map<String, List<String>> sizeMap = maps.get(key);

			String md5 = GetMd5ForFile(tmp);
			System.out.println(md5 + ": " + tmp.getName());
			if (!sizeMap.containsKey(md5)) {
				sizeMap.put(md5, new ArrayList<String>());
			}
			sizeMap.get(md5).add(tmp.getAbsolutePath());
		}

		for (Entry<Long, Map<String, List<String>>> entry : maps.entrySet()) {
			Map<String, List<String>> value = entry.getValue();
			for (Entry<String, List<String>> e : value.entrySet()) {
				if (e.getValue().size() > 1) {
					res.put(e.getKey(), e.getValue());
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		DuplicateFiles test = new DuplicateFiles();
		String path = "test";
		try {
			printDuplicateFiles(test.findDuplicateFiles(path));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static void printDuplicateFiles(Map<String, List<String>> fileMap) {
		for (Entry<String, List<String>> e : fileMap.entrySet()) {
			String listString = "";
			for (String s : e.getValue()) {
				listString += s + "\t";
			}
			System.out.println(listString);
		}
	}

	private static String GetMd5ForFile(File file) {

		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());

			byte[] dataBytes = new byte[1024];

			int nread = 0;
			while ((nread = fis.read(dataBytes)) != -1) {
				md.update(dataBytes, 0, nread);
			}
			byte[] mdbytes = md.digest();

			// convert the byte to hex format
			for (int i = 0; i < mdbytes.length; i++) {
				sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (Exception e) {
			System.out.println("Error");
		}

		return sb.toString();
	}

	private void getFiles(File f, Stack<File> allFiles) {
		if (f.isFile()) {
			allFiles.push(f);
			return;
		} else {
			for (File file : f.listFiles()) {
				if (file.isFile()) {
					allFiles.push(file);
				} else {
					getFiles(file, allFiles);
				}
			}
		}
	}
}
