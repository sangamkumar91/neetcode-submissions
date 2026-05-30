class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        helper(result, nums, 0, target, new ArrayList());
        return result;

        
    }
    public void helper(List<List<Integer>> result, int[] nums, int index, int target, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList(current));
            return;
        }
        if (target < 0) return;

        for (int i = index; i < nums.length ; i++) {
            current.add(nums[i]);
            helper(result, nums, i, target - nums[i], current);
            current.remove(current.size() - 1);
        }

    }
}
