class Solution {
    public int maxSubArray(int[] nums) {
        int start = 0;
        int max = nums[start];
        while (start < nums.length && nums[start] <= 0) {
            max = Math.max(max, nums[start]);
            start++;
        }
        int sum = 0;
        for (int i = start ; i < nums.length; i++) {
            if (sum + nums[i] >= 0) {
                sum = sum + nums[i];
                max = Math.max(max, sum);
                continue;
            }
            sum = 0;
        }
        return max;
    }


}