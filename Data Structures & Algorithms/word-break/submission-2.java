class Solution {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        return helper(s, wordDict, 0) == 1;
    }
    public int helper(String s, List<String> wordDict, int index) {
        if (index == s.length()) return 1;
        if (memo[index] != 0) return memo[index];
        StringBuilder sb = new StringBuilder();
        for (int i = index ; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (wordDict.contains(sb.toString()))
                if (helper(s, wordDict, i + 1) == 1)
                    return 1;
        }
        memo[index] = wordDict.contains(sb.toString()) ? 1 : -1;
        return memo[index];
    }
}
