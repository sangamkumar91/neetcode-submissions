class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;

            // Conditions basd on which side of the rotation index does mid fall
            if (nums[start] < nums[mid]){
                if (nums[start] <= target && nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                continue;
            }

            if (nums[end] > nums[mid]) {
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                continue;
            }
            start++;
        }

        return nums[start] == target ? start : -1;
    }
}
