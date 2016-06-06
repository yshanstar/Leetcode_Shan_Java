package solution;

public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		int left = 0;
		int right = num.length - 1;
		
		while (left < right) {
			if (num[left] < num[right]) {
				return num[left];
			}

			int mid = (right + left)/2;
			
			if(num[mid] >= num[left]){
				left = mid + 1;
			}else{
				right = mid;
			}
		}
		
		return num[left];
	}
}
