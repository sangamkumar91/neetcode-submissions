class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        HashSet<String> visited = new HashSet();
        Arrays.sort(nums);

        for (int i = 0 ; i < nums.length ; i++) {
            HashMap<Integer, Integer> memo = new HashMap();
            int target = -1 * nums[i];
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1 ; j < nums.length ; j++) {
                int current = nums[j];
                if (memo.containsKey(current)) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(current);
                    list.add(nums[memo.get(current)]);
                    Collections.sort(list);
                    if (visited.contains(list.toString())) continue;
                    visited.add(list.toString());
                    result.add(list);
                    continue;
                }
                int diff = target - current;
                memo.put(diff, j);
            }
        }
        return result;
    }
}
