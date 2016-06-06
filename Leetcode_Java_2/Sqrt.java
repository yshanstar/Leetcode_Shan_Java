public class Solution {
	public int sqrt(int x) {
		long low = 0;
		long high = x;

		while(high >= low){
			long mid = (high+low)/2;
			if(x < mid*mid){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}

		return (int) high;
	}
}