class Solution {
    public int rob(int[] nums) {
        int[][] memo = new int[nums.length][2];
        return dp(nums, 0, memo, false);
    }

    public int dp(int[] nums, int index, int[][] memo, boolean firstHouseRobbed) {
        if (index >= nums.length) return 0;
        if (index == nums.length - 1 && firstHouseRobbed) return 0;
        int result = 0;
        if (memo[index][firstHouseRobbed ? 1 : 0] != 0) return memo[index][firstHouseRobbed ? 1 : 0];
        if (index == 0)
            result = Math.max(dp(nums, index + 1, memo, false), nums[index] + dp(nums, index + 2, memo, true));
        else
            result = Math.max(
                dp(nums, index + 1, memo, firstHouseRobbed),
                nums[index] + dp(nums, index + 2, memo, firstHouseRobbed)
            );

        memo[index][firstHouseRobbed ? 1 : 0] = result;
        return result;
    }

}
