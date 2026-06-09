class Solution {
    List<List<String>> result = new ArrayList();
    public List<List<String>> partition(String s) {
        List<String> current = new ArrayList();
        helper(0, 0, s, current);
        return result;
    }

    public void helper(int start, int end, String s, List<String> current) {
        if (end == s.length() - 1) {
            if (isPalindrome(s.substring(start, end + 1))) {
                current.add(s.substring(start, end + 1));
                result.add(new ArrayList(current));
                current.remove(current.size() - 1);
            }
            return;
        }
        helper(start, end + 1, s, current);
        if (isPalindrome(s.substring(start, end + 1))) {
            current.add(s.substring(start, end + 1));
            helper(end + 1, end + 1, s, current);
            current.remove(current.size() - 1);
        }
    }
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}