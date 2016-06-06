public class Solution {
    public String convert(String s, int nRows) {
        if(nRows <=1 || s.length() <2){
        	return s;
        }

        ArrayList<StringBuilder> res = new ArrayList<StringBuilder>();

		for(int i =0; i<nRows; i++){
			res.add(new StringBuilder());
        }

		int count = 2 * (nRows - 1);

		for(int i =0; i<s.length(); i++){
			int idx = i%count;
			int level = nRows - 1 - Math.abs(nRows - 1 - idx);
			res.get(level).append(s.charAt(i));
		}

		StringBuilder sb = new StringBuilder();
		for(StringBuilder ss : res){
			sg.append(ss.toString());
		}

		return sb.toString();
    }
}