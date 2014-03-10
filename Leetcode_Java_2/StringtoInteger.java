public class Solution {
    public int atoi(String str) {
        int res = 0;
        boolean isPositive = true;
        int startIdx = 0;
        if(str == null || str.length() == 0){
            return res;
        }

        String s = str.trim();

        if(s.charAt(startIdx) == '-'){
            isPositive = false;
            startIdx++;
        }else if (s.charAt(startIdx) == '+'){
            startIdx++;
        }else if(s.charAt(startIdx) < '0' || s.charAt(startIdx) > '9') {
            return res;
        }

        int count = 0;
        for(int i = startIdx; i<s.length() && s.charAt(i) >= '0' && s.charAt(i) <='9' ; i++){
            if(isPositive){
                if(count == 10 || (count == 9 && res == 214748364 && s.charAt(i) >= '7') ){
                    return Integer.MAX_VALUE;
                }
                res = res*10 + (s.charAt(i) - '0');
            }else{
                if(count == 10 || (count ==9 && res == 214748364 && s.charAt(i) >= '8')){
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + (s.charAt(i) - '0');
            }
            count++;
        }

        return (isPositive) ? res : -res;
    }
}