public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(k>n){
        	return res;
        }
		if(k ==1){
			for(int i =1; i<=n; i++){
        		ArrayList<Integer> tmpRes = new ArrayList<Integer>();
        		tmpRes.add(i);
				res.add(tmpRes);
        	}
        	return res;
        }

        for(int i=n; i>=k; i--){
			for(ArrayList<Integer> tmp : combine(i-1, k-1)){
				tmp.add(i);
				res.add(tmp);
        	}
        }
        return res;
    }
}