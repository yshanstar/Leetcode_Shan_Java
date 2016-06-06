public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        if(s == null || s.length() == 0){
        	return max;
        }

        Stack<Integer> lefts = new Stack<Integer>();
        int last = -1;
        for(int i = 0; i<s.length(); i++){
        	if(s.charAt(i) == '('){
        		lefts.push(i);
        	}else{
        		if(lefts.isEmpty()){
        			last = i;
        		}else{
        			lefts.pop();
        			if(lefts.isEmpty()){
        				max = Math.max(max, i-last);
        			}else{
        				max = Math.max(max, i-lefts.peek());
        			}
        		}
        	}
        }

        return max;
    }
}