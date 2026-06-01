class Solution {
    int m;
    int n;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return edit(word1, word2, 0, 0, dp);
    }
    public int edit(String word1, String word2, int index1, int index2, int[][] dp) {
        if (index1 == m && index2 == n) return 0;
        if (index1 == m) return Math.abs(n - index2);
        if (index2 == n) return Math.abs(m - index1);

        if (dp[index1][index2] != -1) return dp[index1][index2];
        if (word1.charAt(index1) == word2.charAt(index2)) 
            dp[index1][index2] = edit(word1, word2, index1 + 1, index2 + 1, dp);
        else {
            int delete = edit(word1, word2, index1 + 1, index2, dp);
            int edit = edit(word1, word2, index1 + 1, index2 + 1, dp);
            int add = edit(word1, word2, index1, index2 + 1, dp);
            dp[index1][index2] = 1 + Math.min(Math.min(delete, edit), add);
        }
        return dp[index1][index2];
    }

}


//     m   o   n   e   y
// m   1   0   0   0   0 
// o   0   1   0   0   0
// n   0   0   1   0   0
// k   0   0   0   0   0
// e   0   0   0   1   0
// y   0   0   0   0   1
// s   0   0   0   0   0       

//     n   e   e   t   c   o   d   e
// n   1   0   0   0   0   0   0   0
// e   0   1   0   0   0   0   0   0
// a   0   0   0   0   0   0   0   0
// t   0   0   0   1   0   0   0   0 
// c   0   0   0   0   1   0   0   0
// d   0   0   0   0   0   0   1   0
// e   0   0   0   0   0   0   0   1
// e   0   0   0   0   0   0   0   1