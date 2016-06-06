public class Solution {
    public void sortColors(int[] A) {
        if(A== null || A.length ==0){
            return;
        }

        int idxRed = -1;
        int idxBlue = A.length;

        for(int i=0; i<idxBlue; i++){
            if(A[i] == 0){
                idxRed++;
                int tmp = A[idxRed];
                A[idxRed] = A[i];
                A[i] = tmp;
            }else if(A[i]==2){
                idxBlue--;
                int tmp = A[idxBlue];
                A[idxBlue] = A[i];
                A[i] = tmp;
                i--;
            }
        }
    }
}