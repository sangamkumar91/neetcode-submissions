class Solution {
    public List<List<Integer>> threeSumHashMap(int[] nums) {
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

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();

        for (int i = 0 ; i < nums.length ; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int total = nums[i] + nums[l] + nums[r];
                if (total > 0) {
                    r--;
                    continue;
                }
                if (total < 0) {
                    l++;
                    continue;
                }
                List<Integer> list = new ArrayList();
                list.add(nums[i]);
                list.add(nums[l]);
                list.add(nums[r]);
                result.add(list);
                l++;
                r--;
                while (l != 0 && l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
                while (r != nums.length -1  && l < r && nums[r] == nums[r + 1]) {
                    r--;
                }
            }
        }
        return result;
    }

}
