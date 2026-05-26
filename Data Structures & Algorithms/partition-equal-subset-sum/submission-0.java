class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();

        if (total % 2 != 0) return false; 
        total = total/2;
        return dfs(nums, 0, total); 
    }

    public boolean dfs(int[] nums, int i, int target) {

        if (target == 0) return true;
        if (target < 0) return false;
        if (i == nums.length) return false;
        return dfs(nums, i + 1, target - nums[i]) || dfs(nums, i + 1, target);
    }
}
