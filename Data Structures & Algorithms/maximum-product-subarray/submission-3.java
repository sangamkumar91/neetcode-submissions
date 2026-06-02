class Solution {
    public int maxProduct(int[] nums) {
        int[] maxLeft = new int[nums.length];
        maxLeft[0] = nums[0];
        int[] minLeft = new int[nums.length];
        minLeft[0] = nums[0];
        int[] maxRight = new int[nums.length];
        maxRight[nums.length - 1] = nums[nums.length - 1];
        int[] minRight = new int[nums.length];
        minRight[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1] * nums[i], Math.max(nums[i], minLeft[i - 1] * nums[i]));
            minLeft[i] = Math.min(minLeft[i - 1] * nums[i], Math.min(nums[i], maxLeft[i - 1] * nums[i]));
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1] * nums[i], Math.max(nums[i], minRight[i + 1] * nums[i]));
            minRight[i] = Math.min(minRight[i + 1] * nums[i], Math.min(nums[i], maxRight[i + 1] * nums[i]));
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == 0) {
                result = Math.max(result, 0);
                continue;
            }
            if (nums[i] > 0) {
                result = Math.max(result, maxLeft[i] * (maxRight[i]/nums[i]));
                continue;
            }
            int current = Math.max(Math.max(
                maxLeft[i] * maxRight[i] / nums[i],
                minRight[i] * minLeft[i] / nums[i]
            ),
            Math.max(
                minLeft[i] * maxRight[i] / nums[i],
                minRight[i] * maxLeft[i] / nums[i]
            ));

            result = Math.max(result, current);
        }
        return result;
    }
}
