public class Solution {
    public String countAndSay(int n) {
		if(n<1){
        	return "";
        }
       	String res = "1";
        for(int i = 2; i<=n; i++){
        	int count = 1;
        	char c = res.charAt(0);
        	StringBuilder sb = new StringBuilder();
        	for(int j=1; j<res.length(); j++){
        		if(res.charAt(j) == c){
        			count++;
        		}else{
        			sb.append(count);
        			sb.append(c);
        			c = res.charAt(j);
        			count = 1;
        		}
        	}
        	sb.append(count);
        	sb.append(c);
        	res = sb.toString();
        	sb = new StringBuilder();
        }

        return res;
    }
}