class Solution {
    public boolean isMatch(String s, String p) {

        return helper(s, p, 0, 0);
        
    }

    public boolean helper(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) return true;
        if (j == p.length()) return false;
        if (i == s.length() && j == p.length() - 2 && p.charAt(j + 1) == '*') return true;
        if (i == s.length() || j == p.length()) return false;
        char c = j < p.length() - 1 ? p.charAt(j + 1) : '#';
        if (c != '*') {
            if (p.charAt(j) == '.') {
               return helper(s, p, i+1, j+1); 
            }
            else if (s.charAt(i) == p.charAt(j)) {
                return helper(s, p, i + 1, j+1);
            } else {
                return false;
            }
        } else {
            if (p.charAt(j) == '.') {
               return helper(s, p, i+1, j+2) || helper(s, p, i+1, j) || helper(s, p, i, j+2); 
            } else if (s.charAt(i) != p.charAt(j))
                return helper(s, p, i, j+2);
            else
                return helper(s, p, i + 1, j) || helper(s, p, i, j+2);
        }
    }
}
