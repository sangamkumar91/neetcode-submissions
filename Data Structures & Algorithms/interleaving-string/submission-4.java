class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.length() == 0) return s2.equals(s3);
        if (s2.length() == 0) return s1.equals(s3);
        return helper(s1, s2, s3, 0, 0, 0, new int[s1.length() + 1][s2.length() + 1]);
    } 
    public boolean helper(String s, String t, String st, int i, int j, int k , int[][] memo) {
        if (k == st.length() && i == s.length() && j == t.length()) return true;
        boolean result = false;
        if (memo[i][j] != 0) return memo[i][j] == 1;
        else if (i != s.length() && j != t.length()
            && s.charAt(i) == st.charAt(k)
            && t.charAt(j) == st.charAt(k)) {
            result = helper(s, t, st, i + 1, j, k + 1, memo)
                || helper(s, t, st, i, j + 1, k + 1, memo);
        }
        else if (i != s.length() && s.charAt(i) == st.charAt(k)) {
            result = helper(s, t, st, i + 1, j, k + 1, memo);
        }
        else if (j != t.length() && t.charAt(j) == st.charAt(k)) {
            result = helper(s, t, st, i, j + 1, k + 1, memo);
        }

        memo[i][j] = result ? 1 : 2;
        return result;
    }





//     O(n) solution incorrect.
//     You have to use DFS and memo.
//     helper("ab","ba","baba") → s[0]='a' != 'b', returns false immediately
// helper("ba","ab","baba") → greedily consumes "ba" from s, 
//                            then t[0]='a' != st[2]='b', returns false
    public boolean helperIncorrect(String s, String t, String st) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < st.length()) {
            int previ = i;
            while(i < s.length() && s.charAt(i) == st.charAt(k)) {
                i++;
                k++;
            }
            if (i == previ) return false;
            if (k == st.length()) return true;

            int prevj = j;
            while(j < t.length() && t.charAt(j) == st.charAt(k)) {
                j++;
                k++;
            }
            if (j == prevj) return false;
        }
        return true;
    }    

}
