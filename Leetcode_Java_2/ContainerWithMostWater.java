public class Solution {
	public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;

        while(start < end){
        	int tmp = Math.min(height[start], height[end]) * (end - start);
        	max = Math.max(tmp, max);
        	if(height[start] <= height[end]){
        		start++;
        	}else{
        		end--;
        	}
        }
        return max;
    }
}