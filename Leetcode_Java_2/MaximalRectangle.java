public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
        	return 0;
        }

        int[][] matrixNum = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix[0].length; i++){
        	matrixNum[0][i] = (matrix[0][i] == '1') ? 1 : 0;
        }

        for(int i = 1; i<matrixNum.length; i++){
        	for(int j=0; j<matrixNum[i].length; j++){
        		matrixNum[i][j] = (matrix[i][j] == '1')?matrixNum[i-1][j] + 1:0;
        	}
        }

        int maxArea = 0;
        for(int i=0; i<matrixNum.length; i++){
        	maxArea = Math.max(maxArea, maximalRectangle(matrixNum[i]));
        }

        return maxArea;
    }

    private int maximalRectangle(int[] num){
    	if(num == null || num.length == 0){
    		return 0;
    	}
    	int i = 0;
    	int max = 0;
    	int [] nums = new int [num.length+1];
    	nums = Arrays.copyOf(num, num.length+1);

    	Stack<Integer> s = new Stack<Integer>();
    	while(i<nums.length){
    		if(s.isEmpty() || nums[s.peek()] < nums[i]){
    			s.push(i++);
    		}else{
    			int idx = s.pop();
    			max = Math.max(max, nums[idx] * ((s.isEmpty())?i:(i-s.peek()-1)));
    		}
    	}
    	return max;
    }
}