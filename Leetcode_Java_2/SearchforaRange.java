public class Solution {
    public int[] searchRange(int[] A, int target) {
        int [] res = new int [2];
        res[0] = -1;
        res[1] = -1;

        if(A == null || A.length == 0){
            return res;
        }

        int left = 0;
        int right = A.length - 1;

        while(left < right){
            int mid = (right + left) / 2;
            if(A[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        if(A[left] != target){
            return res;
        }

        res[0] = left;
        left = 0;
        right = A.length-1;
        while(left < right){
            int mid = (right + left) / 2;
            if(A[mid]>target){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        if(A[left] != target){
            res[1] = left - 1;
        }else{
            res[1] = left;
        }

        return res;
    }
}