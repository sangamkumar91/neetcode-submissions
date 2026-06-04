class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> chars= new HashMap();
        int res = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (chars.getOrDefault(c, 0) != 0) {
                while (s.charAt(start) != c) {
                    char j = s.charAt(start);
                    chars.put(j, chars.getOrDefault(j, 0) - 1);
                    start++;
                }
                chars.put(c, chars.getOrDefault(c, 0) - 1);
                start++;
            }
            end++;
            res = Math.max(res, end - start);
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }
        return res;
    }
}
