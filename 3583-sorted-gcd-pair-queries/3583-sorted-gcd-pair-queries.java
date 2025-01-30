class Solution {
    public static long[] freq = new long[(int) 5e4 + 1];
    public int[] gcdValues(int[] nums, long[] q) {
        int n = nums.length;
        int m = q.length;
        int max = 0;
        for(int i = 0; i < n; i++) {
            int l = nums[i];
            max = Math.max(max, l);
            for(int j = 1; j * j <= l; j++) {
                if(l % j == 0) {
                    freq[j]++;
                    if(j == (l / j)) continue;
                    freq[l / j]++;
                }
            }
        }
        long[] dp = new long[max + 1];
        for(int i = max; i >= 1; i--) {
            long count = (1l * freq[i] * (freq[i] - 1)) / 2;
            dp[i] += count;
            for(int j = i * 2; j <= max; j += i) {
                dp[i] -= dp[j];
            }
        }
        for(int i = 1; i <= max; i++) {
            dp[i] += dp[i - 1];
        }
        int[] ans = new int[m];
        for(int i = 0; i < m; i++) {
            long l = q[i] + 1;
            int r = BS(dp, l);
            ans[i] = r;
        }
        for(int i = 0; i < n; i++) {
            int l = nums[i];
            for(int j = 1; j * j <= l; j++) {
                if(l % j == 0) {
                    freq[j]--;
                    if(j == (l / j)) continue;
                    freq[l / j]--;
                }
            }
        }
        return ans;
    }
    public static int BS(long[] dp, long i) {
        int start = 0;
        int end = dp.length;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(i > dp[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}