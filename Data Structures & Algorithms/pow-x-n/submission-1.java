class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0;
        double[] dp = new double[Math.abs(n) + 1];        
        return n > 0 ? helperItrative(x, Math.abs(n), dp) : 1/helper(x, Math.abs(n), dp);
    }
    public double helper(double x, int n, double[] dp) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (dp[n] != 0.0) return dp[n];

        dp[n] = helper(x, n/2, dp) * helper(x, n/2, dp) * helper(x, n % 2, dp);
        return dp[n];
    }

    public double helperItrative(double x, int n, double[] dp) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double result = 1;
        while (n > 0) {
            if (n%2 > 0)
                result = result * x;
            x = x * x;
            n = n/2;
        }
        return result;
    }
}
