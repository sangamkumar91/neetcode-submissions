class Solution {
    HashMap<Integer, Integer> memo = new HashMap();
    public int climbStairs(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n < 0) return 0;

        if (memo.getOrDefault(n, -1) != -1) return memo.get(n);

        int result = climbStairs(n - 1) + climbStairs(n - 2);
        memo.put(n, result);
        return result;
    }
}
