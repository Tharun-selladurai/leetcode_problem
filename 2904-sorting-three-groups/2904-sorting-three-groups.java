class Solution {
    List<Integer> nums;
    Integer[][] dp;
    private int solve(int i, int last) {
        if(i < 0) {
            return 0;
        }
        
        if(dp[i][last] != null) {
            return dp[i][last];
        }
        int res = 0;
        if(nums.get(i) == last) {
            res = solve(i-1, last);
        }else if(nums.get(i) < last){
            res = Math.min(solve(i-1, nums.get(i)), 1+solve(i-1, last));
        } else {
            res = 1+solve(i-1, last);
        }
        
        return dp[i][last] = res;
        
    }
    public int minimumOperations(List<Integer> nums) {
        this.nums = nums;
        int n = nums.size();
        this.dp = new Integer[n+1][4];
        int last = nums.get(n-1);
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= 3; i++) {
            res = Math.min(res, solve(n-1, i));    
        }
        
        return res;
    }
}