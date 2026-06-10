class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        if (s1.length() > s2.length()) return false;

        for (char c: s1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            count2[c - 'a']++;
        }
        int match = 0;
        for (int i = 0 ; i < 26 ; i++)
            if (count1[i] == count2[i]) match++;

        int start = 0;
        int end = s1.length();

        if (match == 26) return true;
        while (end < s2.length()) {
            char c = s2.charAt(end);
            count2[c - 'a']++;
            end++;

            if (count2[c - 'a'] == count1[c - 'a'] + 1) {
                match--;
            } else if (count2[c - 'a'] == count1[c - 'a']) {
                match++;
            }

            c = s2.charAt(start);
            count2[c - 'a']--;
            start++;
            if (count2[c - 'a'] == count1[c - 'a'] - 1) {
                match--;
            } else if (count2[c - 'a'] == count1[c - 'a']) {
                match++;
            }

            if (match == 26) return true;

        }

        return false; 

    }
}
