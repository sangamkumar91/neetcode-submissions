class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0 ; i < nums.length;i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) return x;
            nums[x-1] = nums[x-1] * -1;
        }
        return -1;
    }
}


// [4,2,3,1,2]