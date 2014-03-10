public class Solution {
    public int removeElement(int[] A, int elem) {
    	if(A == null || A.length == 0){
    		return 0;
    	}

    	int j = 0;
    	for(int i=0; i<A.length; i++){
    		if(A[i] == elem){
    			continue;
    		}else{
    			A[j] = A[i];
				j++;
    		}
    	}

    	return j;
    }
}