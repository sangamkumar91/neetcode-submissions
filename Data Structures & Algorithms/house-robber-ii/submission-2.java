class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];
        return Math.max(
            dp(nums, 1, nums.length, memo1), dp(nums, 0, nums.length - 1, memo2)
        );
    }

    public int dp(int[] nums, int index, int end, int[] memo) {
        if (index >= end) return 0;
        int result = 0;
        if (memo[index] != 0) return memo[index];
        result = Math.max(dp(nums, index + 1, end, memo), nums[index] + dp(nums, index + 2, end, memo));

        memo[index] = result;
        return result;
    }

}
