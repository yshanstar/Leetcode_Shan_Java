public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
        	res.add(new ArrayList<Integer>());
        	return res;
        }

        boolean [] used = new boolean[num.length];
        ArrayList<Integer> tmp = new ArrayList<Integer>();

        helper(0,used,tmp,num,res);

        return res;
    }

    private void helper(int idx, boolean[] used, ArrayList<Integer> tmp, int [] num, ArrayList<ArrayList<Integer>> res){
		if(idx == num.length){
			res.add(new ArrayList<Integer>(tmp));
			return ;
		}

		for(int i =0; i<num.length; i++){
			if(!used[i]){
				tmp.add(num[i]);
				used[i] = true;
				helper(idx+1, used, tmp, num, res);
				used[i]= false;
				tmp.remove(tmp.size()-1);
			}
		}
    }
}