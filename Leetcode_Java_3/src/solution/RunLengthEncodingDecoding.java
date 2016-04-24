package solution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Run-length encoding (RLE) is a very simple form of lossless data compression in which runs of data (that is, sequences in which the same data value occurs in many consecutive data elements) are stored as a single data value and count, rather than as the original run. This is most useful on data that contains many such runs. Consider, for example, simple graphic images such as icons, line drawings, and animations. It is not useful with files that don't have many runs as it could greatly increase the file size.

RLE may also be used to refer to an early graphics file format supported by CompuServe for compressing black and white images, but was widely supplanted by their later Graphics Interchange Format. RLE also refers to a little-used image format in Windows 3.x, with the extension rle, which is a Run Length Encoded Bitmap, used to compress the Windows 3.x startup screen.

Typical applications of this encoding are when the source information comprises long substrings of the same character or binary digit.
 */
public class RunLengthEncodingDecoding {
	public static String encoding(String src) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < src.length(); i++) {
			int runLength = 1;
			while (i + 1 < src.length() && src.charAt(i) == src.charAt(i + 1)) {
				runLength++;
				i++;
			}

			sb.append(runLength);
			sb.append(src.charAt(i));
		}

		return sb.toString();
	}

	public static String decoding(String str) {
		StringBuilder sb = new StringBuilder();
		Pattern p = Pattern.compile("[0-9]+|[a-zA-Z]");
		Matcher matcher = p.matcher(str);
		while (matcher.find()) {
			int number = Integer.parseInt(matcher.group());
			matcher.find();
			while (number-- != 0) {
				sb.append(matcher.group());
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String example = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW";
		String encription = encoding(example);
		System.out.println(encription);
		System.out.println(decoding(encription));
	}
}
