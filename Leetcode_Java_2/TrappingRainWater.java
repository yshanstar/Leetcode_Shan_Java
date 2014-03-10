public class Solution {
    public int trap(int[] A) {
        int len = A.length;
        if(len < 3){
        	return 0;
        }

        int start = 0;
        int end = A.length - 1;
        int res = 0;

        int runner = 0;

        while(start < end){
        	if(A[start] > A[end]){
        		runner = end-1;
        		while(A[runner] <= A[end] && runner>start){
        			res += A[end] - A[runner];
        			runner--;
        		}
        		end = runner;
        	}else{
        		runner = start+1;
        		while(A[runner] <= A[start] && runner < end){
        			res += A[start] - A[runner];
        			runner++;
        		}
        		start = runner;
        	}
        }

        return res;
    }
}