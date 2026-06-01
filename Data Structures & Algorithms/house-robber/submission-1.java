class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        return rob(nums, 0, memo);
    }
    public int rob(int[] nums, int index, int[] memo) {
        if (index >= nums.length) return 0;
        if (memo[index] != 0) return memo[index];
        memo[index] = Math.max(rob(nums, index + 1, memo), nums[index] + rob(nums, index + 2, memo));
        return memo[index];
    }

}
