public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer>();
		if(L == null || L.length == 0){
			return res;
        }

        HashMap<String, Integer> wordRecord = new HashMap<String, Integer>();
        int fixSize = L[0].length();

        for(String s : L){
        	if(wordRecord.containsKey(s)){
        		wordRecord.put(s,wordRecord.get(s)+1);
        	}else{
        		wordRecord.put(s,1);
        	}
        }

        int i = 0;
        while(S.length() - i >= L.length*fixSize){
        	HashMap<String, Integer> tmpMap = new HashMap<String, Integer>(wordRecord);
        	for(int j = 0; j<L.length; j++){
        		String tmp = S.substring(i+j*fixSize, i+(j+1)*fixSize);
        		if(tmpMap.containsKey(tmp)){
        			if(tmpMap.get(tmp) == 1){
        				tmpMap.remove(tmp);
        			}else{
        				tmpMap.put(tmp,tmpMap.get(tmp)-1);
        			}
        		}else{
        			break;
        		}
        	}
        	if(tmpMap.size() == 0){
        		res.add(i);
        	}
        	i++;
        }

        return res;
    }
}