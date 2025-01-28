class Solution {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (a, b) -> Integer.compare(a[0], b[0]));

        int n = stockPrices.length;
        if (n == 1) return 0; // No lines are needed for a single point

        int lines = 1; // At least one line is needed
        for (int i = 2; i < n; i++) {
            // Calculate slopes of consecutive segments
            long dy1 = stockPrices[i - 1][1] - stockPrices[i - 2][1];
            long dx1 = stockPrices[i - 1][0] - stockPrices[i - 2][0];
            long dy2 = stockPrices[i][1] - stockPrices[i - 1][1];
            long dx2 = stockPrices[i][0] - stockPrices[i - 1][0];

            // Compare the two slopes to check if they're the same
            // Use cross multiplication to avoid floating-point inaccuracies
            if (dy1 * dx2 != dy2 * dx1) {
                lines++;
            }
        }

        return lines; 
    }
}