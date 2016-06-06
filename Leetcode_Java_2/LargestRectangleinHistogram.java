public class Solution {
    public int largestRectangleArea(int[] height) {
    	if(height == null || height.length == 0){
    		return 0;
    	}

    	int i = 0;
    	int maxArea = 0;
    	int[] h = new int[height.length + 1];
    	h = Arrays.copyOf(height, height.length + 1);

    	Stack<Integer> stackIdx = new Stack<Integer>();
    	while(i<h.length){
    		if(stackIdx.isEmpty() || h[stackIdx.peek()] < h[i]){
    			stackIdx.push(i++);
    		}else{
    			int idx = stackIdx.pop();
    			maxArea = Math.max(maxArea, h[idx] * ((stackIdx.isEmpty())?i:i-stackIdx.peek()-1));
    		}
    	}

    	return maxArea;
    }
}