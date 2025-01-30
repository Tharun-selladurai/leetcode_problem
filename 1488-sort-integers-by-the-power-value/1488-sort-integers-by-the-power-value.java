class Solution {
    int[] dp;

    public int getKth(int lo, int hi, int k) {
        int[][] store = new int[hi - lo + 1][2];
        dp = new int[10000];
        Arrays.fill(dp, -1);

        int temp = lo;
        for (int i = 0; i < (hi - lo + 1); i++) {
            store[i][0] = temp;
            store[i][1] = fun(temp);
            temp++;
        }

        // Sorting by power values
        // Arrays.sort(store, (a, b) -> Integer.compare(a[1], b[1]));
        countingSort2D(store);

        return store[k - 1][0];
    }

    private int fun(int n) {
        // Base case
        if (n == 1)    
            return 0;

        if (n < dp.length && dp[n] != -1) 
            return dp[n];

        int result;
        if ((n & 1) == 0) {
            result = 1 + fun(n / 2);
        } else {
            result = 1 + fun(3 * n + 1);
        }

        // Memoize if within bounds
        if (n < dp.length) 
            dp[n] = result;

        return result;
    }

    public void countingSort2D(int[][] arr) {
    // Find the range of values in the second column
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for (int[] row : arr) {
        max = Math.max(max, row[1]);
        min = Math.min(min, row[1]);
    }

    int range = max - min + 1; // Adjust range for counting
    int[] count = new int[range];

    // Count occurrences of each value in the second column
    for (int[] row : arr) {
        count[row[1] - min]++;
    }

    // Compute cumulative counts
    for (int i = 1; i < count.length; i++) {
        count[i] += count[i - 1];
    }

    // Create an output array
    int[][] output = new int[arr.length][2];

    // Place elements in sorted order
    for (int i = arr.length - 1; i >= 0; i--) {
        int value = arr[i][1];
        int position = count[value - min] - 1; // Get position from cumulative count
        output[position] = arr[i];
        count[value - min]--;
    }

    // Copy sorted array back to original array
    for (int i = 0; i < arr.length; i++) {
        arr[i] = output[i];
    }
}

}