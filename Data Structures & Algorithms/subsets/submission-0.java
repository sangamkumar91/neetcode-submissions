class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> current = new ArrayList();
        backtrack(result, current, 0, nums);
        return result;
        
    }
    public void backtrack(
        List<List<Integer>> result,
        List<Integer> current,
        int index,
        int[] nums) {
            if (index >= nums.length) {
                System.out.println(current);
                result.add(new ArrayList(current));
                return;
            }

            current.add(nums[index]);
            backtrack(result, current, index + 1, nums);
            current.remove(current.size() - 1);
            backtrack(result, current, index + 1, nums);
        }
}
