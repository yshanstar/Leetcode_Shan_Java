public class Solution {
    public int jump(int[] A) {
        int curMax = 0;
        int step = 0;
        int nextMax = 0;

		for(int i =0; i<A.length; i++){
			if(i>curMax){
				curMax = nextMax;
				step++;
        	}
			nextMax = Math.max(nextMax, i+A[i]);
        }

        return step;
    }
}