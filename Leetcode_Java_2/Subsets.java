public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());

        if(S == null || S.length == 0){
        	return res;
        }

        Arrays.sort(S);

        helper(res, S, 0);

        return res;
    }

    private void helper(ArrayList<ArrayList<Integer>> res,
    					int[] S,
    					int idx){
    	if(idx == S.length){
    		return;
    	}

    	ArrayList<ArrayList<Integer>> resNext = new ArrayList<ArrayList<Integer>>(res);

    	for(ArrayList<Integer> set : resNext){
    		ArrayList<Integer> tmp = new ArrayList<Integer>(set);
    		tmp.add(S[idx]);
    		res.add(tmp);
    	}

    	helper(res, S, idx+1);
    }
}