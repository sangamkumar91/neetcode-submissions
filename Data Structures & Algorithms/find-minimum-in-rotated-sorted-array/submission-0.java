class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            System.out.println(start);
            System.out.println(end);
            int mid = start + (end - start)/ 2;

            int m = nums[mid];
            System.out.println("mid");
            System.out.println(m);
            if (nums[start] > nums[end] && m >= nums[start]) {
                start = mid + 1;
                continue;
            }
            end = mid;
        }
        return nums[end];
    }
}
