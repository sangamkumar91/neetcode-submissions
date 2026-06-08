class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return helper(s, 0, dp);
    }
    public int helper(String s, int index, Map<Integer, Integer> dp) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        }
        if (index >= s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        int result = helper(s, index + 1, dp);
        if (index + 1 >= s.length()) {
            dp.put(index, result);
            return result;
        }
        int next = index + 1;
        if (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(next) < '7'))
            result = result + helper(s, index + 2, dp);
        dp.put(index, result);
        return result;
    }
}
