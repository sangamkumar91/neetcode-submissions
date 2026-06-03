class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        int split = -1;
        while (split != k - 1) {
            split = partition(nums, start, end);

            if (split < k - 1) {
                start = split + 1;
                continue;
            }
            end = split - 1;
        }

        return nums[split];
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int pivotIndex = end;
        end = end - 1;
        while (start <= end) {
            if (nums[start] >= pivot) {
                start++;
                continue;
            }
            swap(nums, start, end);
            end--;
        }
        swap(nums, pivotIndex, start);
        return start;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
