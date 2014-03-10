public class Solution {
    public int firstMissingPositive(int[] A) {
        int idx = 0;
        while(idx < A.length){
        	if(A[idx] != idx+1 && A[idx] >= 1 && A[idx] <=A.length && A[idx] != A[A[idx] - 1]){
        		int tmp = A[idx];
        		A[idx] = A[tmp-1];
        		A[tmp-1] = tmp;
        	}else{
        		idx++;	
        	}
        }

        for(int i = 0; i<A.length; i++){
        	if(A[i] != i+1){
        		return i+1;
        	}
        }

		return A.length+1;
    }
}