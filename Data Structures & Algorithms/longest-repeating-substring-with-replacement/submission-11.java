class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap();
        int start = 0;
        int end = 0;
        int result = 0;
        int maxFreq = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            count.put(c, count.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(c));
            end++;
            // The difficult part here is Max Frequency does not need to be updated
            while (maxFreq + k < end - start) {
                char d = s.charAt(start);
                count.put(d, count.getOrDefault(d, 0) - 1);
                start++;
            }
            result = Math.max(result, end - start);
        }
        return result;
    }
}
