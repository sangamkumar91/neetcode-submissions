class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res.add(new ArrayList());
        // for (int i = 0 ; i < nums.length ; i++) {
        //     if (i > 0 && nums[i] == nums[i - 1]) continue;
        //     backtrack(new ArrayList(), nums, i);
        // }
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
