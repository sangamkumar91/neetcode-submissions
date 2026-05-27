class Solution {
    public int maxCoins(int[] nums) {
        HashSet<Integer> visited = new HashSet();
        HashMap<String, Integer> memo = new HashMap();
        return backtrack(nums, visited, memo);
    }
    public int backtrack(int[] nums, HashSet<Integer> visited, HashMap<String, Integer> memo) {
        int result = 0;
        if (visited.size() == nums.length) {
            return result;
        }
        String key = hashKey(nums, visited);
        if (memo.containsKey(key)) return memo.get(key);
        for (int i = 0 ; i < nums.length ; i++) {
            if (visited.contains(i)) continue;
            visited.add(i);
            int product = coinsPerBurst(nums, visited, i);
            result = Math.max(result, coinsPerBurst(nums, visited, i) + backtrack(nums, visited, memo));
            visited.remove(i);
        }
        memo.put(key, result);
        return result;
    }

    public int coinsPerBurst(int[] nums, HashSet<Integer> visited, int i) {
            int product = nums[i];
            int j = i - 1;
            while (j >= 0 && visited.contains(j)) {
                j--;
            }
            product = product * (j >= 0 ? nums[j] : 1);
            j = i + 1;
            while (j < nums.length && visited.contains(j)) {
                j++;
            }
            product = product * (j < nums.length ? nums[j] : 1);
            return product;
    }

    public String hashKey(int[] nums, HashSet<Integer> visited) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < nums.length ; i++) {
            if (visited.contains(i)) continue;
            sb.append(nums[i]);
            sb.append(",");
        }
        return sb.toString();
    }

}
