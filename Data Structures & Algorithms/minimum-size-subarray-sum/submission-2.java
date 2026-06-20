class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end  = 0;

        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum = sum + nums[end];
            end++;
            while (sum >= target && start < end) {
                result = Math.min(result, end - start);
                sum = sum - nums[start];
                start++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
        
    }
}