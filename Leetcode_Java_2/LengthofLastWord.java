public class Solution {
    public int lengthOfLastWord(String s) {
    	int res = 0;
    	if(s == null || s.length() == 0){
    		return res;
    	}

    	int i = s.length() - 1;
    	while(i>=0 && s.charAt(i) == ' '){
    		i--;
    	}

    	if(i<0){
    		return res;
    	}

    	int j = i;
    	while(j>=0 && s.charAt(j) != ' '){
    		j--;
    	}

    	if(j<0){
    		res = i+1;
    	}else{
    		res = i-j;
    	}
    	return res;
    }
}