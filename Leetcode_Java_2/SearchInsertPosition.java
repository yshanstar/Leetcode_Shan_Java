public class Solution {
    public int searchInsert(int[] A, int target) {
    	int idx = 0;
    	if(A == null || A.length == 0){
    		return 0;
    	}

    	int left = 0;
    	int right = A.length - 1;

    	while(left < right){
    		int mid = (right + left)/2;
    		if(A[mid] == target){
    			return mid;
    		}else if(A[mid] > target){
    			right = mid - 1;
    		}else{
    			left = mid + 1;
    		}
    	}

    	if(A[left] >= target){
    		return left;
    	}else{
    		return left + 1;
    	}
    }
}