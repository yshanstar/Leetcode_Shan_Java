public class Solution {
    public boolean canJump(int[] A) {
        if(A == null || A.length == 0){
        	return true;
        }

        int nextMax = 0;

        for(int i = 0; i<A.length; i++){
        	if(i>nextMax){
        		return false;
        	}
        	nextMax = Math.max(nextMax, i+A[i]);

			if(nextMax >= A.length-1){
        		return true;
        	}
        }
        return false;
    }
}