public class Solution {
    public int numTrees(int n) {
        // dp[i] will store the number of unique BSTs that can be formed with i nodes
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1;  // 1 way to arrange an empty tree
        dp[1] = 1;  // 1 way to arrange a tree with a single node
        
        // Fill dp array using the recursive formula
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        
        return dp[n];
    }
}
