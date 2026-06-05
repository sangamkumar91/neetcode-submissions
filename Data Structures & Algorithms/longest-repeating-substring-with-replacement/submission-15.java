class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        TreeSet<Character> sorted = new TreeSet<>((a, b) -> {
            return freq[b - 'A'] == freq[a - 'A'] ? b - a : freq[b - 'A'] - freq[a - 'A'];
        });
        int start = 0;
        int end = 0;
        int result = 0;
        while (end < s.length()) {
            char c = s.charAt(end);

            sorted.remove(c);
            freq[c - 'A']++;
            sorted.add(c);

            end++;
            while (freq[sorted.first() - 'A'] + k < end - start) {
                char d = s.charAt(start);
                sorted.remove(d);
                freq[d - 'A']--;
                sorted.add(d);
                start++;
            }
            result = Math.max(result, end - start);
        }
        return result;
    }
}