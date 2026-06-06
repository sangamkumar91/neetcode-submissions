class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(new ArrayList(), nums, 0);
        return res;
    }

    public void backtrack(List<Integer> current, int[] nums, int index) {
        res.add(new ArrayList(current));
        
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            backtrack(current, nums, i + 1);
            current.remove(current.size() - 1);
        }
        
    }

}
