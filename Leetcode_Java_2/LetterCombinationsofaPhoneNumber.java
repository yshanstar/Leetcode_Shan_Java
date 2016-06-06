public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
		char[][] map = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

		ArrayList<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		helper(sb, res, map, 0, digits);
		return res;
    }

    private void helper(StringBuilder sb, ArrayList<String> res, char[][] map, int idx, String digits){
    	if(idx >= digits.length()){
			res.add(sb.toString());
			return;
    	}else{
    		int index = digits.charAt(idx) - '1' - 1;
    		int size = map[index].length;

    		for(int i= 0; i<size; i++){
    			sb.append(map[index][i]);
    			helper(sb, res, map, idx+1, digits);
    			sb.deleteCharAt(sb.length()-1);
    		}
    	}
    }
}