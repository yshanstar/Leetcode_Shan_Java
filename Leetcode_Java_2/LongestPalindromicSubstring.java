public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty()){
        	return null;
        }

        if(s.length() == 1){
        	return s;
        }

        String res = s.substring(0,1);

        for(int i=0; i<s.length(); i++){
        	String tmp = helper(s, i ,i);
        	if(res.length() < tmp.length()){
        		res = tmp;
        	}

        	tmp = helper(s, i, i+1);
        	if(res.length() < tmp.length()){
        		res = tmp;
        	}
        }

        return res;
    }

    private String helper(String s, int start, int end){
    	while(start >= 0 && end <= s.length() -1 && s.charAt(start) == s.charAt(end) ){
    		start--;
    		end++;
    	}

    	return s.substring(start+1, end);
    }
}