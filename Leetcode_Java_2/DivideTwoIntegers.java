public class Solution {
	public int divide(int dividend, int divisor) {
		int res = 0;
		boolean sign = true;

		if((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)){
			sign = false;
		}

		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);

		while(a>=b){
			int multier = 1;
			long tmp = b;
			while(a >=tmp){
				a -= tmp;
				res += multier;
				tmp = tmp<< 1;
				multier = multier<< 1;
			}
		}

		if(!sign){
			return -res;
		}

		return res;
    }
}