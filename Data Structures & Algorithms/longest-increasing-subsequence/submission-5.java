class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int size = 0;
        for (int i = 0; i < nums.length; i++)
            size = Math.max(size, helper(nums, i, memo));
        return size;
    }
    public int helper(int[] nums, int index, int[] memo) {
        if (index == nums.length) return 0;
        if (memo[index] != -1) return memo[index];
        int size = 0;
        for (int i = index; i < nums.length ; i++) {
            if (nums[i] > nums[index]) {
                size = Math.max(size, helper(nums, i, memo));
            }
        }
        memo[index] = size + 1;
        return memo[index];
    }
}
