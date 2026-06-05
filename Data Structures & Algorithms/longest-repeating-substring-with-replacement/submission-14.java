class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        TreeSet<Character> treeSet = new TreeSet<>(
                (a, b) -> freq[a - 'A'] == freq[b - 'A'] ? a - b : freq[a - 'A'] - freq[b - 'A']);

        int start = 0;
        int end = 0;
        int longest = 0;

        for (end = 0; end < s.length(); ++end) {
            char e = s.charAt(end);

            treeSet.remove(e);
            freq[e - 'A']++;
            treeSet.add(e);

            char mf = treeSet.last();

            while (end - start + 1 - freq[mf - 'A'] > k) {
                char st = s.charAt(start);
                treeSet.remove(st);
                freq[st - 'A']--;
                treeSet.add(st);
                mf = treeSet.last();
                start++;
            }

            longest = Math.max(longest, end - start + 1);
        }

        return longest;
    }
}