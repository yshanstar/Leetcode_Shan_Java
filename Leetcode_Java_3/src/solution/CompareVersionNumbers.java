package solution;

/*
 * Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		if (version1 == null && version2 == null) {
			return 0;
		}

		if (version1.equals(version2)) {
			return 0;
		}

		int fVersion1 = 0;
		int fVersion2 = 0;
		String subVersion1 = "";
		String subVersion2 = "";

		if (version1.contains(".")) {
			int pos = version1.indexOf(".");
			fVersion1 = Integer.parseInt(version1.substring(0, pos));
			subVersion1 = version1.substring(pos + 1);
		}else{
			fVersion1 = Integer.parseInt(version1);
			subVersion1 = "0";
		}
		
		if (version2.contains(".")) {
			int pos = version2.indexOf(".");
			fVersion2 = Integer.parseInt(version2.substring(0, pos));
			subVersion2 = version2.substring(pos + 1);
		}else{
			fVersion2 = Integer.parseInt(version2);
			subVersion2 = "0";
		}
		
		if(fVersion1 > fVersion2){
			return 1;
		}
		
		if(fVersion1 < fVersion2){
			return -1;
		}
		
		return compareVersion(subVersion1, subVersion2);
}

	public static void main(String[] args) {
		CompareVersionNumbers test = new CompareVersionNumbers();
		test.compareVersion("1", "0");
	}
}
