public class Solution {
    public int climbStairs(int n) {
        if(n <= 1){
        	return n;
        }

        int pre = 1;
        int now = 2;

        for(int i=3; i<=n; i++){
        	int tmp = pre + now;
        	pre = now;
        	now = tmp;
        }

        return now;
    }
}