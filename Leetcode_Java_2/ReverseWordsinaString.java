import java.lang.String;
import java.lang.StringBuffer;
import java.lang.StringBuilder;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }

        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        if (start > end) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            StringBuilder word = new StringBuilder();
            while (end >= start && s.charAt(end) != ' ') {
                word.append(s.charAt(end));
                end--;
            }
            word.reverse();
            if (!word.equals("")) {
                sb.append(word + " ");
            }

            while(end>=start && s.charAt(end) == ' '){
                end--;
            }
        }

        return sb.substring(0, sb.length()-1).toString();
    }
}