class Solution {
    int memo[][];
    public boolean isMatch(String s, String p) {
        memo = new int[s.length()][p.length()];
        return helper(s, p, 0, 0);
        
    }

    public boolean helper(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) return true;
        if (j == p.length()) return false;
        if (i == s.length() && j == p.length() - 2 && p.charAt(j + 1) == '*') return true;
        if (i == s.length() || j == p.length()) return false;
        if (memo[i][j] != 0) return memo[i][j] == 1;
        char c = j < p.length() - 1 ? p.charAt(j + 1) : '#';
        boolean result = false;
        if (c != '*') {
            if (p.charAt(j) == '.') {
               result =  helper(s, p, i+1, j+1); 
            }
            else if (s.charAt(i) == p.charAt(j)) {
                result = helper(s, p, i + 1, j+1);
            } else {
                result = false;
            }
        } else {
            if (p.charAt(j) == '.') {
               result = helper(s, p, i+1, j+2) || helper(s, p, i+1, j) || helper(s, p, i, j+2); 
            } else if (s.charAt(i) != p.charAt(j))
                result = helper(s, p, i, j+2);
            else
                result = helper(s, p, i + 1, j) || helper(s, p, i, j+2);
        }
        memo[i][j] = result ? 1 : -1;
        return result;
    }
}
