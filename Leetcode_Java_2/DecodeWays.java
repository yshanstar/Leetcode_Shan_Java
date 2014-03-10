public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }else if(s.length()== 1){
        	if(Integer.parseInt(s) <= 9 && Integer.parseInt(s) >=1){
        		return 1;
        	}
        	return 0;
        }

        int pre = 1;
        int cur = 1;
        for(int i=0; i<s.length(); i++){
        	int tmp = 0;
        	if(s.charAt(i) != '0'){
        		tmp = cur;
        	}

        	if(i>0){
        		int a = Integer.parseInt(s.substring(i-1,i+1));
        		if(s.charAt(i-1) != '0' && a <=26 && a>=1){
        			tmp += pre;
        		}
        	}
        	pre = cur;
        	cur = tmp;
        }

        return cur;
    }
}