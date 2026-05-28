class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return helper(s1, s2, s3) || helper(s2, s1, s3);
    }    
    public boolean helper(String s, String t, String st) {
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
