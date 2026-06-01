class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0;
        boolean isNegative = false;
        if (n < 0) {
            n = n * -1;
            isNegative = true;
        }
        double[] dp = new double[n + 1];
        
        return !isNegative ? helper(x, n, dp) : 1/helper(x, n, dp);
    }
    public double helper(double x, int n, double[] dp) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (dp[n] != 0.0) return dp[n];

        dp[n] = helper(x, n/2, dp) * helper(x, n/2, dp) * helper(x, n % 2, dp);
        return dp[n];
    }

}
