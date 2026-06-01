class Solution {
    public int jump(int[] nums) {
        //BFS
        int l = 0;
        int r = 0;
        int jumps = 0;
        while (r < nums.length - 1) {
            int farthest = 0;
            for (int j = l; j <= r; j++) {
                farthest = Math.max(farthest, j + nums[j]);
            }
            l++;
            r = farthest;
            jumps++;
        }

        return jumps;

        // DFS
        //return helper(nums, 0);
    }

    public int helper(int[] nums, int index) {
        if (index >= nums.length - 1)
            return 0;
        if (nums[index] == 0) return Integer.MAX_VALUE;

        int val = nums[index];
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= val ; i++)
            result = Math.min(result, helper(nums, index + i));

        return result + 1;
        
    }

}
