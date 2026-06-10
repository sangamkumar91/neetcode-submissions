class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(new ArrayList(), nums, 0);
        return res;
    }

    public void backtrack(List<Integer> current, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList(current));
            return;
        }

        current.add(nums[index]);
        backtrack(current, nums, index + 1);
        current.remove(current.size() - 1);

        // this helps avoid duplicates
        //nums = [1,1]
        // if not added
        // [1, *] include i = 0 -> [[1, 1] include i = 1 and [1, x] exclude i = 1]
        // [x, *] skip i = 0 -> [[x, 1] include i = 1 and [x, x] exclude i = 1]
        // But it creates same subset. [1,x] and [x, 1] i.e [1]

        // instead we do 
        // [1, *] include i = 0 -> [[1, 1] include i = 1]
        // [x, *] skip i = 0 -> [[x, 1] include i = 1 and [x, x] exclude i = 1]
        // either [1,x] or [x, 1]created only once.
        int i = index + 1;
        while (i < nums.length && nums[i] == nums[i - 1]) i++;
        backtrack(current, nums, i);
    }
}
