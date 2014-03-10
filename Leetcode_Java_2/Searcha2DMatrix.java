public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0){
        	return false;
        }

        int upperRow = 0;
        int lowerRow = matrix.length - 1;

        while(upperRow < lowerRow){
        	int mid = (upperRow + lowerRow)/2;
        	if(matrix[mid][0] == target){
        		return true;
        	}
        	if(matrix[mid][0] > target){
        		lowerRow = mid - 1;
        	}else{
        		int len = matrix[mid].length - 1;
        		if(matrix[mid][len] >= target){
        			upperRow = mid;
        			break;
        		}else{
        			upperRow = mid + 1;	
        		}
        		
        	}
        }

        upperRow = Math.min(lowerRow, upperRow);
        upperRow = (upperRow < 0) ? 0 : upperRow;

        int left = 0;
        int right = matrix[upperRow].length - 1;
        while(left < right){
        	int mid = (right + left) / 2;
        	if(matrix[upperRow][mid] == target){
        		return true;
        	}else if (matrix[upperRow][mid] < target){
        		left = mid +1;
        	}else{
        		right = mid -1;
        	}
        }

        if(left == right){
        	return matrix[upperRow][left] == target;
        }
        return false;
    }
}