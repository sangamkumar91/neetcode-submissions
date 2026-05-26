class Solution {
    HashMap<Integer, HashMap<Integer, Boolean>> memo = new HashMap();
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();

        if (total % 2 != 0) return false; 
        total = total/2;
        return dfs(nums, 0, total); 
    }

    public boolean dfs(int[] nums, int i, int target) {
        if (target == 0) return true;
        if (target < 0) return false;
        if (memo.containsKey(i) && memo.get(i).containsKey(target)) {
            return memo.get(i).get(target);
        }
        if (i == nums.length) return false;
        boolean result = dfs(nums, i + 1, target - nums[i]) || dfs(nums, i + 1, target);
        HashMap<Integer, Boolean> targetMemo = memo.getOrDefault(i, new HashMap());
        targetMemo.put(target, result);
        return result;
    }
}
