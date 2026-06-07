class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        Integer[][] memo = new Integer[t.length()][s.length()];
        return helper(t, s, 0, 0, memo);
    }
    public int helper(String shorter, String longer, int i, int j, Integer[][] memo) {
        if (i == shorter.length())
            return 1;
        if (j == longer.length())
            return 0;
        if (memo[i][j] != null) return memo[i][j];

        memo[i][j] = helper(shorter, longer, i, j + 1, memo);
        if (shorter.charAt(i) != longer.charAt(j)) {
            memo[i][j] = helper(shorter, longer, i, j + 1, memo);
        } else {
            memo[i][j] = helper(shorter, longer, i + 1, j + 1, memo)
                        + helper(shorter, longer, i, j + 1, memo);
        }
        return memo[i][j];
    }
}
