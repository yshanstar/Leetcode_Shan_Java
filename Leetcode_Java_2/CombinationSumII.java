public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        if(num == null || num.length == 0){
        	return new ArrayList<ArrayList<Integer>>(res);
        }

        Arrays.sort(num);

        helper(res, 0, target, num, new ArrayList<Integer>());

        return new ArrayList<ArrayList<Integer>>(res);
    }

    private void helper(HashSet<ArrayList<Integer>> res, int idx, int target, int [] num, ArrayList<Integer> tmp){
    	if(idx >= num.length){
    		if(target == 0){
    			res.add(new ArrayList<Integer>(tmp));
    		}
    		return;
    	}

    	helper(res, idx+1, target, num, tmp);

    	if(target >= num[idx]){
    		tmp.add(num[idx]);
    		helper(res, idx+1, target-num[idx], num, tmp);
    		tmp.remove(tmp.size()-1);
    	}

    }
}