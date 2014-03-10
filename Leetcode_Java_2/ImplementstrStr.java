public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack == null && needle == null){
        	return null;
        }

        if(needle == null || needle.length() == 0){
        	return haystack;
        }

        int i = 0;
        while( i<haystack.length() ){
        	if(haystack.length() - i < needle.length()){
        		return null;
        	}

        	if(haystack.charAt(i) == needle.charAt(0)){
        		int j = i;
        		while(j-i<haystack.length() && haystack.charAt(j) == needle.charAt(j-i)){
        			j++;
        			if(j-i == needle.length()){
        				return haystack.substring(i);
        			}
        		}
        	}
        	i++;
        }
        return null;
    }
}