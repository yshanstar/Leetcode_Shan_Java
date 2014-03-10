public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
        	return 0;
        }
        if(triangle.size()==1){
			return triangle.get(0).get(0);
        }

        int [] dp = new int [triangle.size()];

        for(int i=triangle.size()-1; i>=0; i--){
        	for(int j=0; j<triangle.get(i).size(); j++){
        		if(i == triangle.size()-1){
        			dp[j] = triangle.get(i).get(j);
        			continue;
        		}

				dp[j] = Math.min(dp[j+1], dp[j]) + triangle.get(i).get(j);
        	}
        }

        return dp[0];
    }
}