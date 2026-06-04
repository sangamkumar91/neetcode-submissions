class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String p1 = palindrome(s, i - 1, i);
            String p2 = palindrome(s, i, i);

            if (p1.length() > result.length())
                result = p1;
            if (p2.length() > result.length())
                result = p2;

        }
        return result; 
    }
    public String palindrome(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        while (start >= 0
            && end < s.length()
            && s.charAt(start) == s.charAt(end)
        ) {
            if (start != end) {
                sb.insert(0, s.charAt(start));
            }
            sb.append(s.charAt(end));
            start--;
            end++;
        }
        return sb.toString();
    }
}
