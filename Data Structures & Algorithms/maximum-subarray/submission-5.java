class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0 ; i < nums.length; i++) {
            if (sum + nums[i] >= 0) {
                sum = sum + nums[i];
                max = Math.max(max, sum);
                continue;
            }
            // if everything negative
            max = Math.max(max, nums[i]);
            sum = 0;
        }
        return max;
    }


}