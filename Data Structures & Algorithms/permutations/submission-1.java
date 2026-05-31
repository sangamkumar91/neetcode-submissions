class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        permute(nums, new HashSet(), new ArrayList(), result);
        return result;
    }
    public void permute(
        int[] nums,
        HashSet<Integer> visited,
        List<Integer> current,
        List<List<Integer>> result
    ) {
        if (current.size() == nums.length) {
            result.add(new ArrayList(current));
            return;
        }

        for (int num : nums) {
            if (visited.contains(num)) continue;
            visited.add(num);
            current.add(num);
            permute(nums, visited, current, result);
            visited.remove(num);
            current.remove(current.size() - 1);
        }
        
    }
}
