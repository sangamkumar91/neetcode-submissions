class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res.add(new ArrayList());
        backtrack(new ArrayList(), nums, 0);
        return res;
    }

    public void backtrack(List<Integer> current, int[] nums, int index) {
        if (index == nums.length) {
            if (current.size() != 0)
                res.add(new ArrayList(current));
            return;
        }

        current.add(nums[index]);
        backtrack(current, nums, index + 1);
        current.remove(current.size() - 1);

        index = index + 1;
        while (index < nums.length && nums[index] == nums[index - 1]) index++;
        backtrack(current, nums, index);
    }
}
