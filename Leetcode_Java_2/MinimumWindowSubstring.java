public class Solution {
    public String minWindow(String S, String T) {
        if(S == null || T ==null || S.length() ==0 || T.length()==0){
			return "";
        }
        int[] needToFind = new int[256];

        for(char c : T.toCharArray()){
        	needToFind[c]++;
        }

        int start = 0;
        int end = 0;
        int [] hasFound = new int[256];
        int count = 0;
        int minWindows = Integer.MAX_VALUE;
        int minWindowStart = 0;
        int minWindowEnd = 0;
        for(start=0, end=0; end<S.length(); end++){
        	char c = S.charAt(end);
        	if(needToFind[c] == 0){
        		continue;
        	}
        	hasFound[c]++;
        	if(hasFound[c] <= needToFind[c]){
        		count++;
        	}
        	if(count == T.length()){
        		while(hasFound[S.charAt(start)] == 0 || hasFound[S.charAt(start)] > needToFind[S.charAt(start)]){
        			if(hasFound[S.charAt(start)] > needToFind[S.charAt(start)]){
        				hasFound[S.charAt(start)]--;
        			}
        			start++;
        		}
        		int windowLength = (end-start+1);
        		if(windowLength< minWindows){
        			minWindows = windowLength;
        			minWindowEnd = end;
        			minWindowStart = start;
        		}
        	}
        }

        return (count == T.length())?S.substring(minWindowStart, minWindowEnd+1):"";
    }
}