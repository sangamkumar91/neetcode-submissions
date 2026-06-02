class Solution {
    int result = 0;
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, 0);
    }
    public int findTargetSumWays(int[] nums, int target, int i) {
        if (i == nums.length) {
            if (target == 0)
                return 1;
            return 0;
        }

        return findTargetSumWays(nums, target - nums[i], i + 1) + findTargetSumWays(nums, target + nums[i], i + 1);        
    }

}
