import java.util.Arrays;

class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if (num.length < 3) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int absDiff = Integer.MAX_VALUE;

        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            int j = i + 1;
            int k = num.length - 1;

            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                int diff = sum - target;
                if (diff == 0) {
                    return sum;
                } else if (diff > 0) {
                    k--;
                } else {
                    j++;
                }
                if (Math.abs(diff) < absDiff) {
                    absDiff = Math.abs(diff);
                    res = sum;
                }
            }
        }

        return res;
    }
}