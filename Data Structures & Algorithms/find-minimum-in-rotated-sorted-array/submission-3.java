class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start)/ 2;

            int m = nums[mid];
            if (nums[start] > nums[end] && m >= nums[start]) {
                start = mid + 1;
                continue;
            }
            end = mid;
        }
        return nums[start];
    }
}
