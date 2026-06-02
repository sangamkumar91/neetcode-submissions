class Solution {
    int result = 0;
    int totalSum = 0;
    int target = 0;
    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        totalSum = 0;
        for (int num : nums) totalSum += num;
        Integer[][] dp = new Integer[nums.length][2 * totalSum + 1];        
        return findTargetSumWays(nums, 0, 0, dp);
    }
    public int findTargetSumWays(int[] nums, int total, int i, Integer[][] dp) {
        if (i == nums.length) {
            if (target == total)
                return 1;
            return 0;
        }


        if (dp[i][total + totalSum] != null) return dp[i][total + totalSum];

        dp[i][total + totalSum] =  findTargetSumWays(nums, total - nums[i], i + 1, dp) + findTargetSumWays(nums, total + nums[i], i + 1, dp);        
        return dp[i][total + totalSum];
    }

}
