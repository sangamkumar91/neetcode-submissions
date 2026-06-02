class Solution {
    int result = 0;
    public int findTargetSumWays(int[] nums, int target) {
        findTargetSumWays(nums, target, 0);
        return result;
    }
    public void findTargetSumWays(int[] nums, int target, int i) {
        if (i == nums.length) {
            if (target == 0)
                result++;
            return;
        }

        findTargetSumWays(nums, target - nums[i], i + 1);
        findTargetSumWays(nums, target + nums[i], i + 1);        
    }

}
