class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }

        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (end + start) / 2;
            if (A[mid] == target) {
                return true;
            } else if (A[start] != A[end]) {
                if (A[start] <= A[mid]) {
                    if (A[start] <= target && target < A[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (target <= A[end] && target > A[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            } else {
                for (int i = start; i < end; i++) {
                    if (A[i] == target) {
                        return true;
                    }
                }
                return false;
            }
        }

        return false;
    }
}