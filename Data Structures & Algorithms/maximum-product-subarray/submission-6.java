class Solution {
    public int maxProduct(int[] nums) {
        int[] maxLeft = new int[nums.length];
        maxLeft[0] = nums[0];
        int[] minLeft = new int[nums.length];
        minLeft[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1] * nums[i], Math.max(nums[i], minLeft[i - 1] * nums[i]));
            minLeft[i] = Math.min(minLeft[i - 1] * nums[i], Math.min(nums[i], maxLeft[i - 1] * nums[i]));
            result = Math.max(result, maxLeft[i]);
        }
        return result;
    }
}
