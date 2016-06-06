public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1== null && s2==null && s3==null){
        	return true;
        }
        if(s1 ==null){
        	return s2.equals(s3);
        }else if(s2==null){
        	return s1.equals(s3);
        }
        if(s3==null){
        	return false;
        }

        if(s3.length() != s1.length() + s2.length()){
        	return false;
        }

        boolean [][] match = new boolean[s1.length()+1][s2.length()+1];
        match[0][0] = true;

        for(int i=1; i<=s1.length(); i++){
        	if(s3.charAt(i-1) == s1.charAt(i-1)){
        		match[i][0] = match[i-1][0];
        	}
        }

        for(int i=1; i<=s2.length(); i++){
        	if(s3.charAt(i-1) == s2.charAt(i-1)){
        		match[0][i] = match[0][i-1];
        	}
        }

        for(int i=1; i<=s1.length(); i++){
        	for(int j=1; j<=s2.length(); j++){
				match[i][j] = (s3.charAt(i+j-1) == s1.charAt(i-1) && match[i-1][j]) || (s3.charAt(i+j-1) == s2.charAt(j-1) && match[i][j-1]);
        	}
        }

        return match[s1.length()][s2.length()];
    }
}