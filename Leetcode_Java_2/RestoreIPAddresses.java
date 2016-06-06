import java.lang.Long;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12){
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<String>();
        helper("", s, 0, res);
        return res;
    }

    private void helper(String curIP, String s, int idx, List<String> res) {
        if (idx == 3) {
            if (s.length() > 0) {
                if (String.valueOf(Long.parseLong(s)).equals(s) && Long.parseLong(s) <= 255) {
                    res.add(curIP + s);
                }
            }
            return;
        }

        for (int i = 1; i < 4; i++) {
            int length = s.length();
            if (length >= i
                && String.valueOf(Long.parseLong(s.substring(0, i))).equals(s.substring(0, i))
                && Long.parseLong(s.substring(0, i)) <= 255) {
                helper(curIP+s.substring(0, i)+".", s.substring(i), idx+1, res);
            }
        }
    }

    public static void main(String[] args){
        RestoreIPAddresses test = new RestoreIPAddresses();
        test.restoreIpAddresses("1111");
    }
}