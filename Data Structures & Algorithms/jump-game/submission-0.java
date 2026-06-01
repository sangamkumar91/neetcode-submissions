class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];;
        int i = 0;

        while (maxReach >= i) {
            int currentReach = i + nums[i];
            maxReach = Math.max(maxReach, currentReach);

            if (maxReach >=  nums.length - 1) return true;
            i++;
        }

        return false;

    }
}
