class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        return helper(text1, text2, 0, 0, memo);
    }

    public int helper(String s1, String s2, int i, int j, int[][] memo) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (memo[i][j] != 0) return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            // Match found
            memo[i][j]  = 1 + helper(s1, s2, i + 1, j + 1, memo);
            return memo[i][j];
        }
        memo[i][j] = Math.max(
            // s1's char is not part of the subsequence
            helper(s1, s2, i, j + 1, memo),
            // s2's char is not part of the subsequence
            helper(s1, s2, i + 1, j, memo)
        );
        return memo[i][j];
    }
}
