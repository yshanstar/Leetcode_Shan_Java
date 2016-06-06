public class Solution {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if(num == null || num.length == 0){
        	return res;
        }

        Arrays.sort(num);

        ArrayList<Integer> tmp = new ArrayList<Integer>();
		boolean[] isVistied = new boolean[num.length];

		helper(res, num, isVistied, 0, tmp);

		return res;
    }

    private void helper(ArrayList<ArrayList<Integer>> res, int[] num, boolean[] visited, int idx, ArrayList<Integer> tmp){
    	if(idx == num.length){
    		res.add(new ArrayList<Integer>(tmp));
    		return;
    	}

    	for(int i=0; i<num.length; i++){
			if(!visited[i]){
				tmp.add(num[i]);
				visited[i] = true;
				helper(res, num, visited, idx+1, tmp);
				visited[i] = false;
				tmp.remove(tmp.size()-1);

				while(i+1<num.length && num[i+1] == num[i]){
					i++;
				}
			}
    	}
    }
}