package solution;


public class ReverseWordsinaString {
	public String reverseWords2(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String[] sChar = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = sChar.length - 1; i >= 0; i--) {
			if (!sChar[i].equals("")) {
				sb.append(sChar[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}

	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		s = s.trim();
		char[] strArray = s.toCharArray();

		reverse(strArray, 0, strArray.length - 1);

		int start = -1;
		int end = -1;
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i] != ' ') {
				if (start == -1) {
					start = i;
					end = start;
				} else {
					end++;
				}
			} else {
				if (start != -1 && end != -1) {
					reverse(strArray, start, end);
					start = -1;
					end = -1;
				}
			}
		}

		return new String(strArray);
	}
	
	public String reverseWords3(String s) {
		StringBuilder res = new StringBuilder();
		for (int start = s.length() - 1; start >= 0; start--) {
			if (s.charAt(start) == ' ')
				continue;
			int end = start;
			while (start >= 0 && s.charAt(start) != ' ')
				start--;
			res.append(s.substring(start + 1, end + 1)).append(" ");
		}
		return res.toString().trim();
	}

	private void reverse(char[] array, int left, int right) {
		while (left < right) {
			char tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args){
	}
}
