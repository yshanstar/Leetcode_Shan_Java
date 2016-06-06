public class Solution {
	public int lengthOfLongestSubstring(String s) {
        boolean [] flag = new boolean[256];

        int i = 0;
        int j = 0;
        int maxLength = 0;

        for(i=0; i<s.length(); i++){
        	if(flag[s.charAt(i)] == true){
        		maxLength = Math.max(i-j, maxLength);
        		for(int k = j; k<i; k++){
        			if(s.charAt(k) == s.charAt(i)){
        				j = k + 1;
        				break;
        			}
        			flag[s.charAt(k)] = false;
        		}
        	}else{
        		flag[s.charAt(i)] = true;
        	}
        }

        maxLength = Math.max(maxLength, s.length()-j);
        return maxLength;
    }
}